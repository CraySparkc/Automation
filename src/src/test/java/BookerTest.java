import data.BookingDates;
import data.BookingResponse;
import data.ValueGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import data.Booking;
import org.junit.jupiter.api.Test;

public class BookerTest extends BaseTestApi {

    ValueGenerator gen = new ValueGenerator();

    @DisplayName("Тест на просмотр всех бронирований")
    @Test
    public void testGetAllBookings() {
        step("Направляем запрос");
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();

        step("Получаем ответ" + response.asString());
        List<Map<String, Object>> bookings = response.jsonPath().getList("$");
        assertThat(bookings).isNotEmpty();
    }

    @DisplayName("Тест получить бронирование по id")
    @Test
    public void testGetBookingById() {
        step("Сначала создаем бронирование");
        Booking booking = createTestBooking();
        Integer bookingId = createBooking(booking);

        step("Направляем запрос");
        Booking retrievedBooking = given()
                .spec(requestSpec)
                .when()
                .get("/booking/{id}", bookingId)
                .then()
                .statusCode(200)
                .extract()
                .as(Booking.class);

        step("Проверки");
        assertThat(retrievedBooking.getFirstname()).isEqualTo(booking.getFirstname());
        assertThat(retrievedBooking.getLastname()).isEqualTo(booking.getLastname());
        assertThat(retrievedBooking.getTotalprice()).isEqualTo(booking.getTotalprice());
    }

    @DisplayName("Тест создания бронирования")
    @Test
    public void testCreateBooking() {
        step("Создаем бронирование");
        Booking booking = createTestBooking();

        step("Направляем запрос");
        BookingResponse response = given()
                .spec(requestSpec)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .as(BookingResponse.class);

        step("Проверки");
        assertThat(response.getBookingid()).isNotNull();
        assertThat(response.getBooking().getFirstname()).isEqualTo(booking.getFirstname());
    }

    @DisplayName("Тест создания бронирования - тот который работает")
    @Test
    public void sampleTestCreateBooking() {
        //Везде кроме такого подхода выдает в респонсе 418 код - I'm a Teapot - похоже на защиту от ботов, но очень не хотелось бы ООПшный код переделывать из-за этого
        Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2024-01-01");
        bookingDates.put("checkout", "2024-01-05");

        Map<String, Object> bookingData = new HashMap<>();
        bookingData.put("firstname", "John");
        bookingData.put("lastname", "Doe");
        bookingData.put("totalprice", 150);
        bookingData.put("depositpaid", true);
        bookingData.put("bookingdates", bookingDates);
        bookingData.put("additionalneeds", "Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(bookingData)
                .when()
                .post(RestAssured.baseURI + "/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("John"))
                .body("booking.lastname", equalTo("Doe"))
                .extract()
                .response();

        int bookingId = response.jsonPath().getInt("bookingid");
        System.out.println("Created booking with ID: " + bookingId);
    }

    @DisplayName("Тест обновления бронирования")
    @Test
    public void testUpdateBooking() {
        step("Создаем бронирование");
        Booking booking = createTestBooking();
        Integer bookingId = createBooking(booking);

        step("Обновляем бронирование");
        Booking updatedBooking = Booking.builder()
                .firstname("путю")
                .lastname("UpdatedLastName")
                .totalprice(2000)
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin(LocalDate.now().plusDays(5))
                        .checkout(LocalDate.now().plusDays(10))
                        .build())
                .additionalneeds("Breakfast")
                .build();

        step("Получаем ответ");
        Booking responseBooking = given()
                .spec(requestSpec)
                .header("Cookie", "token=" + token)
                .body(updatedBooking)
                .when()
                .put("/booking/{id}", bookingId)
                .then()
                .statusCode(200)
                .extract()
                .as(Booking.class);

        step("Проверки");
        assertThat(responseBooking.getFirstname()).isEqualTo("UpdatedName");
        assertThat(responseBooking.getTotalprice()).isEqualTo(200);
    }

    @DisplayName("Тест удаления бронирования")
    @Test
    public void testDeleteBooking() {
        step("Создаем бронирование");
        Booking booking = createTestBooking();
        Integer bookingId = createBooking(booking);

        step("Удаляем бронирование");
        given()
                .spec(requestSpec)
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/{id}", bookingId)
                .then()
                .statusCode(201);

        step("Проверяем что бронирование удалено");
        given()
                .spec(requestSpec)
                .when()
                .get("/booking/{id}", bookingId)
                .then()
                .statusCode(404);
    }

    // Вспомогательные методы
    private Booking createTestBooking() {
        return Booking.builder()
                .firstname(gen.generateFirstName())
                .lastname(gen.generateLastName())
                .totalprice(gen.generateInt())
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin(LocalDate.now().plusDays(1))
                        .checkout(LocalDate.now().plusDays(3))
                        .build())
                .additionalneeds("Breakfast")
                .build();
    }

    private Integer createBooking(Booking booking) {
        return given()
                .spec(requestSpec)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");
    }
}

package data;
import com.github.javafaker.Faker;

import java.util.Random;


public class ValueGenerator {
    StateAndCity stateAndCity = new StateAndCity();
    private  final Faker faker = new Faker();
    protected int state = new Random().nextInt(stateAndCity.getStates().toArray().length);
    protected int city = new Random().nextInt(stateAndCity.getCities(stateAndCity.getStates().toArray()[state].toString()).toArray().length);

    public int generateInt(){
        return faker.number().numberBetween(2000, 5000);
    }

    public String generateFirstName(){
        return faker.name().firstName();
    }

    public String generateLastName(){
        return faker.name().lastName();
    }

    public String generateEmail(){
        return faker.internet().emailAddress();
    }

    public String generateGender(){
        int gender = new Random().nextInt(Gender.values().length);
        return String.valueOf(Gender.values()[gender].getGender());
    }

    public String generatePhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String generateDay() {
        int day = new Random().nextInt(28) + 1;

        if (day <= 9) {
            return "0" + day;
        } else {
            return String.valueOf(day);
        }
    }

    public String generateMonth() {
        int month = new Random().nextInt(Months.values().length);
        return String.valueOf(Months.values()[month].getMonth());
    }

    public String generateYear() {
        return String.valueOf(faker.number().numberBetween(1921, 2007));
    }

    public String generateSubject(){
        int subj = new Random().nextInt(Subject.values().length);
        return String.valueOf(Subject.values()[subj].getSubject());
    }

    public String generateHobbie(){
        int hob = new Random().nextInt(Hobbies.values().length);
        return String.valueOf(Hobbies.values()[hob].getHobbie());
    }

    public String generateState(){
        return stateAndCity.getStates().toArray()[state].toString();
    }

    public String generateCity(){
        return stateAndCity.getCities(stateAndCity.getStates().toArray()[state].toString()).toArray()[city].toString();
    }

    public String generateAddress() {
        return faker.address().streetAddress();
    }
}

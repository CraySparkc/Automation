package data;

public class PracticeData {
    private final ValueGenerator gen = new ValueGenerator();

    public static final String PICTURE = "qa.jpg";

    public String firstName = gen.generateFirstName();
    public String lastName = gen.generateLastName();
    public String email = gen.generateEmail();
    public String gender = gen.generateGender();
    public String mobilePhone = gen.generatePhone();
    public String dayOfBirth = gen.generateDay();
    public String monthOfBirth = gen.generateMonth();
    public String yearOfBirth = gen.generateYear();
    public String subject = gen.generateSubject();
    public String hobbie = gen.generateHobbie();
    public String address = gen.generateAddress();
    public String state = gen.generateState();
    public String city = gen.generateCity();
}

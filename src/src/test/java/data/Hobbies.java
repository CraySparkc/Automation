package data;

public enum Hobbies {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String hobbie;

    Hobbies(String hobbie){
        this.hobbie = hobbie;
    }

    public String getHobbie(){
        return hobbie;
    }
}

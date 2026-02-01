package data;

public enum Subject {

    HINDI("Hindi"),
    ENGLISH("English"),
    MATHS("Maths"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    BIOLOGY("Biology"),
    COMPUTER_SCIENCE("Computer Science"),
    COMMERCE("Commerce"),
    ACCOUNTING("Accounting"),
    ECONOMICS("Economics"),
    ARTS("Arts"),
    SOCIAL_STUDIES("Social Studies"),
    HISTORY("History"),
    CIVICS("Civics");

    private final String subject;

    Subject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
}
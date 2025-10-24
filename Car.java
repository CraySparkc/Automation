import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
    void MakeBeBe(){
        System.out.println("🚗 " + this.model + " "+ this.year + " : делает УИУИУИ");
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

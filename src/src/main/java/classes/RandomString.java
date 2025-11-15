package classes;

import java.util.Random;

public class RandomString {
    final private String[] strings = {
            "Первая строка",
            "Вторая строка",
            "Третья строка"
    };
    final private Random random = new Random();

    public void printRandomString() {
        int index = random.nextInt(strings.length); // Генерирует 0, 1 или 2
        System.out.println(strings[index]);
    }
}
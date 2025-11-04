//Для данного задания я взял пример для настольной игры ДНД
//Описанный ниже код представляет собой маленький кусочек из игровой механики:
//определяет значения модификатора характеристи по правилам заложенным в данной системе НРИ

import java.util.Scanner;

class Character{
    String className;
    String characterName;
    static int strength = 15;
    static int endurance = 13;
    static int intelligence = 9;

    void FindCharacteristicsModifiers () {
        if(strength > 10){
            int modifier = (strength - 10)/2;
            System.out.println("Модификатор силы равен: " + "+" + modifier);
        } else {
            int modifier = (11 - strength )/2;
            System.out.println("Модификатор силы равен: " + "-" + modifier);
        }
        if(endurance > 10){
            int modifier = (endurance - 10)/2;
            System.out.println("Модификатор выносливости равен: " + "+" + modifier);
        } else {
            int modifier = (11 - endurance )/2;
            System.out.println("Модификатор выносливости равен: " + "-" + modifier);
        }
        if(intelligence > 10){
            int modifier = (intelligence - 10)/2;
            System.out.println("Модификатор интелекта равен: " + "+" + modifier);
        } else {
            int modifier = (11 - intelligence )/2;
            System.out.println("Модификатор интелекта равен: " + "-" + modifier);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Character Warior = new Character();
        Warior.className = "Warior";
        Warior.characterName = "King Arthur";
        Warior.FindCharacteristicsModifiers();
        System.out.println("Настало время машинки из 4 задания");
        Car Sonata = new Car("Hyundai Sonata", 2022);
        System.out.println("Создана машина: " + Sonata.getModel()+ " " + Sonata.getYear());
        Sonata.MakeBeBe();
        System.out.println("Приактическое задание 5:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада: ");
        float summ = scanner.nextFloat();
        System.out.println("Введите количество месяцев: ");
        int months = scanner.nextInt();
        System.out.println("Вклад на сумму "+summ+" на " + months + " месяцев");
        System.out.format("Финальная сумма вклада через цикл FOR: %.2f", FinalSummFOR(summ, months));
        System.out.format("\nФинальная сумма вклада через цикл WHILE: %.2f", FinalSummWHILE(summ, months));
        System.out.println("Приактическое задание 6:");
        String[] stringArray = new String[]{"привет", "ПОКА", "гипербола"};
        System.out.println("Первая строка в верхнем регистре");
        System.out.println(stringArray[0].toUpperCase());
        System.out.println("Вторая строка в нижнем регистре");
        System.out.println(stringArray[1].toLowerCase());
        System.out.println("Вывести из массива третью строку, в которой третья буква будет «О», а между третьей и четвертой буквой будет «пробел»");
        //гиО ербола
        String result = stringArray[2].substring(0,2) + stringArray[1].charAt(stringArray[1].indexOf("О")) + " " + stringArray[2].substring(3);
        System.out.println(result);
        Manager ivan = new Manager("Иван", 200000);
        Developer denis = new Developer("Денис", 250000);
        ivan.work();
        denis.work();
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        c.draw();
        r.draw();
        Guitar guitar = new Guitar("Yamaha FGX5");
        Piano piano = new Piano("YAMAHA M3 SM");
        guitar.playWithEnum();
        piano.playWithEnum();
    }
    static float FinalSummFOR(float s, int m){
        for (int i=0; i<m; i++){
            s = (float) (s * 1.07);
        }
        return s;
    }
    static float FinalSummWHILE(float s, int m){
        int i=0;
        while(i<m){
            s = (float) (s * 1.07);
            i++;
        }
        return s;
    }
}
//Для данного задания я взял пример для настольной игры ДНД
//Описанный ниже код представляет собой маленький кусочек из игровой механики:
//определяет значения модификатора характеристи по правилам заложенным в данной системе НРИ

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
    }
}
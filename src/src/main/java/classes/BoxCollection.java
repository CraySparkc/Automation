package classes;

import java.util.ArrayList;

public class BoxCollection {
    private final ArrayList<Box> boxArrayList = new ArrayList<>();
    private final ArrayList<Box> boxArrayListSortedOver30 = new ArrayList<>();
    private final ArrayList<Box> boxArrayListSortedBelow30 = new ArrayList<>();

    public ArrayList<Box> getBoxArrayList() {
        return boxArrayList;
    }
    public ArrayList<Box> getBoxArrayListSortedOver30() {
        return boxArrayListSortedOver30;
    }
    public ArrayList<Box> getArrayListSortedBelow30() {
        return boxArrayListSortedBelow30;
    }

    public void generateBoxes(int number){
        for(int i=0; i<=number; i++){
            boxArrayList.add(new Box(rnd(20,40),rnd(20,40),rnd(20,40)));
        }
    }

    public void sortBoxes(){
        for(Box box : boxArrayList) {
            if (box.getWidth() > 30) {
                boxArrayListSortedOver30.add(box);
            } else if (box.getWidth() <= 30) {
                boxArrayListSortedBelow30.add(box);
            }
        }
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

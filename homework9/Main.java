package homework9;

/*
Написать обобщенный класс-контейнер.
Реализовать в нем параметризованный метод использующий wildcards.
Написать метод main демонстрирующий работу параметризованного класса.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        //Верхняя граница подстановки
        List<LittleBox> littleBoxes = new ArrayList<>();
        littleBoxes.add(new LittleBox("Toys"));
        littleBoxes.add(new LittleBox("Keys"));


        Shelf<SmallBox> pBox = new Shelf<>();

        pBox.add(new SmallBox("Pillows"));
        pBox.addAll(littleBoxes);

        //Нижняя граница подстановки
        Consumer<Object> objectConsumer = object -> System.out.println(object.hashCode());

        Consumer<Box> boxConsumer = boxes -> System.out.println(boxes.getName());

        Shelf<LittleBox> shelf2 = new Shelf<>();
        shelf2.add(new LittleBox("Maps"));
        shelf2.add(new LittleBox("Fishes"));
        shelf2.add(new LittleBox("Books"));
        shelf2.forEach(boxConsumer);
        shelf2.forEach(objectConsumer);
    }
}

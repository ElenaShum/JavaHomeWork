package homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Shelf <T extends Box>{

    private final List<T> boxes;

    public Shelf() {boxes = new ArrayList<>();}

    public void add(T t) {boxes.add(t);}

    public T get(int index) {return boxes.get(index);}

    // Верхняя граница подстановки
    public void addAll(List <? extends T> list) {boxes.addAll(list);} //? - wildcard/joker
    // принцип produser extends consumer super

    // Нижняя граница подстановки
    public void forEach(Consumer<? super T> consumer) {
        for(T box: boxes) {
            consumer.accept(box);
        }
    }
}

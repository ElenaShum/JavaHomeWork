package passengerCars.frontWheelDrive.chevrolet.aveo;

import passengerCars.frontWheelDrive.chevrolet.Chevrolet;

import java.util.Objects;

public class Aveo extends Chevrolet {

    private String color;
    boolean isConditioner;

    public Aveo() {
    }

    public Aveo(String color,boolean isConditioner) {
        super();
        this.color = color;
        this.isConditioner = isConditioner;
        //System.out.println("Создана машина выбранного цвета и выбрано наличие кондиционера");
    }

    public boolean getFrontWheelDrive() {
        return super.getFrontWheelDrive();
    }

    public String getBodyType() {
        return super.getBodyType();
    }

    public boolean getPassengerCars () {
        return super.getPassengerCars();
    }

    public int getSeatsCount() {
        return super.getSeatsCount();
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getIsConditioner() {
        return isConditioner;
    }

    public void setConditioner(boolean conditioner) {
        isConditioner = conditioner;
    }

    @Override
    public String toString() {
        return "Aveo{" +
                "color='" + color + '\'' +
                ", isConditioner=" + isConditioner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aveo aveo = (Aveo) o;
        return isConditioner == aveo.isConditioner && Objects.equals(color, aveo.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, isConditioner);
    }

    @Override
    public boolean isPassenger() {
        System.out.println("Автомобиль Авео пассажирский");
        return super.isPassenger();
    }
}



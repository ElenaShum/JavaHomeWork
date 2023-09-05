package passengerCars.frontWheelDrive;

import passengerCars.PassengerCars;

import java.util.Objects;

public class FrontWheelDrive extends PassengerCars {

    private boolean isFrontWheelDrive;

    public FrontWheelDrive() {
    }

    public FrontWheelDrive(boolean isFrontWheelDrive) {
        super();
        this.isFrontWheelDrive = isFrontWheelDrive;
    }

    public boolean getFrontWheelDrive() {
        return isFrontWheelDrive;
    }

    public void setFrontWheelDrive(boolean frontWheelDrive) {
        isFrontWheelDrive = frontWheelDrive;
    }

    @Override
    public String toString() {
        return "FrontWheelDrive{" +
                "isFrontWheelDrive=" + isFrontWheelDrive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrontWheelDrive that = (FrontWheelDrive) o;
        return isFrontWheelDrive == that.isFrontWheelDrive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFrontWheelDrive);
    }
}

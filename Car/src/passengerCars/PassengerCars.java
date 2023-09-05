package passengerCars;

import java.util.Objects;

public class PassengerCars {
    private  boolean isPassenger;
    private  int seatsCount;

    public PassengerCars() {
    }

    public PassengerCars(boolean isPassenger, int seatsCount) {
        this.isPassenger = isPassenger;
        this.seatsCount = seatsCount;
    }

    public void setPassengerCars(boolean passenger) {
        isPassenger = passenger;
    }

    public boolean getPassengerCars() {
        return isPassenger;
    }

    public void setSeatsCount(int seatsCount) {
        if (seatsCount > 0) {
            this.seatsCount = seatsCount;
        } else {
            System.out.println("Авто не может перевозить пассажиров");
        }
    }

    public int getSeatsCount() {
        return seatsCount;
    }


    public void start () {
        System.out.println("Авто завелось");
    }

    public void drive () {
        System.out.println("Авто поехало");
    }

    public void park() {
        System.out.println("Авто припарковалось");
    }

    @Override
    public String toString() {
        return "PassengerCars{" +
                "isPassenger=" + isPassenger +
                ", seatsCount=" + seatsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerCars that = (PassengerCars) o;
        return isPassenger == that.isPassenger && seatsCount == that.seatsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPassenger, seatsCount);
    }

    public boolean isPassenger() {
        System.out.println("Автомобиль пассажирский");
        return isPassenger;
    }
}

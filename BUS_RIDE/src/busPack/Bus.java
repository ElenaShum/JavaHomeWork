package busPack;

/**
 * Автобус что движется по остановкам. Имеет свой номер.
 */
public class Bus {
    private String busNumber;

    private String busModel;

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    public String getBusModel() {
        return busModel;
    }


}

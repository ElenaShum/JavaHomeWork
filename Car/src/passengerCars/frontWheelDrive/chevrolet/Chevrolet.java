package passengerCars.frontWheelDrive.chevrolet;

import passengerCars.frontWheelDrive.FrontWheelDrive;

public class Chevrolet extends FrontWheelDrive {

private String bodyType;

    public Chevrolet() {
    }

    public Chevrolet(String bodyType) {
        super();

    }

    public void setBodyType(String bodyType) {
        if(bodyType.equals("sedan") || bodyType.equals("hatchback") ) {
            this.bodyType = bodyType;
        }
    }

    public String getBodyType() {
        return bodyType;
    }


}

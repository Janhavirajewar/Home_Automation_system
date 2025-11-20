package p2;

public class Fan extends Device {

    double speed;

    public Fan(String name, double speed) {
        super(name);
        this.speed = speed;
    }

    double getSpeed() {
        return speed;
    }

    void setSpeed(double s) {
        this.speed = s;
    }

    @Override
    public void turnOn() {
        if (!isOn()) {   // fan is OFF
            setOn(true);
            System.out.println("FAN turned on");
        } else {
            System.out.println("FAN is already ON");
        }
    }

    @Override
    public void turnOff() {
        if (isOn()) {   // fan is ON
            setOn(false);
            System.out.println("FAN turned off");
        } else {
            System.out.println("FAN is already OFF");
        }
    }

    @Override
    public boolean getStatus() {
        return isOn();
    }

    public double incSpeed() {
        if (!isOn()) {
            System.out.println(name + " Fan is OFF. Turn it ON first.");
            return speed;
        }

        if (speed < 5) {
            setSpeed(speed + 1);
        } else {
            System.out.println(name + " Fan is already at maximum speed (" + speed + ").");
        }

        return speed;
    }

    public double decSpeed() {
        if (!isOn()) {
            System.out.println(name + " Fan is OFF. Turn it ON first.");
            return speed;
        }

        if (speed > 0) {
            setSpeed(speed - 1);
        } else {
            System.out.println(name + " Fan is already at minimum speed (" + speed + ").");
        }

        return speed;
    }
}

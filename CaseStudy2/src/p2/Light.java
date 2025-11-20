package p2;

import p3.brightable;

public class Light extends Device implements brightable {
	
    private int brightness;
	
    public Light(String name, int brightness) {	
        super(name);                     	
        this.brightness = brightness;    
    }

    @Override
    public void turnOn() {	
        if (!isOn) {
            setOn(true);
            System.out.println(name + " Light turned ON. Brightness: " + brightness + "%");
        } else {
            System.out.println(name + " Light is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            setOn(false);
            System.out.println(name + " Light turned OFF.");
        } else {
            System.out.println(name + " Light is already OFF.");
        }
    }

    @Override
    public boolean getStatus() {
        return isOn();
    }

    @Override
    public void setBrightness(int bright) {
        if (bright < 0 || bright > 100) {
            System.out.println("Brightness must be between 0 and 100%");
        } else {
            this.brightness = bright;
            System.out.println(name + " brightness set to " + bright + "%");
        }
    }

    @Override
    public int getBrightness() {
        return brightness;
    }
}





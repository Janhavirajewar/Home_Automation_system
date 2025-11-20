package p2;

import p3.brightable;
import p3.volumecontrol;

public class TV extends Device implements brightable, volumecontrol {

    private int volume;
    private int channel;
    private int brightness;

    public TV(String name, int volume, int channel) {
        super(name);
        this.volume = volume;
        this.channel = channel;
        this.brightness = 50; // default brightness
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            setOn(true);
            System.out.println(name + " Television turned ON. (Channel: " + channel + ")");
        } else {
            System.out.println(name + " Television is already ON.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            setOn(false);
            System.out.println(name + " Television turned OFF.");
        } else {
            System.out.println(name + " Television is already OFF.");
        }
    }

    @Override
    public boolean getStatus() {
        return isOn();
    }

    @Override
    public void setBrightness(int bright) {
        if (bright >= 0 && bright <= 100) {
            this.brightness = bright;
            System.out.println(name + " brightness set to " + bright + "%");
        } else {
            System.out.println("Invalid brightness level (0–100).");
        }
    }

    @Override
    public int getBrightness() {
        return brightness;
    }

    @Override
    public void increaseVolume(int level) {
        if (isOn()) {
            if (volume + level <= 100) {
                volume += level;
                System.out.println(name + " volume increased to " + volume);
            } else {
                System.out.println(name + " volume is already at maximum (100).");
            }
        } else {
            System.out.println(name + " Television is OFF. Turn it ON first.");
        }
    }

    @Override
    public void decreaseVolume(int level) {
        if (isOn()) {
            if (volume - level >= 0) {
                volume -= level;
                System.out.println(name + " volume decreased to " + volume);
            } else {
                System.out.println(name + " volume is already at minimum (0).");
            }
        } else {
            System.out.println(name + " Television is OFF. Turn it ON first.");
        }
    }

    @Override
    public int getVolume() {
        return volume;
    }

    public void setChannel(int channel) {
        if (!isOn()) {
            System.out.println(name + " Television is OFF. Turn it ON first.");
            return;
        }

        if (channel > 0 && channel <= 999) { // assume max 999 channels
            this.channel = channel;
            System.out.println(name + " switched to channel " + channel);
        } else {
            System.out.println("Invalid channel number. Please choose between 1–999.");
        }
    }

    public void nextChannel() {
        if (!isOn()) {
            System.out.println(name + " Television is OFF. Turn it ON first.");
            return;
        }

        if (channel < 999) {
            channel++;
            System.out.println(name + " moved to next channel: " + channel);
        } else {
            System.out.println(name + " is already at the highest channel (999).");
        }
    }

    public void previousChannel() {
        if (!isOn()) {
            System.out.println(name + " Television is OFF. Turn it ON first.");
            return;
        }

        if (channel > 1) {
            channel--;
            System.out.println(name + " moved to previous channel: " + channel);
        } else {
            System.out.println(name + " is already at the lowest channel (1).");
        }
    }

    public int getChannel() {
        return channel;
    }
}
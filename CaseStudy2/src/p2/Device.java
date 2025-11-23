package p2;

import p3.switchable;

public abstract class Device implements switchable
{

	String name;
	boolean isOn;


	Device(String name, boolean isOn, long starttime, long totaltime)
	{
		super();
		this.name = name;
		this.isOn = isOn;
		
	}

	public Device(String name) {
	    this(name, false, 0, 0); 
		}
	
	public String getName() {
		return name;
	}



	void setName(String name) {
		this.name = name;
	}



	boolean isOn() {
		return isOn;
	}



	void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	@Override
	public String toString()
	{
		return "Device [name=" + name + ", isOn=" + isOn+ "]";
	}

	
		public abstract void turnOn();
	    public abstract void turnOff();
	    public abstract boolean getStatus();
}

package p2;

import java.util.ArrayList;

public class Rooms {

	int id;
	String roomName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	ArrayList<Device> devList;

	// constructor
	public Rooms(int id, String roomName) {
		this.id = id;
		this.roomName = roomName;

		devList = new ArrayList<Device>();
	}

	public void addDevice(Device de) {

		devList.add(de);
		System.out.println("\nDevice added successfully");

	}

//	public Device getDevice(String name) 
//	{
//		for (Device devices : devList) {
//			
//			if (devices.getName().equals(name)) {
//				System.out.println();
//				System.out.println(devices.getName() + " found in " + roomName);
//				return devices;	
//			}
//		}
//		return null;
//		
//	}
	
	
	public Device getDevice(String name) {
	    try {
	        for (Device d : devList) {
	            if (d.getName().equalsIgnoreCase(name)) {
	              System.out.println();
	            	System.out.println(d.getName() + " found in " + roomName);
	            	
	            }
	        }
	        
	        throw new DeviceNotFoundException("Device '" + name + "' not found!");
	    } 
	    
	    catch (DeviceNotFoundException e) {
	        System.out.println(e.getMessage());
	        return null;
	    }
	}

	
	public void removeDevice(String name) {
		Device d =getDevice(name);

		if (d!=null) {
			devList.remove(d);
			
	        System.out.println(d.getName() + " removed successfully from " + roomName);
		}
			
		
	}
	
	public void showAllDevices() 
	{
	    if (devList.isEmpty()) {
	        System.out.println("No devices found in " + roomName);
	        return;
	    }

	    System.out.println("\nDevices in " + roomName + ":");
	    for (Device d : devList) {

	        String status = d.getStatus() ? "ON" : "OFF";
	        System.out.print("→ " + d.getName() + " [" + status);

	        // Add details by device type
	        if (d instanceof Light) {
	            Light l = (Light) d;
	            System.out.print(", Brightness: " + l.getBrightness());
	        }
	        else if (d instanceof Fan) {
	            Fan f = (Fan) d;
	            System.out.print(", Speed: " + f.getSpeed());
	        }
	        else if (d instanceof TV) {
	            TV tv = (TV) d;
	            System.out.print(", Volume: " + tv.getVolume());
	            System.out.print(", Channel: " + tv.getChannel());
	        }

	        System.out.println("]");
	    }
	}

	
	public void turnOnDevice(String name) {
	    Device d = getDevice(name);
	    if (d != null) {
	        d.turnOn();
	    } else {
	        System.out.println("Device " + name + " not found in " + roomName);
	    }
	}

	public void turnOffDevice(String name) {
	    Device d = getDevice(name);
	    if (d != null) {
	        d.turnOff();
	    } else {
	        System.out.println("Device " + name + " not found in " + roomName);
	    }
	}

}
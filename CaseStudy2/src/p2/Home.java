package p2;

import java.util.ArrayList;

public class Home {

    String homeName;
    ArrayList<Rooms> rooms = new ArrayList<Rooms>();

    // constructor
    public Home(String name)
    {
        homeName = name;
        System.out.println("Home created:" +name);
    }

    public void addRoom(Rooms r)
    {
        rooms.add(r);
        System.out.println("\nRoom added : " + r.getRoomName());
    }

    public void removeRoom(String name)
    {
        Rooms temp = getRoom(name);
        if (temp != null)
        {
            rooms.remove(temp);
            System.out.println("room removed : " + name);
        } else 
        {
            System.out.println("room not found");
        }
    }

//    public Rooms getRoom(String name) {
//        for (Rooms r : rooms) {
//            if (r.getRoomName().equalsIgnoreCase(name)) {
//                System.out.println("room found : " + r.getRoomName());
//                return r;
//            }
//        }
//        System.out.println("no such room found : " + name);
//        return null;
//    }
    
    
    public Rooms getRoom(String name) {
        try {
            for (Rooms r : rooms) {
                if (r.getRoomName().equalsIgnoreCase(name))
                {
                	 System.out.println("room found : " + r.getRoomName());
                    return r;
                }
            }
            throw new RoomNotFoundException("Room '" + name + "' not found!");
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    

    public void showAllRooms() 
    {
        if (rooms.size() == 0) 
        {
            System.out.println("no rooms in home " + homeName);
        } 
        
        else
        {
            System.out.println("rooms inside home : ");
            for (int i = 0; i < rooms.size(); i++) {
                System.out.println((i + 1) + ". " + rooms.get(i).getRoomName());
            }
        }
    }

    public void showHomeStatus() {
      
        if (rooms.size() == 0) {
            System.out.println("no rooms yet...");
        } else {
            for (Rooms r : rooms)
            {
                System.out.println("Room : " + r.getRoomName());
                r.showAllDevices();
            }
        }
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String newName) {
        homeName = newName;
    }
}
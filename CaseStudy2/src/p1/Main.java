package p1;

import java.util.Scanner;
import p2.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Home home = new Home("Smart Home");
        int ch;

        do {
        	
            System.out.println("\n==== SMART HOME MENU ====\n");
            System.out.println("1. Add Room");
            System.out.println("2. Add Device to Room");
            System.out.println("3. Turn ON Device");
            System.out.println("4. Turn OFF Device");
            System.out.println("5. Access Device Features");
            System.out.println("6. Show Home Status");
            System.out.println("7. Remove Device");
            System.out.println("9. Exit");
            System.out.print("\nEnter choice: \n");
            ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) 
            {

                case 1:  // Add Room
                    System.out.print("Enter Room ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Room Name: ");
                    String name = sc.nextLine();
                    Rooms room = new Rooms(id, name);
                    home.addRoom(room);
                    break;

                case 2:  
                	
                    home.showAllRooms();
                   
                    System.out.print("\nEnter Room Name: ");
                    
                    String roomName = sc.nextLine();
                    Rooms r1 = home.getRoom(roomName);

                    if (r1 == null) {
                        System.out.println("Room not found");
                        break;
                    }
                    System.out.println();
                    System.out.println("1. Light");
                    System.out.println("2. Fan");
                    System.out.println("3. Television");
                  System.out.println();
                    System.out.print("Enter device type: ");
                    int t = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Device Name: ");
                    String dName = sc.nextLine();
                    Device d = null;


                    if (t == 1) {
                        System.out.print("Enter Brightness (0-100): ");
                        int b = sc.nextInt();
                        d = new Light(dName, b);
                        
                    } 
                    else if (t == 2) {
                        System.out.print("Enter Speed (1-5): ");
                        int s = sc.nextInt();
                        d = new Fan(dName, s);
                    } 
                    else if (t == 3) {
                        System.out.print("Enter Volume: ");
                        int vol = sc.nextInt();
                        System.out.print("Enter Channel: ");
                        int chh = sc.nextInt();
                        d = new TV(dName, vol, chh);
                    } 
                    else {
                        System.out.println("Invalid Type");
                        break;
                    }

                    r1.addDevice(d);
                    System.out.println(d.getName() + " added in " + r1.getRoomName());
                    break;

                case 3:  // Turn ON Device
                    System.out.print("Enter Room Name: ");
                    String rnOn = sc.nextLine();
                    Rooms r2 = home.getRoom(rnOn);
                    if (r2 != null) {
                        System.out.print("Enter Device Name to Turn ON: ");
                        String dnOn = sc.nextLine();
                        r2.turnOnDevice(dnOn);
                    } else {
                        System.out.println("Room not found");
                    }
                    break;

                case 4:  // Turn OFF Device
                    System.out.print("Enter Room Name: ");
                    String rnOff = sc.nextLine();
                    Rooms r3 = home.getRoom(rnOff);
                    if (r3 != null) {
                        System.out.print("Enter Device Name to Turn OFF: ");
                        String dnOff = sc.nextLine();
                        r3.turnOffDevice(dnOff);
                    } else {
                        System.out.println("Room not found");
                    }
                    break;

                case 5:  // Device Features
                    System.out.print("Enter Room Name: ");
                    String n = sc.nextLine();
                    Rooms r4 = home.getRoom(n);
                    
                    if (r4 == null) {
                        System.out.println("Room not found");
                        break;
                    }

                    System.out.print("Enter Device Name: ");
                    String n1 = sc.nextLine();
                    
                    Device dev = r4.getDevice(n1);

                    if (dev == null) {
                        System.out.println("Device not found");
                        break;
                    }

                    if (dev instanceof Light) {
                        Light l = (Light) dev;
                        System.out.print("Enter Brightness (0-100): ");
                        l.setBrightness(sc.nextInt());
                       
                    } 
                    
                    else if (dev instanceof Fan)
                    
                    {
                        Fan f = (Fan) dev;
                        System.out.println("1. Increase Speed  2. Decrease Speed");
                        int opt = sc.nextInt();
                        if (opt == 1) f.incSpeed();
                        else f.decSpeed();
                        
                    } 
                    
                    
                    else if (dev instanceof TV) 
                    
                    {
                        TV tv = (TV) dev;
                        System.out.println("1. Change Channel");
                        System.out.println("2. Increase Volume");
                        System.out.println("3. Decrease Volume");
                        System.out.println("4. Set Brightness");
                        int opt = sc.nextInt();
                        
                        if (opt == 1) 
                        {
                            System.out.print("Enter Channel: ");
                            tv.setChannel(sc.nextInt());
                        } else if (opt == 2) tv.increaseVolume(5);
                        else if (opt == 3) tv.decreaseVolume(5);
                        else if (opt == 4) {
                            System.out.print("Enter Brightness: ");
                            tv.setBrightness(sc.nextInt());
                        }
                    } 
                    break;

                case 6:  // Show Home Status
                    home.showHomeStatus();
                    break;

                case 7:  // Remove Device
                    System.out.print("Enter Room Name: ");
                    String n2 = sc.nextLine();
                    Rooms r5 = home.getRoom(n2);
                    if (r5 != null) {
                        System.out.print("Enter Device Name to Remove: ");
                        r5.removeDevice(sc.nextLine());
                    } else {
                        System.out.println("Room not found");
                    }
                    break;

                case 8:
                    System.out.println("\nExiting Smart Home...");
                    break;

                default:
                    System.out.println("\nInvalid choice!");
            }

        } while (ch != 9);  // repeat until user selects Exit

        sc.close();
     
    }

}

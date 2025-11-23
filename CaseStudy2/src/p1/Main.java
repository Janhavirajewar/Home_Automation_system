package p1;

import java.util.InputMismatchException;
import java.util.Scanner;
import p2.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Home home = new Home("Smart Home");
        int ch = 0;

        do {
            try {

                System.out.println("\n==== SMART HOME MENU ====\n");
                System.out.println("1. Add Room");
                System.out.println("2. Add Device to Room");
                System.out.println("3. Turn ON Device");
                System.out.println("4. Turn OFF Device");
                System.out.println("5. Access Device Features");
                System.out.println("6. Show Home Status");
                System.out.println("7. Remove Device");
                System.out.println("9. Exit");
                System.out.print("\nEnter choice: ");

                ch = Integer.parseInt(sc.nextLine());   // catch invalid number

                switch (ch) {

                    case 1: // Add Room
                        System.out.print("Enter Room ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter Room Name: ");
                        String name = sc.nextLine();

                        if (name.trim().isEmpty())
                            throw new Exception("Room name cannot be empty!");

                        home.addRoom(new Rooms(id, name));
                        break;

                    case 2:
                        home.showAllRooms();
                        System.out.print("\nEnter Room Name: ");
                        String roomName = sc.nextLine();

                        Rooms r1 = home.getRoom(roomName);
                        if (r1 == null) break;

                        System.out.println("\n1. Light");
                        System.out.println("2. Fan");
                        System.out.println("3. Television");

                        System.out.print("Enter Device Type: ");
                        int type = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Device Name: ");
                        String dName = sc.nextLine();

                        Device d = null;

                        if (type == 1) {
                            System.out.print("Enter Brightness (0-100): ");
                            int b = Integer.parseInt(sc.nextLine());
                            d = new Light(dName, b);
                        } else if (type == 2) {
                            System.out.print("Enter Speed (1-5): ");
                            int s = Integer.parseInt(sc.nextLine());
                            d = new Fan(dName, s);
                        } else if (type == 3) {
                            System.out.print("Enter Volume: ");
                            int v = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Channel: ");
                            int c = Integer.parseInt(sc.nextLine());
                            d = new TV(dName, v, c);
                        } else {
                            System.out.println("Invalid type!");
                            break;
                        }

                        r1.addDevice(d);
                        break;

                    case 3: // Turn ON Device
                        System.out.print("Enter Room Name: ");
                        Rooms r2 = home.getRoom(sc.nextLine());
                        if (r2 == null) break;

                        System.out.print("Enter Device Name: ");
                        r2.turnOnDevice(sc.nextLine());
                        break;

                    case 4: // Turn OFF Device
                        System.out.print("Enter Room Name: ");
                        Rooms r3 = home.getRoom(sc.nextLine());
                        if (r3 == null) break;

                        System.out.print("Enter Device Name: ");
                        r3.turnOffDevice(sc.nextLine());
                        break;

                    case 5: // Device Features
                        System.out.print("Enter Room Name: ");
                        Rooms r4 = home.getRoom(sc.nextLine());
                        if (r4 == null) break;

                        System.out.print("Enter Device Name: ");
                        Device dev = r4.getDevice(sc.nextLine());
                        if (dev == null) break;

                        if (dev instanceof Light) {
                            System.out.print("Enter Brightness (0-100): ");
                            int b = Integer.parseInt(sc.nextLine());
                            ((Light) dev).setBrightness(b);
                        }

                        else if (dev instanceof Fan) {
                            System.out.println("1. Increase Speed  2. Decrease Speed");
                            int opt = Integer.parseInt(sc.nextLine());
                            if (opt == 1) ((Fan) dev).incSpeed();
                            else ((Fan) dev).decSpeed();
                        }

                        else if (dev instanceof TV) {
                            System.out.println("1. Change Channel");
                            System.out.println("2. Increase Volume");
                            System.out.println("3. Decrease Volume");
                            System.out.println("4. Set Brightness");
                            int opt = Integer.parseInt(sc.nextLine());

                            TV tv = (TV) dev;

                            if (opt == 1) {
                                System.out.print("Enter Channel: ");
                                tv.setChannel(Integer.parseInt(sc.nextLine()));
                            } else if (opt == 2) tv.increaseVolume(5);
                            else if (opt == 3) tv.decreaseVolume(5);
                            else if (opt == 4) {
                                System.out.print("Enter Brightness: ");
                                tv.setBrightness(Integer.parseInt(sc.nextLine()));
                            }
                        }
                        break;

                    case 6:
                        home.showHomeStatus();
                        break;

                    case 7:
                        System.out.print("Enter Room Name: ");
                        Rooms r5 = home.getRoom(sc.nextLine());
                        if (r5 == null) break;

                        System.out.print("Enter Device Name to Remove: ");
                        r5.removeDevice(sc.nextLine());
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } // try ends here
            
            catch (NumberFormatException e) 
            {
                System.out.println("\nInvalid input! Enter numbers only.");
            } 
            
            catch (InputMismatchException e)
            {
                System.out.println("\nInvalid input type!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (ch != 9);

        sc.close();
    }
}

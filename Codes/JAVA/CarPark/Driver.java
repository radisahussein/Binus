package CarPark;

import java.util.Scanner;


public class Driver 
{
    public static void main (String[] args)
    {

        Parking p1 = new Parking();
        Scanner sc = new Scanner(System.in);
        

        while (true)
        {
            System.out.println("==============================");
            System.out.println("Welcome to Rizky's Carpark");
            System.out.println();
            System.out.println("Please Choose one of the following:");
            System.out.println("1: Park Vehicle");
            System.out.println("2: Leave ");
            System.out.println("3: Show Parked Vehicles");
            System.out.println("4: Exit");
            System.out.println("==============================");

            System.out.print("Choose menu: ");
            int input = sc.nextInt();
            System.out.println("==============================");
            switch (input)
            {
                case 1:

                    System.out.print("Enter Car Brand: ");
                    String carBrand = sc.next();

                    System.out.println("==============================");
                    System.out.println("Please Choose Vehicle Type");
                    System.out.println("P = Private Car");
                    System.out.println("V = Van");
                    System.out.println("T = Truck");
                    System.out.print("Enter Vehicle Type: ");
                    String carType = sc.next();

                    System.out.println("==============================");
                    System.out.print("Enter Plate Number: ");
                    String plateNumber = sc.next();

                    Car newCar = new Car(carBrand,carType,plateNumber);
                    p1.addCar(newCar);

                    break;

                case 2:
                    
                    System.out.println("Enter Plate Number: ");
                    String plateNumberLeave = sc.next();

                    if(p1.checkPlate(plateNumberLeave) == true)
                    {
                        p1.removeCar(plateNumberLeave);
                        System.out.print("Bye!");
                    }

                    else
                    {
                        System.out.println("Car matching plate number not found!");
                    }


                    break;

                case 3:
                    System.out.println("Parked Cars: ");
                    System.out.println();
                    p1.showAllCars();
                    System.out.println();
                    break;
                
                case 4:
                    System.exit(1);
                    break;
                
                default:
                    continue;

                
            
            }      
        }

        
    }   
}
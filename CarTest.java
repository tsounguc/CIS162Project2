import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Description: This code is a game created to test 
 * the code for the simpleCar class.
 *
 * @author Christian Tsoungui Nkoulou
 * @version 2/12/2018
 */
public class CarTest
{
    public static void main(String args[]){
        int errors = 0;
        int myNumMiles;
        int yourNumMiles;
        int choice;
        int a, b;
        boolean False;
        double yourMPG;
        double gas;
        String yourCarModel;
        Scanner scnr = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("#.00");
        System.out.println("");
        System.out.println("");
        System.out.println("Hello and Welcome to The Car Game!");
        System.out.println("");
        System.out.println("Would you like to play?");
        System.out.print("Type Y for yes and N for No: ");
        String play = scnr.next();// initialize play variable
        while( !play.equalsIgnoreCase("N") && !play.equalsIgnoreCase("Y"))
        {
            System.out.println("Enter Y or N");
            play = scnr.next();
        }

        if( play.equalsIgnoreCase("N"))
        {
            System.out.println(" GoodBye!");
        }

        while(play.equalsIgnoreCase("Y"))
        {            

            System.out.println("Which type of car do you want?");
            System.out.println("1) Default car");
            System.out.println("2) Custom\n");

            choice = scnr.nextInt();
            while (choice != 1 && choice != 2)
            {
                System.out.println("Enter 1 or 2");
                choice = scnr.nextInt();
            }
            scnr.nextLine();
            if(choice == 1)
            {
                SimpleCar defaultCar = new SimpleCar();// Create object for default car

                b = 1;
                while(b == 1)
                {
                    System.out.println("What do you want to do? ");
                    System.out.println("Options:");
                    System.out.print("1 Drive \n2 Add gas \n3 Change Oil");
                    System.out.print("\n4 Honk horn \n5 Check Status \n6 Change Car \n0 Exit \n");
                    int d = scnr.nextInt();

                    if(d == 1)
                    {
                        System.out.print("How many miles do you want to drive?: ");
                        yourNumMiles = scnr.nextInt();
                        System.out.println("");
                        defaultCar.drive(yourNumMiles);
                        System.out.println("");
                    }else if(d == 2)
                    {
                        System.out.print("How much gas do you want add in the tank?: ");
                        double gAmount = scnr.nextDouble();
                        System.out.println("");
                        defaultCar.addGas(gAmount);
                        System.out.println("");
                    }else if(d == 3)
                    {
                        System.out.println("");
                        defaultCar.changeOil();
                        System.out.println("");
                    }else if(d == 4)
                    {
                        System.out.println("");
                        System.out.println("Generic Car goes beep beep!");
                        System.out.println("");
                    }else if(d == 5)
                    {
                        System.out.println("");
                        System.out.println("Generic Car:");
                        System.out.println("Odometer: " + defaultCar.checkOdometer() + " miles");
                        System.out.println("Tank: " + fmt.format(defaultCar.checkGasGauge()) + " Gallons");
                        System.out.print("Oil: ");
                        defaultCar.checkOil();
                        System.out.println("Next Oil Change in " + defaultCar.checkNextOilChange() + " miles");
                        System.out.println("");
                    }else if(d == 6)
                    {
                        b = 0;
                    }
                    else if (d == 0)
                    {
                        b = 0;
                        play = "N";
                        System.out.println(" GoodBye!");
                        System.out.println("Testing complete with " + errors + " errors.");
                    }
                }
            }

            if (choice == 2)
            {
                System.out.println("");
                System.out.print("Enter Car Model: ");
                yourCarModel = scnr.nextLine();

                System.out.print("Enter MPG: ");
                yourMPG = scnr.nextDouble();

                System.out.println("");

                SimpleCar yourCar = new SimpleCar(yourCarModel, yourMPG);

                a = 1;
                while(a == 1)
                {
                    System.out.println("What do you want to do? ");
                    System.out.println("Options:");
                    System.out.print("1 Drive \n2 Add gas \n3 Change Oil");
                    System.out.print("\n4 Honk horn \n5 Check Status \n6 Change Car \n0 Exit \n \n");
                    int c = scnr.nextInt();
                    if(c == 1)
                    {
                        System.out.print("How many miles do you want to drive?: ");
                        yourNumMiles = scnr.nextInt();
                        System.out.println("");
                        yourCar.drive(yourNumMiles);
                        System.out.println("");
                    }else if(c == 2)
                    {
                        System.out.print("How much gas do you want add in the tank?: ");
                        double gAmount = scnr.nextDouble();
                        System.out.println("");
                        yourCar.addGas(gAmount);
                        System.out.println("");
                    }else if(c == 3)
                    {
                        System.out.println("");
                        yourCar.changeOil();
                        System.out.println("");
                    }
                    else if(c == 4)
                    {
                        System.out.println("");
                        yourCar.honkHorn();
                        System.out.println("");
                    }else if(c == 5)
                    {
                        System.out.println("");
                        System.out.println(yourCarModel + ":");
                        System.out.println("Odometer: " + yourCar.checkOdometer() + " miles");
                        System.out.println("Tank: " + fmt.format(yourCar.checkGasGauge()) + " Gallons");
                        System.out.print("Oil: ");
                        yourCar.checkOil();
                        System.out.println("Next Oil Change in " + yourCar.checkNextOilChange() + " miles");
                        System.out.println("");
                    }else if (c == 6)
                    {
                        a = 0;
                    }else if (c == 0)
                    {
                        a = 0;
                        play = "N";
                        System.out.println(" GoodBye!");
                        System.out.println("Testing complete with " + errors + " errors.");
                    }
                }
            }
        }
    }
}

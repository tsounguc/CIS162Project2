import java.text.DecimalFormat;
/****************************************************************
 * Description: simulates the functionality of a basic car.
 * You can do simple things like drive, add gas and honk the horn.
 *
 * @author Christian Tsoungui Nkoulou
 * @version 2/02/2018
 ****************************************************************/
public class SimpleCar
{
    /** model of the Car*/
    private String carModel;

    /** number of miles in the Odometer*/
    private int numberOfMiles;

    /** the mileage for the next oil change*/
    private int mileage;

    /** the amount of gas in the tank*/
    private double amountOfGas;

    /** the miles per gallon for the car*/
    private double milesPerGallon;

    /** miles between oil changes*/
    private final int MILES_BETWEEN_OIL_CHANGE = 5000;

    /** gas tank capacity*/
    private final double FULL_TANK = 12.0;

    DecimalFormat fmt = new DecimalFormat("#.00");

    /*************************************************************
     * This default constructor sets the miles per gallon to 22.7,
     * the car model to "Generic Car", fills the tank,
     * sets the odometer to zero and sets mileage for the next oil
     * change
     *************************************************************/
    public SimpleCar()
    {
        // initialise instance variables
        carModel = "Generic Car";
        numberOfMiles = 0;
        mileage = MILES_BETWEEN_OIL_CHANGE;
        amountOfGas = FULL_TANK;
        milesPerGallon = 22.7;
    }

    /************************************************************
     * This constructor does everything the default constructor
     * does but also sets the car model and miles per gallon 
     * provided by the parameters: model and mpg. 
     ***********************************************************/
    public SimpleCar (String model, double mpg)
    {
        carModel = model;
        numberOfMiles = 0;
        mileage = MILES_BETWEEN_OIL_CHANGE;
        amountOfGas = FULL_TANK;
        milesPerGallon = mpg;
    }

    /***************************************************************
     * returns the number of miles
     * @return int numberOfMiles
     ****************************************************************/
    public int checkOdometer()
    {
        return numberOfMiles; //returns numberOfMiles
    }

    /***************************************************************
     * returns the amount of gas
     * @return double amountOfGas
     ****************************************************************/
    public double checkGasGauge()
    {
        return amountOfGas; //returns amountOfGas
    }

    /***************************************************************
     * returns the mileage
     * @return int mileage
     ****************************************************************/
    public double checkNextOilChange()
    {
        return mileage;// returns mileage
    }

    /***************************************************************
     * simulates honkHorn
     ****************************************************************/
    public void honkHorn()
    {
        System.out.println(carModel + " goes quack quack!");
    }

    /***************************************************************
     * adds oil to amount of gas and prints new amount in the tank
     * @param double - added gas g
     ****************************************************************/
    public void addGas (double g)
    {
        if(g < 0)
        {
            System.out.println("Error: gas must be a positive number");
            System.out.println(carModel + " now has " + fmt.format(amountOfGas) + " gallons of gas");
        }else{
            amountOfGas += g;
            if(amountOfGas > FULL_TANK)
            {
                System.out.println("Warning: gas tank overflowed!");
                amountOfGas = FULL_TANK;
                System.out.println(carModel + " now has " + fmt.format(amountOfGas) + " gallons of gas");
            }else{
                System.out.println(carModel + " now has " + fmt.format(amountOfGas) + " gallons of gas");
            }
        }
    }

    /***************************************************************
     * simulates car driving and adds miles driven to odometer
     * @param int - miles driven
     ****************************************************************/

    public void drive (int miles)
    {
        if(miles < 0)
        {
            System.out.println("Error: miles must be a positive number");

        }else{
            numberOfMiles +=miles; // add miles to the number of miles
            amountOfGas -= miles/milesPerGallon; // subtract the number of gallons used when driving from the amount of gas in the tank

            if (amountOfGas <= 0) // if there's no moure gas in the tank
            {
                numberOfMiles -=miles; // numberOfmiles before miles added
                amountOfGas += miles/milesPerGallon;// amount of gas before car stopped
                miles = (int)(amountOfGas * milesPerGallon); // miles driven before running out of gas
                amountOfGas = 0; // car runs out of gas
                numberOfMiles +=miles;
                System.out.println(carModel + " drove " + miles + " miles before running out of gas");
                System.out.println(carModel + " drove " + numberOfMiles + " miles");
            }
            else{
                System.out.println(carModel + " drove " + numberOfMiles + " miles");                
            }
        }
    }

    /***************************************************************
     * changes oil and tell user when to change oil next
     ****************************************************************/

    public void changeOil () 
    {
        mileage = numberOfMiles + MILES_BETWEEN_OIL_CHANGE;
        System.out.println(carModel + " oil changed. Next change at " +  mileage + " miles");
    }

    /***************************************************************
     * Tells user whether to change oil or not
     ****************************************************************/
    public void checkOil ()
    {
        if (numberOfMiles >= mileage)
        {
            System.out.println("You should change the Oil");
        }
        else
        {
            System.out.println("Oil looks good");
        }
    }
}
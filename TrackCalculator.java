/* This program is designed to help 
** Runners calculate how to pace various
** races in track or cross country
*/

/*
** Time conversions for reference
**  200 = 400/2 - 2
**  800 = 400 * 2 + 2
**  1500 = (400 * 4) - (400/4) + 6
**  1600 = 400*4 + 8
**  1 mile = 400*4 + 11
**  3000 = 
**  5k = 
*/

import java.util.Scanner; //Utility that can read user input

import javax.naming.TimeLimitExceededException;

class TrackCalculator {
    
    //Scanner that will read user input, used in nextLine
    public static Scanner scan = new Scanner(System.in);
    //lists that stores times:
    public static double[] calculatedTimes = {-1, -1, -1, -1, -1, -1, -1};
    public static String[] outPutTimes = {"", "", "", "", "", "",""};   
    //list that stores output texts:
    public static final String[] kLables = 
    {
        "Your 400m Time: ", "800m Approx: ", "800m Approx: ", "1500m Approx: ",  
        "1600m Approx: ", "1 Mile Approx: ", "3k Approx: ", "5k Approx: "
    }; //this list was made on multiple lines for readability

    //TODO: revise addon constant to be more realistic

    //Stores what the user time gets multiplied by
    public static final double[] kFactors = {0.5, 2, 3.75, 4, 4, 7.5, 12.5};

    //Stores extra secconds added after multiplying
    public static final double[] kAddon = {-2, 2, 6, 8, 11, 40, 60};

    public static void main(String[] args){ //Main method, code is run in here
    
        //TODO: add print stuff
        //hello, etc
        //enter thing
        System.out.println("Please enter your 400m time: ");
        
        /**input is the user-submitted value, it gets converted to a double and assigned to time */
        String userInput = getNext();
        Double userTime = -1.0;

        //Checks if input is valid - matches returns true if input is only ints, otherise returns false
        if (userInput.matches("[0-9]+")){
            //Converts input from string to double so it can be passed to doMath()
            userTime = Double.parseDouble(userInput);
            //manipulates a list of times to match the user inputed pace
            doMath(userTime);
            outputData();
        } else {
            System.out.println("Please just enter your time in secconds, with no punctuation");
        }

    }

    /** Function to return the user input, using scanner */
    public static String getNext(){
        return scan.nextLine(); 
    }

    /** Function to output final times */
    public static void outputData(){
        System.out.println("Reccomended paces for each race, based on your 400m time: ");
        for (int i = 0; i < 7; i++){ //iterates through lists of data
            outPutTimes[i] = modulusTimes(calculatedTimes[i]);
            //concatenates times with lables, prints to console
            System.out.println(kLables[i] + outPutTimes[i]); 
        }
    }

    /** Function to calculate final times */
    public static void doMath(double time){
        for (int i = 0; i < 7; i++) { //iterates through lists of data
        
            //TODO: replace this with modulus to seperate minutes and secconds
            calculatedTimes[i] = ((time * kFactors[i]) + kAddon[i]);
        }
    }

    /**converts the time in secconds returned by doMath() to minutes:secconds format */
    public static String modulusTimes(double time){
        double decimal = time % 60;
        int wholeNum = (int) (time / 60);
        String output = (Integer.toString(wholeNum) + ":" + Double.toString(decimal));
        return output;
    }

}
/* This program is designed to help 
** Runners calculate how to pace various
** races in track or cross country
**
**  NOTE: the outputed tiimes aren't perfect, they are a bit fast, but the logic used to calculate them is accurate
**
*/

import java.util.Scanner; //Utility that can read user input

class TrackCalculator {
    
    //Scanner that will read user input, used in nextLine
    public static Scanner scan = new Scanner(System.in);
    //lists that stores manipulated times:
    public static double[] calculatedTimes = {-1, -1, -1, -1, -1, -1, -1};
    //list that will be called when outputting the final message
    public static String[] outPutTimes = {"", "", "", "", "", "",""};   
    //list that stores output texts:
    public static final String[] kLables = 
    {
        "200m Approx: ", "800m Approx: ", "1500m Approx: ", "1600m Approx: ",  
        "1 Mile Approx: ", "3k Approx: ", "5k Approx: "
    }; //this list was made on multiple lines for readability

    //Stores what the user time gets multiplied by
    public static final double[] kFactors = {0.5, 2, 3.75, 4, 4, 7.5, 12.5};
    
    //TODO: revise addon constant to be more realistic
    //Stores extra secconds added after multiplying
    public static final double[] kAddon = {-2, 2, 6, 8, 11, 100, 200};

    //sentry that is changed to true if doMAth() works
    public static boolean timeSentry = false;

    public static void main(String[] args){ //Main method, code is run in here
    
        //really long string uses \n to signal when to move to next line
        System.out.println("+------------------------------------+ \n|     Welcome to the Track Split     | \n|           Calculator!              | \n+------------------------------------| \n|       This Calculator will         | \n|      help you set goals and        | \n|       estimate your paces for      | \n|           various races            | \n+------------------------------------+ \n\nPlease Enter your 400m time, in secconds:");
        
        /**userInput is the user-submitted value, it gets converted to a double and assigned to userTime */
        String userInput = getNext();
        Double userTime = -1.0;

        //Checks if input is valid - matches returns true if input is only ints, otherise returns false
        //if matches returns true, then the program will continue. otherwise it will print a message and end.
        if (userInput.matches("[0-9]+")){
            //Converts input from string to double so it can be passed to doMath()
            userTime = Double.parseDouble(userInput);
            //manipulates a list of times to match the user inputed pace
            doMath(userTime);
            //if doMath was successful the program prints the data
            if (timeSentry) {outputData();}
            
        } else {
            System.out.println("Please just enter your time in secconds, with no punctuation");
            System.out.println("For example: '62' not 'sixty-two' or '62.3'");
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
        if (time > 40) {    //if the inputed time is valid the program continues, otherwise it ends
            for (int i = 0; i < 7; i++) { //iterates through lists of data
                //times are calculated by multiplying them by a constant 
                //and then adding a few secconds to account for slower speeds
                calculatedTimes[i] = ((time * kFactors[i]) + kAddon[i]);
            }
            //After the code is done manipulating the times, it prints a message saying everything worked
            System.out.println("--Calculating times...");
            
            try { //attempts to pause the code for 3 seconds for ux appeal
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("--Success!");
            timeSentry = true;

        } else {
            System.out.println("--Calculating times...");
            
            try { //attempts to pause the code for 3 seconds for ux appeal
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("--ERROR");
            System.out.println("--Please enter a realistic time");

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
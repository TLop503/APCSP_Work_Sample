/* This program is designed to help 
** Runners calculate how to pace various
** races in track or cross country
*/

/*
** Time conversions for reference
**  200 = 400/2 - 2
**  800 = 400 + 2
**  1500 = (400 * 4) - (400/4)
**  1600 = 400*4 + 8
**  1 mile = 400*4 + 10
**  3000 = 
*/

import java.util.Scanner; //Utility that can read user input

class TrackCalculator 
{
    
    //Scanner that will read user input, used in nextLine
    public Scanner scan = new Scanner(System.in);
    //lists that stores times:
    public static int[] lTimes = {-1, -1, -1, -1, -1, -1, -1};
    //list that stores output texts:
    public static final String[] lLables = 
    {
        "Your 400m Time: ", "800m Approx: ", "800m Approx: ", "1500m Approx: ",  
        "1600m Approx: ", "1 Mile Approx: ", "3k Approx: ", "5k Approx: "
    }; //this list was made on multiple lines for readability

    public static void main(String[] args) //Main method, code is run in here
    {
        outputData();
    }

    /** Function to return the user input, using scanner */
    public String getNext()
    {
        return scan.nextLine(); 
    }

    /** Function to output final times */
    public static void outputData()
    {
        System.out.println("Reccomended paces for each race, based on your 400m time: ");
        for (int i = 0; i < 7; i++) //iterates through lists of data
        {
            //concatenates times with lables, prints to console
            System.out.println(lLables[i] + lTimes[i]); 
        }
    }
}
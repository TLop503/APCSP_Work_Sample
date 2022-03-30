/* This program is designed to help 
** Runners calculate how to pace various
** races in track or cross country
*/

import java.util.Scanner; //Utility that can read user input

class TrackCalculator {
    
    //Scanner that will read user input, used in nextLine
    Scanner scan = new Scanner(System.in);
    
    /** Function to return the user input, using scanner */
    public String getNext(){
        return scan.nextLine(); 
    }
}
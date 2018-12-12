import java.util.Scanner;

class Guess{

    public static Scanner reader = new Scanner(System.in);
    /** 
     * This class implements a guessing game. The user is told to pick 
     * a number between 0 - 10000. A binary search algorithm is then 
     * used to identify the number that the user has picked.
     */
    public static void main(String[] args){
        System.out.println("Think of a number between 0 10000...");
        System.out.println("Press y when ready (y/n)");
        String answer = reader.nextLine();
        if(answer.equals("y")){
            initGame(0, 10000);
        }
        reader.close();
        System.out.println("Congratulations you passed the test");
    }
    /**
     * The algorithms next guess is found by taking the mean of the lower and
     * upper bounds. This ensures that the game will not run more than log(10000) 
     * turns.
     * @param low the lower bound of the search
     * @param high the upper bound of the search.
     */ 
    public static void initGame(int low, int high){
        String guess = Integer.toString(guess(high, low));
        System.out.printf("Is your number lower than greater than or equal to %s l/h/e\n", guess);
        if(reader.hasNextLine()){
            String s = reader.nextLine();
            if(s.equals("l")){
                initGame(low, (low+high)/2-1);
            }
            if(s.equals("h")){
                initGame((low+high)/2+1, high);
            }
            if(s.equals("e")){
                System.out.println("Game over");
            }
            else{
                System.out.println("Try again.");
                initGame(low, high);
            }
        }
        else{
            initGame(low, high);
        }
    }

    public static int guess(int high, int low){
        return ((high + low)/2);
    }
}
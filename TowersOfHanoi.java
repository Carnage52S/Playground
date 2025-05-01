public class TowersOfHanoi 
{                                                   // This method solves the Towers of Hanoi problem by moving n disks from one peg to another.
    public static void moves(int n, boolean left)   // n = number of discs to move | left = true if moving discs towards the left peg, false if moving towards the right peg
    {                                               // Base case: if there are no disks to move, return.
        if (n == 0) {                               // Base case: if there are no disks to move, return.
            return;                                 // Recursive case: move n-1 disks to the auxiliary peg.
        }
        moves(n-1,!left);                           // Move the nth disk to the target peg.
        if(left) System.out.println(n + " left");   // Print the move to the console.
        else System.out.println(n + " right");      // Move the n-1 disks from the auxiliary peg to the target peg.
        moves(n-1, !left);                          // Move the nth disk to the target peg.
    }
    public static void main(String[] args)          // Main method to initialize and solve the Towers of Hanoi problem.
    {                                               // Reads the number of disks from the command-line arguments.
        int n = Integer.parseInt(args[0]);          // Parse the number of disks from the first argument.
        moves(n, true);                        // Solve the problem by moving n disks from the left peg to the right peg.
    }
}
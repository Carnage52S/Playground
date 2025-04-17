public class Euclid
{
    public static int gcd(int p, int q)
    {
        if (q == 0) return p; // Base case: if q is 0, return p
        return gcd(q, p % q); // Recursive case: call gcd with q and the remainder of p divided by q
    }
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]); // Read the first command-line argument as an integer
        int q = Integer.parseInt(args[1]); // Read the second command-line argument as an integer
        int devisor = gcd(p, q);  // Call the gcd method with p and q
        System.out.println("The GCD of " + p + " and " + q + " is: " + devisor); // Print the result
    }
}
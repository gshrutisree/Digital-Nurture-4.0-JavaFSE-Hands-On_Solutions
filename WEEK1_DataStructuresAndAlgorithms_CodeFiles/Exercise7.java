import java.util.Scanner;

public class Exercise7 
{
    public static double forecastValue(double pv, double r, int y) {
        if (y == 0) return pv; 
        return forecastValue(pv * (1 + r), r, y - 1); 
    }
    public static double forecastIterative(double pv, double r, int y) {
        for (int i = 0; i < y; i++) 
        {

            pv *= (1 + r);
        }
        return pv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double pv = sc.nextDouble();
        System.out.print("Enter annual growth rate (in %): ");
        double r = sc.nextDouble() / 100;
        System.out.print("Enter number of years: ");
        int y = sc.nextInt();
        double futureValueRecursive = forecastValue(pv, r, y);
        System.out.println("Future value (recursive): " + futureValueRecursive);
        double futureValueIterative = forecastIterative(pv, r, y);
        System.out.println("Future value (iterative): " + futureValueIterative);
    }
}

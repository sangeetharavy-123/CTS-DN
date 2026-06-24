import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue,
                                              double growthRate,
                                              int years) 
	{

        // Base condition
        if (years == 0) {
            return presentValue;
        }

        // Recursive call
        return calculateFutureValue(
                presentValue,
                growthRate,
                years - 1)
                * (1 + growthRate);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get present value from user
        System.out.print("Enter Present Value: ");
        double presentValue = sc.nextDouble();

        // Get growth rate from user
        System.out.print("Enter Growth Rate (%): ");
        double growthRate = sc.nextDouble() / 100;

        // Get number of years
        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        // Call recursive method
        double futureValue =
                calculateFutureValue(
                        presentValue,
                        growthRate,
                        years);

        // Display result
        System.out.printf("\nFuture Value after %d years = Rs%.2f" ,years,futureValue);

        sc.close();
    }
}
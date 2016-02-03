import java.text.DecimalFormat;

/*
Solution suggested by the book is too tidious and requires lots of variables to be initialized to solve the problem.
Instead we can use array to hold the values of base tax and percent of tax.

Solution to this problem is straigt forward. We will scan thorough the incomeRanges array when if the income is less than
or equal to the corresponding income thne we will read the base tax and percentage for that corresponding index.

If income is more than all the income values then we will use another formula to calculate the income.
*/
public class problem1 {
    private static int incomeRanges[] = {2200, 2700, 3200, 3700, 4200};
    private static int deductions[] = {0, 2200, 2700, 3200, 3700};
    private static int minimumTaxes[] = {0, 0, 70, 145, 225};
    private static float taxPercentage[] = {0.0f, 0.14f, 0.15f, 0.16f, 0.17f};

    private static float calculateTax(int income) {
        for(int i=0; i< incomeRanges.length; i++) {
            if(income <= incomeRanges[i]) {
                return minimumTaxes[i] + taxPercentage[i] * (income - deductions[i]);
            }
        }

        // We will reach this condition when income is not listed in the incomeRanges
        return 53090 + 0.70f * (income - 102200);
    }


    public static void main(String[] args) {
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(2100));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(2200));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(2500));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(2700));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(3200));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(3700));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(4200));
        System.out.println("Tax for income  " + 2200 + " : " + calculateTax(100000));
    }
}
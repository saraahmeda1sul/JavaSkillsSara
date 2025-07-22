public class payrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hourWorked, double hourlyRate){
        if( hourWorked < 0 || hourlyRate < 0){
            System.out.println(" error:Negative hours or rate");
            return 0;
        }

        switch (employeeType) {
            case "FULL_TIME":
                if (hourWorked <= 40) {
                    return hourWorked * hourlyRate;
                } else {
                    double overtime = hourWorked - 40;
                    return (40 * hourlyRate) + (overtime * hourlyRate * 1.5);}
                case "PART_TIME":
                if (hourWorked > 25) {
                    hourWorked = 25;}
                return hourWorked * hourlyRate;
                case "CONTRACTOR":
                return hourWorked * hourlyRate;
                case "INTERN":
                if (hourWorked > 20) {
                    hourWorked = 20; }
                return hourWorked * (hourlyRate * 0.8);
            default:
                System.out.println("Invalid employee type: " + employeeType);
                return 0;
        }
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax = 0;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }
        if (hasHealthInsurance) {
            tax -= 50;
        }
        return Math.max(0, tax); // Don't return negative tax that happen becase discounts
    }
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int len = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));
        double totalPay = 0;
        int overtimeCount = 0;
        double maxPay = Double.MIN_VALUE;
        double minPay = Double.MAX_VALUE;
        String maxName = "";
        String minName = "";

        System.out.printf("%-10s %-12s %-6s %-6s %-10s %-8s\n", "Name", "Type", "Hours", "Rate", "GrossPay", "Tax");

        for (int i = 0; i < len; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true); // Assume everyone has insurance
            totalPay += gross;
            if (hours[i] > 40) overtimeCount++;
            if (gross > maxPay) {
                maxPay = gross;
                maxName = names[i];
            }
            if (gross < minPay) {
                minPay = gross;
                minName = names[i];
            }

            System.out.printf("%-10s %-12s %-6.1f %-6.1f %-10.2f %-8.2f\n",
                    names[i], employeeTypes[i], hours[i], rates[i], gross, tax);
        }

        double avgPay = totalPay / len;

        System.out.println(" Payroll Summary :");
        System.out.println("Highest Paid: " + maxName + " (OMR" + maxPay + ")");
        System.out.println("Lowest Paid : " + minName + " (OMR" + minPay + ")");
        System.out.println("Average Pay : OMR" + String.format("%.2f", avgPay));
        System.out.println("Overtime Workers: " + overtimeCount);
    }
    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"ahmed", "maryam", "layan", "alaa", "sara"};

        System.out.println("Test Single Pay Calculation:");
        double examplePay = calculateWeeklyPay("FULL_TIME", 45, 25);
        double tax = calculateTaxDeduction(examplePay, true);
        System.out.println("Gross: $" + examplePay + ", Tax: $" + tax);

        System.out.println(" Full Payroll:");
        processPayroll(types, hours, rates, names);
    }
}

    }
}

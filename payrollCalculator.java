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
    }
}

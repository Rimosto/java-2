import java.util.Scanner;

    class Data
    {
        public static void main(String[] args) 
        {
            Scanner scanner = new Scanner(System.in);
        
        {
            System.out.print("EMPLOYEE NAME:");           
            System.out.println("Enter the number of days worked: ");
            long daysWorked = Long.parseLong(scanner.nextLine());
           
            final double rate = 1000;

            double basicPay = daysWorked * rate;

            double houseAllowance = 0.03 * basicPay;
            double transportAllowance = 0.02 * basicPay;
            double medicalAllowance = 0.015 * basicPay;

            double grossPay = basicPay + houseAllowance + transportAllowance + medicalAllowance;

            double paye = 0.05 * grossPay;
            double shift = 0.06 * grossPay;
            double nhif = 0.02 * grossPay;

            double netPay = grossPay - paye - shift - nhif;
            
          
            System.out.println("BASIC PAY:" + basicPay);
            System.out.println("TRANSPORT ALLOWANCE:" + transportAllowance);
            System.out.println("HOUSE ALLOWANCE:" + houseAllowance);
            System.out.println("MEDICAL ALLOWANCE:" + medicalAllowance);
            System.out.println("PAYE DEDUCTIONS:" + paye);
            System.out.println("SHIF DEDUCTION:" + shift);
            System.out.println("NSSF:" + nhif);
           System.out.println("NET PAY:" + netPay);

          scanner.close();
        }
    }
}
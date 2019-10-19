public class Morgan_p02 {

    static class SavingsAccount{
        public static double annualInterestRate = 0.0;

        private double savingsBalance;

        public SavingsAccount(double val){
            this.savingsBalance = val;
        }


        public void calculateMonthlyInterest(){
            double interest;
            interest = (this.savingsBalance * (annualInterestRate/100))/12;
            this.savingsBalance += interest;
        }


        public void showBalance(){
            System.out.printf("$%.2f", this.savingsBalance);
        }

        public static void modifyInterestRate(double newRate){
            annualInterestRate = newRate;
        }
    }

    public static void main (String[]args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(4.0);
        System.out.println("The balance for saver1 is:");
       // System.out.println("Month \t\t Saver1 \t Saver2");

        for(int i = 1; i <= 12; ++i){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + i + ":\t");
            saver1.showBalance();
            System.out.println();
        }
        System.out.println("");
        System.out.println("The balance for saver2 is:");
        for(int i = 1; i <= 12; ++i) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + i + ":\t");
            saver2.showBalance();
            System.out.println();
        }
        System.out.println();

        System.out.println("Calculating the Interest Rate at 5.0%");
        System.out.println();
        SavingsAccount.modifyInterestRate(5.0);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.print("Month 13 for saver1: \t");
        saver1.showBalance();
        System.out.println("");
        System.out.print("Month 13 for saver2: \t");
        saver2.showBalance();
        System.out.println();
    }
}

import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;
import java.lang.Math;

public class Morgan_p01 {


    public static double NewQuestion(int level, int arithmetic) {

        int num1;
        int num2;
        int num3;
        double ans  = 1;
        int digit = 1;
        SecureRandom num = new SecureRandom();
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);

        for(int i = 0; i < level; ++i)
        {
            digit = 10 * digit;
        }

        num1 = num.nextInt(digit) + 1;
        num2 = num.nextInt(digit) + 1;

        if(arithmetic <= 4 && arithmetic >= 1){
        switch(arithmetic) {
            case 1:
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                ans = (num1 + num2);
                break;

            case 2:
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                ans = num1 * num2;
                break;

            case 3:
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                ans = (num1 - num2);
                break;

            case 4:
                System.out.println("How much is " + num1 + " divided by " + num2 + "?(Round to two decimal places)");
                ans = ((double) num1) / num2;

                //System.out.println(ans);
                break;
            default:
                System.out.println("Invalid");
                break;
        }
        }
        else if (arithmetic == 5){
            num3 = rand.nextInt(4) + 1;

            switch (num3) {
                case 1:
                    System.out.println("How much is " + num1 + " plus " + num2 + "?");
                    ans = (num1 + num2);
                    break;

                case 2:
                    System.out.println("How much is " + num1 + " times " + num2 + "?");
                    ans = num1 * num2;
                    break;

                case 3:
                    System.out.println("How much is " + num1 + " minus " + num2 + "?");
                    ans = (num1 - num2);
                    break;

                case 4:
                    System.out.println("How much is " + num1 + " divided by " + num2 + "?(Round to two decimal places)");
                    ans = ((double) num1) / num2;
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }
        }
        else {
            System.out.println("Invalid entry");
            return 0;
        }

        return ans;
    }

    public static double Response(double val) {
        int count = 0, Rnum2, Rnum;
        double ans, subt, finAnswer;
        Scanner scnr = new Scanner(System.in);
        ans = scnr.nextDouble();
        subt = val - ans;
        finAnswer = Math.abs(subt);


        if (/*val == ans*/ finAnswer <= .01 && finAnswer >= 0) {

            Random RandomNum = new Random();
            Rnum = RandomNum.nextInt(4) + 1;
            //System.out.println(Rnum);

            switch (Rnum) {
                case 1:
                    System.out.println("Very Good!");
                    break;

                case 2:
                    System.out.println("Excellent!");
                    break;

                case 3:
                    System.out.println("Nice work!");
                    break;

                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }

            ++count;

        } else {

            Random RandomNum = new Random();
            Rnum2 = RandomNum.nextInt(4) + 1;
            switch (Rnum2) {
                case 1:
                    System.out.println("No. please try again.");
                    break;

                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;

                case 3:
                    System.out.println("Dont give up!");
                    break;

                case 4:
                    System.out.println("No. Keep trying.");
                    break;

            }
        }
        return count;
    }

        public static int difficulty()
        {
            Scanner scnr = new Scanner(System.in);
            System.out.println("What difficulty level do you want to start at? ( PICK NUMBERS 1 - 4)");
            int diffLevel;
            diffLevel = scnr.nextInt();
            return diffLevel;
        }

        public static int problemType()
        {
            Scanner scnr = new Scanner(System.in);
            int arith;
            System.out.println("What arithmetic operation do you want to have?");
            System.out.println("Type 1 for addition");
            System.out.println("Type 2 for multiplication");
            System.out.println("Type 3 for subtraction");
            System.out.println("Type 4 for division");
            System.out.println("Type 5 for all arithmetic operations");

            arith = scnr.nextInt();
            return arith;
        }

        public static void main (String[]args){
            while (true) {
                System.out.println("To continue press Y, to quit press N");
                Scanner scnr = new Scanner(System.in);
                char let;
                int prollem, hard;
                let = scnr.next().charAt(0);
                if (let == 'N' || let == 'n')
                    return;
                else if (let == 'Y' || let == 'y')
                {

                    hard = difficulty();
                    prollem = problemType();

                    double val;
                    double res, sum = 0;
                    double percent;

                    for (int i = 0; i < 10; ++i) {

                        val = NewQuestion(hard, prollem);
                        res = Response(val);
                        sum += res;

                    }

                    percent = (sum / 10) * 100;
                    System.out.println("You got " + sum + " question(s) right and " + (10 - sum) + " question(s) wrong");
                    System.out.printf("Your percentage was %.2f%%\n", percent);

                    if (percent <= 75.00) {
                        System.out.println("");
                        System.out.println("Please ask your teacher for help");
                    } else
                        System.out.println("Congratulations, you are ready to go to the next level!");
                }
                else {
                    System.out.println("Invalid entry");
                    return;
                }
            }
        }
    }

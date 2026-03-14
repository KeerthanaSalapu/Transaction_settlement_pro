// import java.math.BigDecimal;
// import java.math.RoundingMode;
// import java.util.*;

// public class TripSettlement {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of people: ");
//         int n = sc.nextInt();
//         sc.nextLine();

//         String[] names = new String[n];
//         HashMap<String, Double> paid = new HashMap<>();

//         for (int i = 0; i < n; i++) {
//             System.out.print("\nEnter name: ");
//             names[i] = sc.nextLine().trim();
//             paid.put(names[i], 0.0);
//         }

//         System.out.print("\nEnter number of expenses: ");
//         int e = sc.nextInt();
//         sc.nextLine();

//         double total = 0;

//         for (int i = 0; i < e; i++) {

//             System.out.println("\nExpense " + (i + 1));

//             System.out.print("Who paid: ");
//             String payer = sc.nextLine().trim();

//             if (!paid.containsKey(payer)) {
//                 System.out.println("Invalid name. Try again.");
//                 i--;
//                 continue;
//             }

//             System.out.print("Amount: ");
//             double amount = sc.nextDouble();
//             sc.nextLine();

//             paid.put(payer, paid.get(payer) + amount);
//             total += amount;
//         }

//         double share = round(total / n, 2);

//         System.out.println("\nEach person should pay: " + share);
//         System.out.println("\nSettlement:\n");

//         HashMap<String, Double> balance = new HashMap<>();

//         for (String name : names) {
//             balance.put(name, round(paid.get(name) - share, 2));
//         }

//         settle(balance);

//         sc.close();
//     }

//     public static void settle(HashMap<String, Double> balance) {

//         while (true) {

//             String creditor = null;
//             String debtor = null;

//             double max = 0;
//             double min = 0;

//             for (String person : balance.keySet()) {

//                 double val = balance.get(person);

//                 if (val > max) {
//                     max = val;
//                     creditor = person;
//                 }

//                 if (val < min) {
//                     min = val;
//                     debtor = person;
//                 }
//             }

//             if (Math.abs(max) < 0.01 && Math.abs(min) < 0.01)
//                 break;

//             double amount = round(Math.min(max, -min), 2);

//             System.out.println(debtor + " needs to pay " + creditor + " : " + amount);

//             balance.put(creditor, round(max - amount, 2));
//             balance.put(debtor, round(min + amount, 2));
//         }
//     }

//     public static double round(double value, int places) {

//         BigDecimal bd = BigDecimal.valueOf(value);
//         bd = bd.setScale(places, RoundingMode.HALF_UP);

//         return bd.doubleValue();
//     }
// }



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TripSettlement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        HashMap<String, Double> paid = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            names[i] = sc.nextLine();
            paid.put(names[i], 0.0);
        }

        System.out.print("\nEnter number of expenses: ");
        int e = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < e; i++) {

            System.out.println("\nExpense " + (i + 1));

            System.out.print("Who paid: ");
            String payer = sc.nextLine();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            paid.put(payer, paid.get(payer) + amount);
            total += amount;
        }

        double share = round(total / n, 2);

        System.out.println("\nEach person should pay: " + share);
        System.out.println("\nSettlement:\n");

        HashMap<String, Double> balance = new HashMap<>();

        for (String name : names) {
            balance.put(name, round(paid.get(name) - share, 2));
        }

        settle(balance);

        sc.close();
    }

    public static void settle(HashMap<String, Double> balance) {

        while (true) {

            String creditor = null;
            String debtor = null;

            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;

            for (String person : balance.keySet()) {

                double val = balance.get(person);

                if (val > max) {
                    max = val;
                    creditor = person;
                }

                if (val < min) {
                    min = val;
                    debtor = person;
                }
            }

            if (creditor == null || debtor == null) {
                break;
            }

            if (max <= 0 || min >= 0) {
                break;
            }

            double amount = round(Math.min(max, -min), 2);

            System.out.println(debtor + " needs to pay " + creditor + " : " + amount);

            balance.put(creditor, round(max - amount, 2));
            balance.put(debtor, round(min + amount, 2));
        }
    }

    public static double round(double value, int places) {

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}
import java.util.Scanner;

public class Expenses_Calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        double be = sc.nextDouble();
        double te = sc.nextDouble();
        double fe = sc.nextDouble();
        double le = sc.nextDouble();

        double total = be + te + fe + le;
        System.out.println("Total expenses : Rs." + String.format("%.2f",total));
        System.out.println("Branding expenses percentage : Rs." + String.format("%.2f",100 * be / total) + "%");
        System.out.println("Travel expenses percentage : Rs." + String.format("%.2f",100 * te / total) + "%");
        System.out.println("Food expenses percentage : Rs." + String.format("%.2f",100 * fe / total) + "%");
        System.out.println("Logistics expenses percentage : Rs." + String.format("%.2f",100 * le / total) + "%");
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyService service = new CurrencyService();

        while (true) {
            System.out.println("\n--- Currency Exchange to BDT ---");
            System.out.println("1. View All Exchange Rates");
            System.out.println("2. Add New Currency");
            System.out.println("3. Update Currency Rate");
            System.out.println("4. Delete Currency");
            System.out.println("5. Exit");
            System.out.println("6. Convert Currency to BDT");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> service.viewAll();
                case 2 -> {
                    System.out.print("Currency Code: ");
                    String code = scanner.nextLine();
                    System.out.print("Rate to BDT: ");
                    double rate = scanner.nextDouble();
                    service.addCurrency(code, rate);
                }
                case 3 -> {
                    System.out.print("Currency Code to Update: ");
                    String code = scanner.nextLine();
                    System.out.print("New Rate to BDT: ");
                    double rate = scanner.nextDouble();
                    service.updateCurrency(code, rate);
                }
                case 4 -> {
                    System.out.print("Currency Code to Delete: ");
                    String code = scanner.nextLine();
                    service.deleteCurrency(code);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                case 6 -> {
                    System.out.print("Currency Code to Convert: ");
                    String code = scanner.nextLine();
                    System.out.print("Amount in " + code + ": ");
                    double amount = scanner.nextDouble();
                    service.convertToBDT(code, amount);
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
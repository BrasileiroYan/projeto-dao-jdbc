package application.menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    private Scanner sc;

    public MainMenu(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void show() {
        try {
            while (true) {
                System.out.println("\n================================");
                System.out.println("Choose an option:");
                System.out.println("[1] - Work with Department");
                System.out.println("[2] - Work with Seller");
                System.out.println("[3] - Exit");
                System.out.print("Option: ");

                int option = sc.nextInt();
                sc.nextLine();

                if (option == 1) {
                    DepartmentMenu departmentMenu = new DepartmentMenu(sc);
                    departmentMenu.show();

                } else if (option == 2) {
                    SellerMenu sellerMenu = new SellerMenu(sc);
                    sellerMenu.show();

                } else if (option == 3) {
                    System.out.println("Exiting...");
                    break;

                } else {
                    System.out.println("Invalid option! Please try again!");
                }
            }
        } catch (RuntimeException e) {
            throw new MenuException(e.getMessage());
        }
    }
}

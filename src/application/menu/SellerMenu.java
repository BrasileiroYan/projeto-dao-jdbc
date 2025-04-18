package application.menu;

import database.DbException;
import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class SellerMenu implements Menu {
    private Scanner sc;

    public SellerMenu(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void show() {
        try {
            System.out.println("\n=============Seller=============");
            System.out.println("Choose an option:");
            System.out.println("[1] - Add Seller");
            System.out.println("[2] - Update Seller");
            System.out.println("[3] - Delete Seller");
            System.out.println("[4] - Find Seller");
            System.out.println("[5] - List Sellers by Department");
            System.out.println("[6] - List All Sellers");
            System.out.println("[7] - Back");
            System.out.print("Option: ");

            int option = sc.nextInt();
            sc.nextLine();

            SellerDao sellerDao = FactoryDao.createSellerDao();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (option) {
                case 1:
                    System.out.println("\t-Adding Seller:");

                    System.out.print("Name: ");
                    String name1 = sc.nextLine();

                    System.out.print("Email: ");
                    String email1 = sc.nextLine();

                    System.out.print("Birth Date (DD/MM/YYYY): ");
                    LocalDate birthDate1 = LocalDate.parse(sc.nextLine(), formatter);

                    System.out.print("Base Salary: ");
                    double baseSalary1 = sc.nextDouble();

                    System.out.print("Department Id: ");
                    int departmentId1 = sc.nextInt();
                    Department department1 = new Department(departmentId1, null);

                    sc.nextLine();

                    Seller seller1 = new Seller(null, name1, email1, birthDate1, baseSalary1, department1);

                    try {
                        sellerDao.insert(seller1);
                        System.out.printf("Seller %s added successfully!", seller1.getName());
                    } catch (RuntimeException e) {
                        throw new DbException("Error adding seller: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\t-Updating Seller:");

                    System.out.print("Seller Id: ");
                    int sellerId2 = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name: ");
                    String name2 = sc.nextLine();

                    System.out.print("Email: ");
                    String email2 = sc.nextLine();

                    System.out.print("Birth Date (DD/MM/YYYY): ");
                    LocalDate birthDate2 = LocalDate.parse(sc.nextLine(), formatter);

                    System.out.print("Base Salary: ");
                    double baseSalary2 = sc.nextDouble();

                    System.out.print("Department Id: ");
                    int departmentId2 = sc.nextInt();
                    Department department2 = new Department(departmentId2, null);

                    Seller seller2 = new Seller(sellerId2, name2, email2, birthDate2, baseSalary2, department2);

                    try {
                        sellerDao.update(seller2);
                        System.out.printf("Seller %s updated successfully!", seller2.getName());
                    } catch (RuntimeException e) {
                        throw new DbException("Error updating seller: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("========Deleting  Seller========");
                    System.out.println("Choose an option:");
                    System.out.println("[1] - Delete by Id");
                    System.out.println("[2] - Delete by Name and Email");
                    System.out.print("Option: ");

                    int deleteOption = sc.nextInt();
                    sc.nextLine();

                    if (deleteOption == 1) {
                        System.out.print("Id: ");
                        int id3 = sc.nextInt();

                        Seller seller3 = sellerDao.findById(id3);

                        try {
                            if (seller3 != null) {
                                sellerDao.deleteById(id3);
                                System.out.printf("Seller %s deleted successfully!", seller3.getName());
                            }

                        } catch (RuntimeException e) {
                            throw new DbException("Error deleting seller: " + e.getMessage());
                        }
                    } else if (deleteOption == 2) {
                        System.out.print("Name: ");
                        String name3 = sc.nextLine();

                        System.out.print("Email: ");
                        String email3 = sc.nextLine();

                        Seller seller = new Seller(null, name3, email3, null, null, null);

                        try {
                            sellerDao.delete(seller);
                            System.out.printf("Seller %s deleted successfully!", seller.getName());

                        } catch (RuntimeException e) {
                            throw new DbException("Error deleting seller: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid option! Please try again!");
                    }
                    break;
                case 4:
                    System.out.println("\t-Fiding Seller:");

                    System.out.print("Seller Id: ");
                    int sellerId4 = sc.nextInt();

                    try {
                        Seller seller = sellerDao.findById(sellerId4);
                        System.out.println(seller);
                    } catch (RuntimeException e) {
                        throw new DbException("Error finding seller: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\t-Listing Sellers by Department:");

                    System.out.print("Department Id: ");
                    int departmentId5 = sc.nextInt();

                    Department department5 = new Department(departmentId5, null);

                    try {
                        List<Seller> sellerList5 = sellerDao.findByDepartment(department5);

                        for (Seller s : sellerList5) {
                            System.out.println(s);
                        }
                    } catch (RuntimeException e) {
                        throw new DbException("Error listing sellers by department: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\t-Listing all Sellers:");

                    try {
                        List<Seller> sellerList6 = sellerDao.findAll();

                        for (Seller s : sellerList6) {
                            System.out.println(s);
                        }
                    } catch (RuntimeException e) {
                        throw new DbException("Error listing all sellers: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again!");
            }
        } catch (RuntimeException e) {
            throw new MenuException(e.getMessage());
        }
    }
}

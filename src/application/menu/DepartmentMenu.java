package application.menu;

import database.DbException;
import model.dao.DepartmentDao;
import model.dao.FactoryDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentMenu implements Menu{
    private Scanner sc;

    public DepartmentMenu(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void show() {
        try {
            System.out.println("\n============Department============");
            System.out.println("Choose an option:");
            System.out.println("[1] - Add Department");
            System.out.println("[2] - Update Department");
            System.out.println("[3] - Delete Department");
            System.out.println("[4] - Find Department");
            System.out.println("[5] - List Departments");
            System.out.println("[6] - Back");
            System.out.print("Option: ");

            int option = sc.nextInt();
            sc.nextLine();

            DepartmentDao departmentDao = FactoryDao.createDepartmentDao();
            switch (option) {
                case 1:
                    System.out.println("\t-Adding Department:");

                    System.out.print("Department Name: ");
                    String departmentName1 = sc.nextLine();

                    Department department1 = new Department(null, departmentName1);

                    try {
                        departmentDao.insert(department1);
                        System.out.println("Department: " + department1.getName() + " - ID: " + department1.getId());
                        System.out.println("Department inserted successfully!");
                    } catch (RuntimeException e) {
                        throw new DbException("Error adding department: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\t-Updating Department:");

                    System.out.print("Department Name: ");
                    String departmentName2 = sc.nextLine();

                    System.out.print("Department Id: ");
                    int departmentId2 = sc.nextInt();

                    Department department2 = new Department(departmentId2, departmentName2);

                    try {
                        departmentDao.update(department2);
                        System.out.println("Department updated successfully!");
                    } catch (RuntimeException e) {
                        throw new DbException("Error updating department: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\t-Deleting Department:");

                    System.out.print("Department Id: ");
                    int departmentId3 = sc.nextInt();

                    try {
                        Department department3 = departmentDao.findById(departmentId3);
                        departmentDao.deleteById(department3.getId());
                        System.out.printf("%s department deleted successfully!", department3.getName());

                    } catch (RuntimeException e) {
                        throw new DbException("Error deleting department: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\t-Finding Department:");

                    System.out.print("Department Id: ");
                    int departmentId4 = sc.nextInt();

                    try {
                        Department department4 = departmentDao.findById(departmentId4);
                        System.out.println(department4);
                    } catch (RuntimeException e) {
                        throw new DbException("Error fiding department: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\t-List of Departments:");

                    try {
                        List<Department> department5List = departmentDao.findAll();

                        for (Department d : department5List) {
                            System.out.println(d);
                        }
                    } catch (RuntimeException e) {
                        throw new DbException("Error listing department: " + e.getMessage());
                    }
                    break;
                case 6:
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

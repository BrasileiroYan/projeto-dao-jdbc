package application;

import model.dao.DepartmentDao;
import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentDao departmentDao = FactoryDao.createDepartmentDao();

        List<Department> departmentList = departmentDao.findAll();

        for (Department d : departmentList) {
            System.out.println(d);
        }
    }
}
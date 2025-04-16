package application;

import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = FactoryDao.createSellerDao();


    }
}
package model.dao;

import database.DbConnection;
import model.dao.impl.SellerDaoJDBC;

import java.sql.Connection;

public class FactoryDao {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DbConnection.getConnection());
    }

}

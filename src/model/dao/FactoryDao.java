package model.dao;

import database.DbConnection;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

import java.sql.Connection;

public class FactoryDao {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DbConnection.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DbConnection.getConnection());
    }

}

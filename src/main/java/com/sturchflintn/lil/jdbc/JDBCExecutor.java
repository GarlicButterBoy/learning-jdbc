package com.sturchflintn.lil.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor
{
    public static void main(String... args){
        //System.out.println("Hello World!");
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "100303769");

        try
        {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM customer");
            while(resultSet.next())
            {
                System.out.println(resultSet.getInt(1));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

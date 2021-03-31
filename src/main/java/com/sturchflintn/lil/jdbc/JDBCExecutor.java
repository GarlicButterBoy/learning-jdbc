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
            CustomerDAO customerDAO = new CustomerDAO(connection);
            //This tests that the connection is working
            /*Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM customer");
            while(resultSet.next())
            {
                System.out.println(resultSet.getInt(1));
            }*/

            //This tests that we can add data to the db

           /* Customer customer = new Customer();
            customer.setFirstName("George");
            customer.setLastName("Washington");
            customer.setEmail("george.washington@wh.gov");
            customer.setPhone("(555) 555-5555");
            customer.setAddress("1234 Main St");
            customer.setCity("Mount Vernon");
            customer.setState("VA");
            customer.setZipCode("221221");

            customerDAO.create(customer); */

            //This tests the Reading methods we set
          /*  Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName() + " " + customer.getLastName()); */

            //This tests the UPDATE method we set
            Customer customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());

            customer.setEmail("gwashington@wh.gov");
            customer = customerDAO.update(customer);

            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}

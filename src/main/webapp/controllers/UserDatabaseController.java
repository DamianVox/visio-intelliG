package controllers;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDatabaseController {
    private UserDatabaseController instance;
    private DataSource dataSource;

    public UserDatabaseController() throws Exception {
        dataSource = getDataSource();
    }

    private DataSource getDataSource() {
        Context context = null;
        String jndiName = null;
        DataSource ds = null;

        try {
            context = new InitialContext();
            jndiName = "java:/PostgresDS";
            ds = (DataSource) context.lookup(jndiName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        return ds;
    }

    private Connection getConnection() {
        Connection theConn = null;
        try {
            theConn = dataSource.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        System.out.println("Getting DB Connection...");
        return theConn;
    }

    private void close(Connection theConn, Statement theStmt) {
        close(theConn, theStmt, null);
    }

    private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

        try {
            if (theRs != null) {
                theRs.close();
            }

            if (theStmt != null) {
                theStmt.close();
            }

            if (theConn != null) {
                theConn.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    public boolean userExists(String email, String password){
        Boolean linkFound = false;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = getConnection();

            String sql = "select * from users where email=? and password=?";

            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, email);
            myStmt.setString(2, password);

            myRs = myStmt.executeQuery();
            if (myRs.next()) {
                linkFound = true;
                System.out.println("Found Link ");
            } else {
                linkFound = false;
                System.out.println("No link found");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            close(myConn, myStmt);
        }
        return linkFound;
    }
}

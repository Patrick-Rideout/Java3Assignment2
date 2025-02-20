package JDBC;

import java.io.PrintStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Stores database connection properties for the application.
 * This class contains constants for the database URL, username, and password.
 */
public class DBProperties {

    /**
     * The URL for connecting to the MariaDB database.
     */
    public static final String DATABASE_URL = "jdbc:mariadb://localhost:3305";

    /**
     * The username for the database connection.
     */
    public static final String DATABASE_USER = "root";

    /**
     * The password for the database connection.
     */
    public static final String DATABASE_PASSWORD = "123CNA123";

    public static boolean isDriverRegistered(PrintStream printStream) {
        //Option 1: Find the class
        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            System.out.println("Option 1: Find the class worked!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            return false;
        } catch (IllegalAccessException ex) {
            System.out.println("Error: access problem while loading!");
            return false;
        } catch (InstantiationException ex) {
            System.out.println("Error: unable to instantiate driver!");
            return false;
        }

        //Option 2: Register the Driver
        try {
            Driver myDriver = new org.mariadb.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            System.out.println("Option 2: Register the Driver worked!");
        } catch (SQLException ex) {
            System.out.println("Error: unable to load driver class!");
            return false;
        }

        return true;
    }
}

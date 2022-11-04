package com.kbilyk;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printError;

public class Database {
    public static java.sql.Connection connection = null; // connection to database
    private static final String url = "jdbc:sqlserver://DESKTOP-VDL5LBV\\MSSQLSERVER:1433;database=flowershopDB";
    private static final String user = "hzz";
    private static final String password = "#daeMON32";

    /**
     * a method that checks whether there is a connection to the database. I
     * f there is no connection, we establish it
     * @return The connection to database
     */
    public static java.sql.Connection getConnection() {

        if(connection == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection  = java.sql.DriverManager.getConnection(url, user, password);
            }
            catch (Exception e) {
                e.printStackTrace();
                printError("Error trace in getConnection() : " + e.getMessage());
            }
        }
        return  connection;
    }
}

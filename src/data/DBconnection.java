
package data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBconnection {
    private static final String HOST = "jdbc:mysql://localhost:3306/Library?useTimezone=true&serverTimezone=UTC";
    private static final String USER_NAME="root";
    private static final String PASSWORD="Cristian?97061516305";
    private Connection connection;
    //Connect Builder
    public DBconnection() {
    }
    //connect to DB
    public Connection connectDB(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // SQL connector Driver
            connection = DriverManager.getConnection(HOST, USER_NAME, PASSWORD);
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    //Disconnect method
    public boolean disconnectDB(){
        try{
            connection.close();
            return true;
        }catch(SQLException e){    
        }
        return false;
    }
    
    
}

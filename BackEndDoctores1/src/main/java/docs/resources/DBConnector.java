/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danid
 */
public class DBConnector {
    
    private static DBConnector instance;
    private Connection dbCon = null;
    private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    
    private DBConnector(String name, String password){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dbCon = DriverManager.getConnection(URL,name, password);
        } catch ( SQLException ex) {
            String id = "90";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getDbCon() {
        return dbCon;
    }
    
    public static DBConnector getInstance(String user, String password)throws SQLException{
        if(instance == null ){
            instance = new DBConnector(user,password);
        }else if(instance.getDbCon().isClosed()){
            instance = new DBConnector(user,password);
        }
        return instance;
    }
    
    public void CloseConecttion(){
        try{
            this.dbCon.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

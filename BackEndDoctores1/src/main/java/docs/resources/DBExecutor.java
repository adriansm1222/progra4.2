/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.resources;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import sun.tools.java.Type;
/**
 *
 * @author danid
 */

public class DBExecutor {
    DBConnector dbConnector = null;
    PreparedStatement stmt;
    ResultSet rs;

    public DBExecutor(String user, String password) {
        try{
            dbConnector = DBConnector.getInstance(user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void prepareStatement(String [] parametros){
        try{
            stmt = dbConnector.getDbCon().prepareStatement(parametros[0]);
            for(int i = 1; i< parametros.length;i++){
                if(parametros[i].equals("NULL")){
                    stmt.setNull(i, Types.NULL);
                }else{
                    stmt.setString(i,parametros[i]);
                }
            }
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public ResultSet ejecutaQuery(String sql){
        try{
            stmt = dbConnector.getDbCon().prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }
//    public static void main(String[] args) throws SQLException {
//        /*DBExecutor ex = new DBExecutor("progra4", "progra123");
//        ResultSet rsr = ex.ejecutaQuery("select id from personas where id = 45");
//        rsr.next();
//        String id = rsr.getString("id");
//        System.out.println(id);*/
//        
//        Service ser = new Service();
//        System.out.println(ser.verificarExistencia("select * from pacientes where id = 402540028"));
//    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ccs 2
 */
class db_operation {
    
    Connection conn = db_connection.connect();
    PreparedStatement statement = null;
    ResultSet result;    

    public ResultSet getColumnName() {
        try {
            String query = "SELECT DISTINCT MainGroup FROM [Anbar_db].[dbo].[List]";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            //conn.close();
            return result;
        } catch (SQLException ex) {
            ex.getStackTrace();
        } 
    return null; 
    
    } 
    
    public ResultSet relation(String input) {
        try {
            String query = "SELECT DISTINCT SubGroup FROM [Anbar_db].[dbo].[List] Where MainGroup =N'" +input+"'" ;
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            //conn.close();
            return result;
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    return null;
    }
    
}

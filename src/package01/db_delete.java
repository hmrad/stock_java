/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ccs 2
 */
class db_delete {

    Connection conn = db_connection.connect();
    PreparedStatement statement = null; 
    static int row;

    public db_delete(int row) {
        this.row=row;
        delete();
    }

    public void delete() {
        String query = "DELETE FROM [Anbar_db].[dbo].[List] "
            + "WHERE Row='"+this.row+"'";
        int res = JOptionPane.showOptionDialog(new JFrame(), "ایا از حذف این کالا اطمینان دارید؟", "Reminder", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "بله", "خیر" }, JOptionPane.YES_OPTION);
        if(res == JOptionPane.YES_OPTION) {
            try {
                statement = conn.prepareStatement(query);
                statement.execute();
                JOptionPane.showMessageDialog(null, "با موفقیت حذف شد");
            } catch (SQLException ex) {
                Logger.getLogger(db_delete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

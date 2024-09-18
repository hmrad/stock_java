package package01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * @author ccs 2
 */
public class db_search {
    
    private final String code;
    Connection conn = db_connection.connect();
    PreparedStatement statement = null;
    ResultSet result;    
    
    public db_search(String code) {
        this.code = code;
    }
   

    public ResultSet search() {

    try {
        String query = "SELECT [Row] as 'ردیف'"
                + ",[MainGroup] as 'گروه اصلی'"
                + ",[SubGroup] as 'گروه فرعی'"
                + ",[ProductCode] as 'کد قطعه'"
                + ",[Model] as 'مدل'"
                + ",[Manufacturer] as 'شرکت سازنده'"
                + ",[Location] as 'مکان'"
                + ",[Inventory] as 'موجودی'"
                + ",[Unit] as 'واحد'"
                + ",[LastPriceFee] as 'اخرین قیمت خرید'"
                + ",[LastReviewDate] as 'اخرین تاریخ بررسی'"
                + ",[Min] as 'حداقل'"
                + ",[OrderPoint] as 'نقطه سفارش'"
                + ",[Max] as 'حداکثر'"
                + " from [Anbar_db].[dbo].[List]"
                + "where (ProductCode=N'"+this.code+"'and ProductCode is not null)";
        statement = conn.prepareStatement(query);
        result = statement.executeQuery();
        } catch (SQLException ex) {
            ex.getStackTrace();
            JOptionPane.showMessageDialog(null, "داده مورد نظر یافت نشد");
        }
    return result;
    }
}

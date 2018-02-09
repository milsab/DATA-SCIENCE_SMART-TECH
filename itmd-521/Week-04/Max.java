
import java.sql.*;

public class Max
{

  public static void main(String[] args)
  {
    Connection conn = null;
    try
    {
      Class.forName("com.mysql.jdbc.Driver"); 

      String myUrl = "jdbc:mysql://localhost/itmd521?useSSL=false";
      conn = DriverManager.getConnection(myUrl, "root", "itmd521");

      String query = "SELECT max(temperature) AS max FROM records where temperature not in (9999);";

      Statement st = conn.createStatement();
      
      ResultSet rs = st.executeQuery(query);

      while (rs.next())
      {
        int max = rs.getInt("max");
        System.out.println("Maximum Tempurature in 1985 is: " + max);
      }
      st.close();
    }
    catch (SQLException ex)
    {
      System.err.println("Got an exception! ");
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
    catch(Exception ex){
      System.out.println("General Error: " + ex.getMessage());
    }
  }
}
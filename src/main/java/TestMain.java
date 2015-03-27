import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// String url = "jdbc:postgresql://localhost/testDB";
		// Properties props = new Properties();
		// props.setProperty("user","postgres");
		// props.setProperty("password","postgres");
		// //props.setProperty("ssl","true");
		// Connection conn = DriverManager.getConnection(url, props);

		
		URI dbUri = new URI("postgres://veyaazbzjxuraq:6F2QLjGz7rUbYSUxIeJeQ3Diwm@ec2-23-23-215-150.compute-1.amazonaws.com:5432/dbgf0edbg3d0at");

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		
		
		
		String url = "jdbc:postgresql://localhost/testDB?user=postgres&password=postgres";
		Connection conn = DriverManager.getConnection(url);

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM \"Challenge_Details\"");
		while (rs.next()) {
			System.out.print("Column 1 returned ");
			System.out.println(rs.getString(2));
		}
		rs.close();
		st.close();
	}

}

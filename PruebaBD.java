import java.sql.*;

public class PruebaBD {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		Connection conn = null;
		String sent = "";
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:n.db");
			Statement statement = conn.createStatement();
			
			try {
	            sent = "create table prueba (id integer, nombre string)";
		        statement.executeUpdate( sent );	
			} catch (SQLException e) {
				System.out.println("La tabla prueba ya estaba creada");
			}
			int valor = 1;
			String nombre = "Andoni";
			sent = "insert into prueba values(" + valor +",'" + nombre + "')";
			statement.executeUpdate(sent);
			
			sent = "select * from prueba";
			ResultSet rs = statement.executeQuery (sent);
			int fila = 0;
			while (rs.next()) {
				int val = rs.getInt("id");
				String nom = rs.getString ("nombre");
				fila ++;
				System.out.println("Fila" + fila + "= " + val + "-" +nom);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

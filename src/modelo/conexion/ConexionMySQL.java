package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySQL {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public ConexionMySQL() {
	}

	/*
	 * Hace una consulta a la base de datos
	 * 
	 * @param consulta consulta en forma de string
	 * 
	 * @return rs devuelve el resultado de la consulta en la base de datos
	 */
	public ResultSet consultar(String consulta) {
		conexionDB();
		try {
			rs = stmt.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/*
	 * Inserta o elimina una columna de la base de datos
	 * 
	 * @param consulta añade o elimina una columna o un atributo en la base de datos
	 */
	public void actualizar(String consulta) {
		conexionDB();
		try {
			stmt.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrarConexionDB();
	}

	/*
	 * Conecta a la base de datos
	 */
	private void conexionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/farma", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Cierra la conexión de la base de datos
	 */
	public void cerrarConexionDB() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

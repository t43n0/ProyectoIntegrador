package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.UserClave;
import model.UserData;

public class PIPersistencia {

	public boolean login(UserClave user) {
		ArrayList<UserClave> arrUc = cagarDatosBD();
		for (UserClave uc : arrUc) {
			if (uc.getUser().equals(user.getUser())) {
				if (uc.getClave().equals(user.getClave())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void registrarUserData(UserData ud) {
		Connection connection = null;
		AccesoDB con = new AccesoDB();
		try {
			connection = con.getConexion();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO DatosUsuario (Nombre, Apellidos, DNI, Ciudad) VALUES (?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, ud.getNombre());
			statement.setString(2, ud.getApellidos());
			statement.setString(3, ud.getDni());
			statement.setString(4, ud.getCiudad());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void registrarUserClave(UserClave uc) {
		Connection connection = null;
		AccesoDB con = new AccesoDB();
		try {
			connection = con.getConexion();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO InicioSesion (Usuarios, Claves) VALUES (?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, uc.getUser());
			statement.setString(2, uc.getClave());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public ArrayList<UserClave> cagarDatosBD() {

		AccesoDB adb = new AccesoDB();
		ArrayList<UserClave> ucs = new ArrayList<UserClave>();

		String sql = "SELECT * FROM InicioSesion";
		Connection conn;
		Statement stmt;
		ResultSet rs = null;
		try {
			conn = adb.getConexion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String user = rs.getString("Usuarios");
				String clave = rs.getString("Claves");
				UserClave uc = new UserClave(user, clave);
				ucs.add(uc);
			}

			rs.close();
			stmt.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ucs;
	}

}

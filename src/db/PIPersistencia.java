package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Reserva;
import model.UserData;

public class PIPersistencia {

	public boolean login(UserData user) {
		ArrayList<UserData> arrUc = cargarDatosBD();
		for (UserData uc : arrUc) {
			if (uc.getDni().equals(user.getDni())) {
				if (uc.getContrasenia().equals(user.getContrasenia())) {
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
		String sql = "INSERT INTO Usuario (Dni, Nombre, Apellido, Email, Contrasenia, " + 
		"Telefono, Direccion) VALUES (?,?,?,?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, ud.getDni());
			statement.setString(2, ud.getNombre());
			statement.setString(3, ud.getApellido());
			statement.setString(4, ud.getEmail());
			statement.setString(5, ud.getContrasenia());
			statement.setString(6, ud.getTelefono());
			statement.setString(7, ud.getDireccion());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserData> cargarDatosBD() {

		AccesoDB adb = new AccesoDB();
		ArrayList<UserData> ucs = new ArrayList<UserData>();


		String sql = "SELECT * FROM Usuario";

		Connection conn;
		Statement stmt;
		ResultSet rs = null;
		try {
			conn = adb.getConexion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String dni = rs.getString("Dni");
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				String email = rs.getString("Email");
				String contrasenia = rs.getString("Contrasenia");
				String telefono = rs.getString("Telefono");
				String direccion = rs.getString("Direccion");
				UserData uc = new UserData(dni, nombre, apellido, email, contrasenia, telefono, direccion);
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
	
	public ArrayList<UserData> getDatosUsuario(String dni){
		
		AccesoDB acceso = new AccesoDB();
		
		String query = "SELECT * FROM Usuario WHERE Dni = " + "'" + dni + "'";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		ArrayList<UserData> datosUsuario = new ArrayList<>();
		
		try {
			
			con = acceso.getConexion();

			stmt = con.createStatement();

			rslt = stmt.executeQuery(query);
			if(rslt.next()) {
				datosUsuario.add(new UserData(rslt.getString("Dni"), rslt.getString("Nombre"), 
						rslt.getString("Apellido"), rslt.getString("Email"), rslt.getString("Contrasenia"),
						rslt.getString("Telefono"), rslt.getString("Direccion")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}			
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return datosUsuario;
		
	}
	
	public ArrayList<Reserva> getReservas(int id_pista){
		
		AccesoDB acceso = new AccesoDB();
		
		ArrayList<Reserva> listaReservas = new ArrayList<>();
		
		//SELECT ID_Reserva, Dni, ID_Pista, Dia, Hora FROM Reserva WHERE ID_Pista = id_pista;
		
		String query = "SELECT ID_Reserva, Dni, ID_Pista, Dia, Hora FROM Reserva WHERE ID_Pista = " + id_pista;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();

			stmt = con.createStatement();

			rslt = stmt.executeQuery(query);
			
			if(rslt.next()) {
				listaReservas.add(new Reserva(rslt.getString("ID_Reserva"), rslt.getString("Dni"), rslt.getString("ID_Pista"), rslt.getString("Dia"), rslt.getString("Hora")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}			
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return listaReservas;
	}

	public void actualizarDatosUsuario(UserData usuario) {
		AccesoDB adb = new AccesoDB();

	    String sql = "UPDATE Usuario SET Dni = ?, Nombre = ?, Apellido = ?, " + 
	    "Email = ?, Contrasenia = ?, Telefono = ?, Direccion = ? WHERE Dni = ?";

	    try {
	        Connection conn = adb.getConexion();
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, usuario.getDni());
	        stmt.setString(2, usuario.getNombre());
	        stmt.setString(3, usuario.getApellido());
	        stmt.setString(4, usuario.getEmail());
	        stmt.setString(5, usuario.getContrasenia());
	        stmt.setString(6, usuario.getTelefono());
	        stmt.setString(7, usuario.getDireccion());
	        stmt.setString(8, usuario.getDni());
	        
	        

	        stmt.executeUpdate();
	        stmt.close();
	        conn.close();
	        
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

}

package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.PIListener;
import db.PIPersistencia;
import model.UserData;
import java.awt.Color;

public class VActualizarDatosUsuario extends JFrame{

	
	private static final long serialVersionUID = 1L;
	public static final String ACTUALIZAR = "Actualizar";
	private static final int ANCHO = 700;
	private static final int ALTO = 400;
	public static final String ATRAS = "Atras";
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private JButton btnCancelar;
	private JButton btnActualizar;
	private JTextField campoClave;
	private JTextField campoDni;
	private JTextField campoCiudad;
	
	private PIPersistencia piPersistencia;
	private JTextField campoTelefono;
	private JTextField campoEmail;
	
	public VActualizarDatosUsuario() {
		super("Actualizar datos");
		getContentPane().setBackground(new Color(255, 128, 192));
		piPersistencia = new PIPersistencia();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(115, 115, 143, 20);
		getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		btnActualizar = new JButton(ACTUALIZAR);
		btnActualizar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnActualizar.setBounds(424, 294, 143, 30);
		getContentPane().add(btnActualizar);
		
		campoApellidos = new JTextField();
		campoApellidos.setColumns(10);
		campoApellidos.setBounds(115, 181, 143, 20);
		getContentPane().add(campoApellidos);
		
		btnCancelar = new JButton(ATRAS);
		btnCancelar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnCancelar.setBounds(115, 294, 143, 30);
		getContentPane().add(btnCancelar);
		
		campoClave = new JTextField();
		campoClave.setColumns(10);
		campoClave.setBounds(424, 181, 143, 20);
		getContentPane().add(campoClave);
		
		JLabel lblUsuario = new JLabel("Nombre");
		lblUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblUsuario.setBounds(115, 98, 85, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblApellidos.setBounds(115, 145, 102, 30);
		getContentPane().add(lblApellidos);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblClave.setBounds(424, 145, 85, 30);
		getContentPane().add(lblClave);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDni.setBounds(115, 34, 85, 17);
		getContentPane().add(lblDni);
		
		JLabel lblCiudad = new JLabel("Direccion");
		lblCiudad.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblCiudad.setBounds(424, 34, 85, 17);
		getContentPane().add(lblCiudad);
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		campoDni.setBounds(115, 61, 143, 20);
		getContentPane().add(campoDni);
		
		campoCiudad = new JTextField();
		campoCiudad.setColumns(10);
		campoCiudad.setBounds(424, 61, 143, 20);
		getContentPane().add(campoCiudad);
		
		campoTelefono = new JTextField();
		campoTelefono.setBounds(115, 240, 143, 20);
		getContentPane().add(campoTelefono);
		campoTelefono.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(424, 115, 143, 20);
		getContentPane().add(campoEmail);
		campoEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblTelefono.setBounds(115, 221, 85, 17);
		getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEmail.setBounds(424, 98, 85, 17);
		getContentPane().add(lblEmail);
		
		centrarVentana();
		//habilitarDatos(true);
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	/*
	public void habilitarDatos(boolean opcion) {
		campoNombre.setEnabled(opcion);
		campoApellidos.setEnabled(opcion);
		campoCiudad.setEnabled(opcion);
		campoClave.setEnabled(opcion);
		campoConfirmarClave.setEnabled(opcion);
		
		campoDni.setEnabled(!opcion);
	}*/
	
	public void mostrarDatosusuario() {
		String dni = PIListener.DNI;
		ArrayList<UserData> datosUsuario = piPersistencia.getDatosUsuario(dni);
		
		for (UserData userData : datosUsuario) {
			campoDni.setText(dni);
			campoNombre.setText(userData.getNombre());
			campoApellidos.setText(userData.getApellido());
			campoCiudad.setText(userData.getDireccion());
			campoClave.setText(userData.getContrasenia());
			campoTelefono.setText(userData.getTelefono());
			campoEmail.setText(userData.getEmail());
			
		}
	}

	public void setActionListener(PIListener l) {

		btnCancelar.addActionListener(l);
		btnActualizar.addActionListener(l);
		
	}

	public UserData cargarUsuario() {
		return new UserData(campoDni.getText(), campoNombre.getText(), campoApellidos.getText(),
				campoEmail.getText(), campoClave.getText(), campoTelefono.getText(), campoCiudad.getText());
	}
}

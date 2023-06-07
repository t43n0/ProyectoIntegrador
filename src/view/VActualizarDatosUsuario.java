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
	private JTextField campoConfirmarClave;
	private JTextField campoDni;
	private JTextField campoCiudad;
	
	private PIPersistencia piPersistencia;
	
	public VActualizarDatosUsuario() {
		super();
		piPersistencia = new PIPersistencia();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(424, 56, 143, 20);
		getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		btnActualizar = new JButton(ACTUALIZAR);
		btnActualizar.setBounds(424, 199, 127, 30);
		getContentPane().add(btnActualizar);
		
		campoApellidos = new JTextField();
		campoApellidos.setColumns(10);
		campoApellidos.setBounds(136, 129, 143, 20);
		getContentPane().add(campoApellidos);
		
		btnCancelar = new JButton(ATRAS);
		btnCancelar.setBounds(424, 294, 127, 30);
		getContentPane().add(btnCancelar);
		
		campoClave = new JTextField();
		campoClave.setColumns(10);
		campoClave.setBounds(189, 218, 143, 20);
		getContentPane().add(campoClave);
		
		campoConfirmarClave = new JTextField();
		campoConfirmarClave.setColumns(10);
		campoConfirmarClave.setBounds(189, 259, 143, 20);
		getContentPane().add(campoConfirmarClave);
		
		JLabel lblUsuario = new JLabel("Nombre");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(311, 55, 85, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(24, 121, 102, 30);
		getContentPane().add(lblApellidos);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClave.setBounds(24, 218, 85, 30);
		getContentPane().add(lblClave);
		
		JLabel lblConfirmarClave = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarClave.setBounds(24, 258, 155, 37);
		getContentPane().add(lblConfirmarClave);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(24, 55, 85, 17);
		getContentPane().add(lblDni);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCiudad.setBounds(311, 128, 85, 17);
		getContentPane().add(lblCiudad);
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		campoDni.setBounds(136, 56, 143, 20);
		getContentPane().add(campoDni);
		
		campoCiudad = new JTextField();
		campoCiudad.setColumns(10);
		campoCiudad.setBounds(424, 129, 143, 20);
		getContentPane().add(campoCiudad);
		
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
			campoApellidos.setText(userData.getApellidos());
			campoCiudad.setText(userData.getCiudad());
			
		}
	}

	public void setActionListener(PIListener l) {

		btnCancelar.addActionListener(l);
		btnActualizar.addActionListener(l);
		
	}
	
	
}

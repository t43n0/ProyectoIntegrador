package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import control.PIListener;
import model.UserData;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VRegistrar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String REGISTRAR = "Registrar";
	private static final int ANCHO = 700;
	private static final int ALTO = 400;
	public static final String CANCELAR = "Cancelar";
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JTextField campoContrasenia;
	private JTextField campoDni;
	private JTextField campoCiudad;
	private JTextField campoEmail;
	private JTextField campoTelefono;
	
	public VRegistrar() {
		super("Registro usuario");
		getContentPane().setBackground(new Color(255, 128, 192));
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(118, 60, 143, 20);
		getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		btnRegistrar = new JButton(REGISTRAR);
		btnRegistrar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnRegistrar.setBounds(443, 290, 143, 44);
		getContentPane().add(btnRegistrar);
		
		campoApellidos = new JTextField();
		campoApellidos.setColumns(10);
		campoApellidos.setBounds(118, 110, 143, 20);
		getContentPane().add(campoApellidos);
		
		btnCancelar = new JButton(CANCELAR);
		btnCancelar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnCancelar.setBounds(118, 290, 143, 44);
		getContentPane().add(btnCancelar);
		
		campoContrasenia = new JTextField();
		campoContrasenia.setColumns(10);
		campoContrasenia.setBounds(118, 204, 143, 20);
		getContentPane().add(campoContrasenia);
		
		JLabel lblUsuario = new JLabel("Nombre");
		lblUsuario.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblUsuario.setBounds(41, 59, 85, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblApellidos = new JLabel("Apellido");
		lblApellidos.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblApellidos.setBounds(41, 102, 102, 30);
		getContentPane().add(lblApellidos);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblClave.setBounds(348, 52, 85, 30);
		getContentPane().add(lblClave);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDni.setBounds(41, 155, 85, 17);
		getContentPane().add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDireccion.setBounds(348, 109, 85, 17);
		getContentPane().add(lblDireccion);
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		campoDni.setBounds(443, 60, 143, 20);
		getContentPane().add(campoDni);
		
		campoCiudad = new JTextField();
		campoCiudad.setColumns(10);
		campoCiudad.setBounds(443, 107, 143, 20);
		getContentPane().add(campoCiudad);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEmail.setBounds(41, 203, 85, 17);
		getContentPane().add(lblEmail);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(118, 156, 143, 20);
		getContentPane().add(campoEmail);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblTelfono.setBounds(348, 155, 85, 17);
		getContentPane().add(lblTelfono);
		
		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(443, 156, 143, 20);
		getContentPane().add(campoTelefono);
		
		centrarVentana();
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void cambiarVentana(JFrame v1, JFrame v2) {
		v1.dispose();
		v2.setVisible(true);
	}
	
	public UserData getUserData() {
		return new UserData(campoDni.getText(), campoNombre.getText(), campoApellidos.getText(),
				campoEmail.getText(), campoContrasenia.getText(), campoTelefono.getText(),
				campoCiudad.getText());
	}
	
	public boolean comprobarUsuario() {
		return false;
		
	}	
	
	public void setActionListener(PIListener l) {
		btnRegistrar.addActionListener(l);
		btnCancelar.addActionListener(l);
	}
}

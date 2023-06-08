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
		super();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(136, 56, 143, 20);
		getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		btnRegistrar = new JButton(REGISTRAR);
		btnRegistrar.setBounds(474, 203, 126, 62);
		getContentPane().add(btnRegistrar);
		
		campoApellidos = new JTextField();
		campoApellidos.setColumns(10);
		campoApellidos.setBounds(136, 107, 143, 20);
		getContentPane().add(campoApellidos);
		
		btnCancelar = new JButton(CANCELAR);
		btnCancelar.setBounds(457, 297, 143, 44);
		getContentPane().add(btnCancelar);
		
		campoContrasenia = new JTextField();
		campoContrasenia.setColumns(10);
		campoContrasenia.setBounds(136, 203, 143, 20);
		getContentPane().add(campoContrasenia);
		
		JLabel lblUsuario = new JLabel("Nombre");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(24, 59, 85, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblApellidos = new JLabel("Apellido");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(24, 110, 102, 30);
		getContentPane().add(lblApellidos);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClave.setBounds(24, 196, 85, 30);
		getContentPane().add(lblClave);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(311, 59, 85, 17);
		getContentPane().add(lblDni);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(311, 110, 85, 17);
		getContentPane().add(lblDireccion);
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		campoDni.setBounds(424, 56, 143, 20);
		getContentPane().add(campoDni);
		
		campoCiudad = new JTextField();
		campoCiudad.setColumns(10);
		campoCiudad.setBounds(424, 107, 143, 20);
		getContentPane().add(campoCiudad);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(24, 155, 85, 17);
		getContentPane().add(lblEmail);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(136, 156, 143, 20);
		getContentPane().add(campoEmail);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelfono.setBounds(311, 159, 85, 17);
		getContentPane().add(lblTelfono);
		
		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(424, 156, 143, 20);
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

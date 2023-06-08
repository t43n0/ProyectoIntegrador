package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import control.PIListener;
import model.UserData;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Color;

public class VLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String REGISTRARSE = "Registrarse";
	private static final int ANCHO = 400;
	private static final int ALTO = 200;
	public static final String INISESION = "Iniciar sesión";
	
	private JTextField campoDni;
	private JButton btnInicioSesion;
	private JButton btnRegistrar;
	private final JLabel lblDni = new JLabel("Dni");
	private JPasswordField campoClave;
	
	public VLogin() {
		super("Log-in");
		getContentPane().setBackground(new Color(255, 128, 192));
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		campoDni = new JTextField();
		campoDni.setBounds(27, 39, 143, 20);
		getContentPane().add(campoDni);
		campoDni.setColumns(10);
		
		btnRegistrar = new JButton(REGISTRARSE);
		btnRegistrar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnRegistrar.setBounds(248, 102, 111, 21);
		getContentPane().add(btnRegistrar);
		
		btnInicioSesion = new JButton(INISESION);
		btnInicioSesion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnInicioSesion.setBounds(248, 38, 111, 21);
		getContentPane().add(btnInicioSesion);
		lblDni.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblDni.setBounds(27, 0, 126, 36);
		getContentPane().add(lblDni);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblClave.setBounds(27, 67, 126, 36);
		getContentPane().add(lblClave);
		
		campoClave = new JPasswordField();
		campoClave.setEchoChar('*');
		campoClave.setBounds(27, 103, 143, 19);
		getContentPane().add(campoClave);
		
		centrarVentana();
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
	}
	
	public void cambiarVentana(JFrame v1, JFrame v2) {
		v1.dispose();
		v2.setVisible(true);
	}
	
	public boolean comprobarUsuario() {
		return false;
		
	}
	
	public UserData getUserData() {
		char[] passwordChars = campoClave.getPassword();
		String password = new String(passwordChars);
		UserData ud = new UserData(campoDni.getText(), "", "", "", password, "", "");
		return ud;
	}
	
	public String getDniActual() {
		
		String dni = campoDni.getText();
		
		return dni; 
	}
	
	public void setActionListener(PIListener l) {
		btnInicioSesion.addActionListener(l);
		btnRegistrar.addActionListener(l);
	}
	
	public void mostrarError(String mensaje) {

		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}

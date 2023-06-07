package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import control.PIListener;
import model.UserClave;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class VLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String REGISTRARSE = "Registrarse";
	private static final int ANCHO = 400;
	private static final int ALTO = 200;
	public static final String INISESION = "Iniciar sesi�n";
	private JTextField campoUsuario;
	private JButton btnInicioSesion;
	private JButton btnRegistrar;
	private final JLabel lblUsuario = new JLabel("Usuario");
	private JPasswordField campoClave;
	
	public VLogin() {
		super();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(27, 39, 143, 20);
		getContentPane().add(campoUsuario);
		campoUsuario.setColumns(10);
		
		btnRegistrar = new JButton(REGISTRARSE);
		btnRegistrar.setBounds(248, 102, 111, 21);
		getContentPane().add(btnRegistrar);
		
		btnInicioSesion = new JButton(INISESION);
		btnInicioSesion.setBounds(248, 38, 111, 21);
		getContentPane().add(btnInicioSesion);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(27, 0, 126, 36);
		getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
	
	public String getUsuarioActual() {
		
		String usuario = campoUsuario.getText();
		
		return usuario; 
	}
	
	public UserClave getUserClave() {
		return new UserClave(campoUsuario.getText(), campoClave.getText());
	}
	
	public void setActionListener(PIListener l) {
		btnInicioSesion.addActionListener(l);
		btnRegistrar.addActionListener(l);
	}
}

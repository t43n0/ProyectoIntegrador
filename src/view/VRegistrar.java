package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import control.PIListener;
import model.UserClave;
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
	private JTextField campoClave;
	private JTextField campoConfirmarClave;
	private JTextField campoDni;
	private JTextField campoCiudad;
	
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
		btnRegistrar.setBounds(453, 203, 85, 21);
		getContentPane().add(btnRegistrar);
		
		campoApellidos = new JTextField();
		campoApellidos.setColumns(10);
		campoApellidos.setBounds(136, 107, 143, 20);
		getContentPane().add(campoApellidos);
		
		btnCancelar = new JButton(CANCELAR);
		btnCancelar.setBounds(440, 258, 111, 21);
		getContentPane().add(btnCancelar);
		
		campoClave = new JTextField();
		campoClave.setColumns(10);
		campoClave.setBounds(136, 203, 143, 20);
		getContentPane().add(campoClave);
		
		campoConfirmarClave = new JTextField();
		campoConfirmarClave.setColumns(10);
		campoConfirmarClave.setBounds(189, 245, 143, 20);
		getContentPane().add(campoConfirmarClave);
		
		JLabel lblUsuario = new JLabel("Nombre");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(24, 59, 85, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(24, 110, 102, 30);
		getContentPane().add(lblApellidos);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClave.setBounds(24, 196, 85, 30);
		getContentPane().add(lblClave);
		
		JLabel lblConfirmarClave = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarClave.setBounds(24, 234, 155, 37);
		getContentPane().add(lblConfirmarClave);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(311, 59, 85, 17);
		getContentPane().add(lblDni);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCiudad.setBounds(311, 110, 85, 17);
		getContentPane().add(lblCiudad);
		
		campoDni = new JTextField();
		campoDni.setColumns(10);
		campoDni.setBounds(424, 56, 143, 20);
		getContentPane().add(campoDni);
		
		campoCiudad = new JTextField();
		campoCiudad.setColumns(10);
		campoCiudad.setBounds(424, 107, 143, 20);
		getContentPane().add(campoCiudad);
		
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
	
	public UserClave getUserClave() {
		if(!campoNombre.getText().isBlank()) {
			return new UserClave(campoNombre.getText(), campoClave.getText());
		}
		return null;
	}
	
	//public UserData getUserData() {
		//TODO return new UserData(campoNombre.getText(), campoApellidos.getText(), 
				//campoDni.getText(), campoCiudad.getText());
	//}
	
	
	public boolean comprobarUsuario() {
		return false;
		
	}	
	
	public void setActionListener(PIListener l) {
		btnRegistrar.addActionListener(l);
		btnCancelar.addActionListener(l);
	}
}

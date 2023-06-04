package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import control.PIListener;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

public class VPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String REGISTRAR = "Registrar";
	private static final int ANCHO = 800;
	private static final int ALTO = 500;
	public static final String VOLVER = "Volver";
	private JScrollPane scrpContenedor;
	private JButton btnVolver;
	
	public VPrincipal() {
		super();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(222, 14, 2, 2);
		getContentPane().add(scrpContenedor);
		
		btnVolver = new JButton(VOLVER);
		btnVolver.setBounds(328, 387, 111, 21);
		getContentPane().add(btnVolver);
		
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
	
	public boolean comprobarUsuario() {
		return false;
		
	}
	
	public void registrarse() {
		
	}
	
	public void setActionListener(PIListener l) {
		btnVolver.addActionListener(l);
	}
}

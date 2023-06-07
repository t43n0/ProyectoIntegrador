package view;

import javax.swing.JFrame;
import control.PIListener;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

public class VPrincipal extends JFrame {
	public static final String CONSULTA_DE_RESERVAS = "Consulta de Reservas";
	public static final String ACTUALIZAR_DATOS_DEL_USUARIO = "Actualizar Datos del Usuario";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String RESERVAR_PISTAS = "Reservar Pistas";
	private static final int ANCHO = 800;
	private static final int ALTO = 500;
	public static final String VOLVER = "Volver";
	private JButton btnVolver;
	private JButton btnReservarPista;
	private JButton btnActualizarDatos;
	private JButton btnConsulta;
	
	public VPrincipal() {
		super();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		btnVolver = new JButton(VOLVER);
		btnVolver.setBounds(328, 387, 111, 21);
		getContentPane().add(btnVolver);
		
		btnReservarPista = new JButton(RESERVAR_PISTAS);
		btnReservarPista.setBounds(53, 52, 233, 81);
		getContentPane().add(btnReservarPista);
		
		btnActualizarDatos = new JButton(ACTUALIZAR_DATOS_DEL_USUARIO);
		btnActualizarDatos.setBounds(500, 64, 212, 68);
		getContentPane().add(btnActualizarDatos);
		
		btnConsulta = new JButton(CONSULTA_DE_RESERVAS);
		btnConsulta.setBounds(268, 239, 233, 81);
		getContentPane().add(btnConsulta);
		
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
		btnReservarPista.addActionListener(l);
		btnActualizarDatos.addActionListener(l);
		btnConsulta.addActionListener(l);
		
	}
}
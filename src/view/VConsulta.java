package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import control.PIListener;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class VConsulta extends JFrame {
	public static final String ACTUALIZAR_DATOS_DEL_USUARIO = "Actualizar Datos del Usuario";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String RESERVAR_PISTAS = "Reservar Pistas";
	private static final int ANCHO = 800;
	private static final int ALTO = 500;
	public static final String VOLVER_ATRAS = "Volver Atras";
	private JButton btnVolver;
	private JTable tblTabla;
	
	public VConsulta() {
		super();
		inicio();
	}
	
	private void inicio() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		btnVolver = new JButton(VOLVER_ATRAS);
		btnVolver.setBounds(329, 432, 111, 21);
		getContentPane().add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Consultar Reservas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 10, 231, 27);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 47, 656, 359);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(691, 416, 85, 21);
		getContentPane().add(btnEliminar);
		
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
	
	public void registrarse() {
		
	}
	
	public void setActionListener(PIListener l) {
		btnVolver.addActionListener(l);
	}
}
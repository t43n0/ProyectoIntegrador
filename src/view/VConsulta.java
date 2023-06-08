package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import control.PIListener;
import model.Reserva;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

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
	private DefaultTableModel modeloTabla;
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
		tblTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblTabla);
		
		centrarVentana();
	}
	
	public void configurarTabla() {
		modeloTabla = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			@Override
			public void setValueAt(Object aValue, int row, int column) {
				
			}
		};
		modeloTabla.addColumn("ID_Reserva");
		modeloTabla.addColumn("DNI");
		modeloTabla.addColumn("ID_Pista");
		modeloTabla.addColumn("Dia");
		modeloTabla.addColumn("Hora");
		tblTabla.setModel(modeloTabla);
	}
	
	public void cargarTabla(ArrayList<Reserva> rts) {
		modeloTabla.setRowCount(0);
		
		Object [] fila = new Object[5];
		
		for (Reserva rt : rts) {
			fila[0] = rt.getId_reserva();
			fila[1] = rt.getDni();
			fila[2] = rt.getId_pista();
			fila[3] = rt.getDia();
			fila[4] = rt.getHora();
			
			modeloTabla.addRow(fila);
		}
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
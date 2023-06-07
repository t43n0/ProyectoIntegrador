package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;

public class PReservarPista extends JFrame{
	private JComboBox cmbDeporte;
	private JComboBox cmbPista;

	
	public PReservarPista(){
		setLayout(null);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(46, 54, 57, 23);
		add(lblDeporte);
		
		cmbDeporte = new JComboBox();
		cmbDeporte.setModel(new DefaultComboBoxModel(new String[] {"Selecciona un deporte", "Baloncesto", "F\u00FAtbol", "Tenis", "Padel"}));
		cmbDeporte.setBounds(116, 54, 137, 23);
		add(cmbDeporte);
		
		JLabel lblPista = new JLabel("Pista");
		lblPista.setBounds(46, 103, 46, 14);
		add(lblPista);
		
		cmbPista = new JComboBox();
		cmbPista.setBounds(116, 99, 137, 23);
		add(cmbPista);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(46, 144, 46, 14);
		add(lblDia);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(46, 180, 46, 14);
		add(lblHora);
		
		JComboBox cmbDia = new JComboBox();
		cmbDia.setBounds(116, 140, 137, 23);
		add(cmbDia);
		
		JComboBox cmbHora = new JComboBox();
		cmbHora.setBounds(116, 176, 137, 23);
		add(cmbHora);
		init();
	}

	private void init() {
		
	}
}

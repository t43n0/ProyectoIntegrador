package view;

import db.PIPersistencia;
import model.Reserva;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PReservarPista extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 800;
	private static final int ALTO = 500;
	private JComboBox<String> cmbPista;
	private JComboBox<String> cmbDia;
	private JComboBox<String> cmbHora;
	private ArrayList<String> listaDias = new ArrayList<>(Arrays.asList("Lunes", "Martes","Miercoles", "Jueves", "Viernes"));
	private ArrayList<String> listaHoras = new ArrayList<>(Arrays.asList("10", "11","12"));
	private ArrayList<String> listaPistas = new ArrayList<>(Arrays.asList("Pista de Tenis", "Pista de Fútbol", "Pista de Pádel"));

	private PIPersistencia piPersistencia;

	
	public PReservarPista(){
		piPersistencia = new PIPersistencia();
		init();
	}

	private void init() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		JLabel lblPista = new JLabel("Pista");
		lblPista.setBounds(46, 103, 46, 14);
		getContentPane().add(lblPista);
		
		cmbPista = new JComboBox<String>();
		cmbPista.setBounds(116, 99, 137, 23);
		getContentPane().add(cmbPista);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(46, 144, 46, 14);
		getContentPane().add(lblDia);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(46, 180, 46, 14);
		getContentPane().add(lblHora);
		
		cmbDia = new JComboBox<String>();
		cmbDia.setBounds(116, 140, 137, 23);
		getContentPane().add(cmbDia);
		
		cmbHora = new JComboBox<String>();
		cmbHora.setBounds(116, 176, 137, 23);
		getContentPane().add(cmbHora);
		
		JButton btnReservar = new JButton("Reservar Pista");
		btnReservar.setBounds(379, 219, 196, 48);
		getContentPane().add(btnReservar);
		
		centrarVentana();
	}
	
	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	
	private void ActualizarComboBox() {
		
		int id_pista = 0;
		
		if(cmbPista.getSelectedItem().equals("Pista de Tenis")) {
			id_pista = 1;
		} else if(cmbPista.getSelectedItem().equals("Pista de Fútbol")) {
			id_pista = 2;
		} else if(cmbPista.getSelectedItem().equals("Pista de Pádel")) {
			id_pista = 3;
		}
		
		
		ArrayList<Reserva> listaReservas = piPersistencia.getReservas(id_pista);
		
		String pista = (String) cmbPista.getSelectedItem();
		
		
		//Pides la pista, compruebas a ver si hay una reserva con esa pista y si la hay quitas el dia del array de dias y luego compruebas el dia 
		//que ha seleccionado y si es igual que el de la reserva quitas la hora que haya en la reserva de la base de datos 
		//y lo cargas en el setModel, hay que hacer que cuando selecciones una pista te cargue el dia y cuando seleccionas el dia te cargue la hora por lo que 
		//tendra 
		
		
		for (Reserva reserva : listaReservas) {
			
			if(pista.equals(reserva.getId_pista())) {
				
				for (int i = 0; i < listaDias.size(); i++) {
					
					if (listaDias.get(i).equals(reserva.getDia())) {
						
						listaDias.remove(i);
						
						for (int j = 0; j < listaHoras.size(); j++) {
							
							if(listaHoras.get(j).equals(reserva.getHora())) {
								listaHoras.remove(j);
							}
							
						}
					}
				}
				
			}
		}
		
		cmbDia.setModel(new DefaultComboBoxModel<String>((String[]) listaDias.toArray()));
		cmbHora.setModel(new DefaultComboBoxModel<String>((String[]) listaHoras.toArray()));
		cmbPista.setModel(new DefaultComboBoxModel<String>((String[]) listaPistas.toArray()));

			
	}
}

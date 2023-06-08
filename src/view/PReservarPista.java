package view;

import db.PIPersistencia;
import model.Reserva;

import javax.swing.JLabel;

import control.PIListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;


public class PReservarPista extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String RETROCEDER = "Retroceder";
	public static final String RESERVAR_PISTA = "Reservar Pista";
	private JButton btnReservar;
	private static final int ANCHO = 800;
	private static final int ALTO = 500;

	private JComboBox<String> cmbPista;
	private JComboBox<String> cmbDia;
	private JComboBox<String> cmbHora;
	private ArrayList<String> listaDias = new ArrayList<>(Arrays.asList("Lunes", "Martes","Miercoles", "Jueves", "Viernes"));
	private ArrayList<String> listaHoras = new ArrayList<>(Arrays.asList("10", "11","12"));
	private ArrayList<String> listaPistas = new ArrayList<>(Arrays.asList("Pista de Tenis", "Pista de Fútbol", "Pista de Pádel"));

	private PIPersistencia piPersistencia;

	private int id_pista;
	private JButton btnRetroceder;

	
	public PReservarPista(){
		super("Reservas");
		getContentPane().setBackground(new Color(255, 128, 192));
		piPersistencia = new PIPersistencia();
		init();
	}

	private void init() {
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		JLabel lblPista = new JLabel("Pista");
		lblPista.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblPista.setBounds(161, 82, 46, 23);
		getContentPane().add(lblPista);
		
		cmbPista = new JComboBox<String>();

		cmbPista.setBounds(118, 115, 137, 23);

		getContentPane().add(cmbPista);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDia.setBounds(370, 82, 46, 23);
		getContentPane().add(lblDia);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblHora.setBounds(558, 91, 46, 14);
		getContentPane().add(lblHora);
		
		cmbDia = new JComboBox<String>();
		cmbDia.setBounds(324, 115, 137, 23);
		getContentPane().add(cmbDia);
		
		cmbHora = new JComboBox<String>();
		cmbHora.setBounds(516, 115, 137, 23);
		getContentPane().add(cmbHora);
		
		btnReservar = new JButton(RESERVAR_PISTA);
		btnReservar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnReservar.setBounds(300, 253, 196, 48);
		getContentPane().add(btnReservar);
		
		btnRetroceder = new JButton("Retroceder");
		btnRetroceder.setBounds(358, 375, 85, 21);
		getContentPane().add(btnRetroceder);
		
		centrarVentana();
		
		rellenarComboBox();
	}
	

	private void rellenarComboBox() {
		cmbPista.setModel(new DefaultComboBoxModel<String>());
		for (String pista : listaPistas) {
			cmbPista.addItem(pista);
		}		
	}

	private void centrarVentana() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void actualizarComboBox() {
		
		cmbDia.removeAllItems();
		cmbHora.removeAllItems();
		cmbPista.removeAllItems();
		
		listaDias = new ArrayList<>(Arrays.asList("Lunes", "Martes","Miercoles", "Jueves", "Viernes"));
		listaHoras = new ArrayList<>(Arrays.asList("10", "11","12"));
		listaPistas = new ArrayList<>(Arrays.asList("Pista de Tenis", "Pista de Fútbol", "Pista de Pádel"));
		
		
		ArrayList<Reserva> listaReservas = piPersistencia.getReservas(id_pista);
				
		
		//Pides la pista, compruebas a ver si hay una reserva con esa pista y si la hay quitas el dia del array de dias y luego compruebas el dia 
		//que ha seleccionado y si es igual que el de la reserva quitas la hora que haya en la reserva de la base de datos 
		//y lo cargas en el setModel, hay que hacer que cuando selecciones una pista te cargue el dia y cuando seleccionas el dia te cargue la hora 
		
		
		for (Reserva reserva : listaReservas) {
			
			if(id_pista == reserva.getId_pista()) {
				
				
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
		
		cmbDia.setModel(new DefaultComboBoxModel<String>());
		for (String dia : listaDias) {
			cmbDia.addItem(dia);
		}
		cmbHora.setModel(new DefaultComboBoxModel<String>());
		for (String hora : listaHoras) {
			cmbHora.addItem(hora);
		}
		cmbPista.setModel(new DefaultComboBoxModel<String>());
		for (String pistas : listaPistas) {
			cmbPista.addItem(pistas);
		}

			
	}

	public void reservarPista() {
		
		String dia = (String) cmbDia.getSelectedItem();
		String hora = (String) cmbHora.getSelectedItem();
		
		Reserva reservaDatos = new Reserva(PIListener.DNI, id_pista, dia, hora);
		
		piPersistencia.realizarReserva(reservaDatos);
		listaDias = new ArrayList<>(Arrays.asList("Lunes", "Martes","Miercoles", "Jueves", "Viernes"));
		listaHoras = new ArrayList<>(Arrays.asList("10", "11","12"));
		listaPistas = new ArrayList<>(Arrays.asList("Pista de Tenis", "Pista de Fútbol", "Pista de Pádel"));
		
	}


	public void setActionListener(PIListener l) {
		btnReservar.addActionListener(l);
		btnRetroceder.addActionListener(l);
		cmbPista.addActionListener(l);
		
	}

	public void getID_Pista() {
		id_pista = 0;
		
		if(cmbPista.getSelectedItem().equals("Pista de Tenis")) {
			id_pista = 1;
		} else if(cmbPista.getSelectedItem().equals("Pista de Fútbol")) {
			id_pista = 2;
		} else if(cmbPista.getSelectedItem().equals("Pista de Pádel")) {
			id_pista = 3;
		}		
		
	}

	public void mostrarComboBox(boolean opcion) {
		
	}
}

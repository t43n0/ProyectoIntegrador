package main;

import java.awt.EventQueue;
import control.PIListener;
import view.PReservarPista;
import view.VActualizarDatosUsuario;
import view.VConsulta;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class principal {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VLogin vL = new VLogin();
				VRegistrar vR = new VRegistrar();
				VPrincipal vP = new VPrincipal();
				PReservarPista pR = new PReservarPista();
				VActualizarDatosUsuario vA = new VActualizarDatosUsuario();
				VConsulta vC = new VConsulta();
				
				PIListener l = new PIListener(vL, vR, vP, pR, vA, vC);
				
				vP.setActionListener(l);
				vR.setActionListener(l);
				vL.setActionListener(l);
				vA.setActionListener(l);
				vC.setActionListener(l);
				pR.setActionListener(l);
				vL.setVisible(true);
				
			}
		});
	}
}

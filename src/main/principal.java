package main;

import java.awt.EventQueue;
import control.PIListener;
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
				
				PIListener l = new PIListener(vL, vR, vP);
				
				vP.setActionListener(l);
				vR.setActionListener(l);
				vL.setActionListener(l);
				vL.setVisible(true);
				
			}
		});
	}
}

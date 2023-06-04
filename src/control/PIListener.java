package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import db.PIPersistencia;
import model.UserClave;
import model.UserData;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class PIListener implements ActionListener{
	
	private VLogin vL;
	private VRegistrar vR;
	private VPrincipal vP;
	private PIPersistencia pip = new PIPersistencia();

	public PIListener(VLogin vL, VRegistrar vR, VPrincipal vP) {
		this.vL = vL;
		this.vR = vR;
		this.vP = vP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(VLogin.REGISTRARSE)) {
			vL.cambiarVentana(vL, vR);
		}
		if(e.getActionCommand().equals(VLogin.INISESION)) {
			UserClave user = vL.getUserClave();
			if(pip.login(user)) {
				vL.cambiarVentana(vL, vP);
			}
		}
		if(e.getActionCommand().equals(VRegistrar.REGISTRAR)) {
			UserClave user = vR.getUserClave();
			UserData ud = vR.getUserData();
			pip.registrarUserClave(user);
			pip.registrarUserData(ud);
		}
		if(e.getActionCommand().equals(VRegistrar.CANCELAR)) {
			vR.cambiarVentana(vR, vL);
		}
		if(e.getActionCommand().equals(VPrincipal.VOLVER)) {
			vP.cambiarVentana(vP, vL);
		}
	}

}

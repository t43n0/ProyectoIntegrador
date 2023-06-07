package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import db.PIPersistencia;
import model.UserClave;
import model.UserData;
import view.PReservarPista;
import view.VActualizarDatosUsuario;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class PIListener implements ActionListener{
	
	private VLogin vL;
	private VRegistrar vR;
	private VPrincipal vP;
	private PReservarPista pR;
	private VActualizarDatosUsuario vA;
	private PIPersistencia pip = new PIPersistencia();

	public PIListener(VLogin vL, VRegistrar vR, VPrincipal vP, PReservarPista pR, VActualizarDatosUsuario vA) {
		this.vL = vL;
		this.vR = vR;
		this.vP = vP;
		this.pR = pR;
		this.vA = vA;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(VLogin.REGISTRARSE)) {
				vL.cambiarVentana(vL, vR);
			}else if(e.getActionCommand().equals(VLogin.INISESION)) {
				UserClave user = vL.getUserClave();
				if(pip.login(user)) {
					vL.cambiarVentana(vL, vP);
				}
			}else if(e.getActionCommand().equals(VRegistrar.REGISTRAR)) {
				UserClave user = vR.getUserClave();
				UserData ud = vR.getUserData();
				pip.registrarUserClave(user);
				pip.registrarUserData(ud);
			}else if(e.getActionCommand().equals(VRegistrar.CANCELAR)) {
				vR.cambiarVentana(vR, vL);
			}else if(e.getActionCommand().equals(VPrincipal.VOLVER)) {
				vP.cambiarVentana(vP, vL);
			}else if(e.getActionCommand().equals(VPrincipal.RESERVAR_PISTAS)){
				//TODO vP.cambiarVentana(vP, pR);
			}else if(e.getActionCommand().equals(VPrincipal.ACTUALIZAR_DATOS_DEL_USUARIO)) {
				vP.cambiarVentana(vP, vA);
				vA.mostrarDatosusuario();

			}
		}
		
		
	}

}

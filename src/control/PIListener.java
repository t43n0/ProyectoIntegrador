package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import db.PIPersistencia;
import model.UserData;
import view.PReservarPista;
import view.VActualizarDatosUsuario;
import view.VConsulta;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class PIListener implements ActionListener{
	
	private VLogin vL;
	private VRegistrar vR;
	private VPrincipal vP;
	private PReservarPista pR;
	private VActualizarDatosUsuario vA;
	private VConsulta vC;
	private PIPersistencia pip = new PIPersistencia();
	
	public static String DNI;

	public PIListener(VLogin vL, VRegistrar vR, VPrincipal vP, PReservarPista pR, VActualizarDatosUsuario vA, VConsulta vC) {
		this.vL = vL;
		this.vR = vR;
		this.vP = vP;
		this.pR = pR;
		this.vA = vA;
		this.vC = vC;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals(VLogin.REGISTRARSE)) {
				vL.cambiarVentana(vL, vR);
			}else if(e.getActionCommand().equals(VLogin.INISESION)) {

				UserData user = vL.getUserData();

				DNI = vL.getDniActual();
				if(pip.login(user)) {
					vL.cambiarVentana(vL, vP);
				}else {
					vL.mostrarError("No se ha encontrado este usuario");
				}
			}else if(e.getActionCommand().equals(VRegistrar.REGISTRAR)) {
				UserData ud = vR.getUserData();
				pip.registrarUserData(ud);
			}else if(e.getActionCommand().equals(VRegistrar.CANCELAR)) {
				vR.cambiarVentana(vR, vL);
			}else if(e.getActionCommand().equals(VPrincipal.VOLVER)) {
				vP.cambiarVentana(vP, vL);
			}else if(e.getActionCommand().equals(VPrincipal.RESERVAR_PISTAS)){
				vP.cambiarVentana(vP, pR);
			}else if(e.getActionCommand().equals(VPrincipal.ACTUALIZAR_DATOS_DEL_USUARIO)) {
				vP.cambiarVentana(vP, vA);
				vA.mostrarDatosusuario();

			}else if(e.getActionCommand().equals(VActualizarDatosUsuario.ATRAS)) {
				vP.cambiarVentana(vA, vP);
			}else if(e.getActionCommand().equals(VPrincipal.CONSULTA_DE_RESERVAS)) {
				vP.cambiarVentana(vP, vC);
			}else if(e.getActionCommand().equals(VConsulta.VOLVER_ATRAS)) {
				vP.cambiarVentana(vC, vP);
			}else if(e.getActionCommand().equals(PReservarPista.RESERVAR_PISTA)) {
				pR.reservarPista();
				pR.actualizarComboBox();
			}else if(e.getActionCommand().equals(PReservarPista.RETROCEDER)){
				vP.cambiarVentana(pR, vP);
			} 
			
		} else if(e.getSource() instanceof JComboBox) {
			pR.getID_Pista();
			pR.actualizarComboBox();
			
			//pR.mostrarComboBox();
		}
		
		
	}

}

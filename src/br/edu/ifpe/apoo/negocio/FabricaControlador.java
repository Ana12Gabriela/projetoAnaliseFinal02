package br.edu.ifpe.apoo.negocio;

public class FabricaControlador {
public static IControladorHospede getControladorHospede() {
		
		return new ControladorHospede();
		
	}

}

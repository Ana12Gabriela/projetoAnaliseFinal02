package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.entidades.HotelTipoQuarto;

public class Solteiro implements HotelTipoQuarto {
	
	private HotelTipoQuarto quartoDecorado;
	
	
	public Solteiro(HotelTipoQuarto quartoDecorado) {
		this.quartoDecorado=quartoDecorado;
	}
	

	@Override
	public double getPagamento() {

		return quartoDecorado.getPagamento() + 100.00;
	}

}

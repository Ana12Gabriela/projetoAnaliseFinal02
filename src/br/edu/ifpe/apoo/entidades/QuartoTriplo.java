package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.entidades.HotelTipoQuarto;

public class QuartoTriplo implements HotelTipoQuarto{
	private HotelTipoQuarto  quartoDecorado;


	public QuartoTriplo(HotelTipoQuarto  quartoDecorado) {
		this. quartoDecorado= quartoDecorado;
	}

	@Override
	public double getPagamento() {
		// TODO Auto-generated method stub
		return  quartoDecorado.getPagamento() + 200.00;
	}
}

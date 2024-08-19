package br.edu.ifpe.apoo.entidades;

import br.edu.ifpe.apoo.entidades.HotelTipoQuarto;

public class QuartoDuplo implements HotelTipoQuarto{
private HotelTipoQuarto quartoDecorado;
	
	
	public QuartoDuplo(HotelTipoQuarto quartoDecorador) {
		this.quartoDecorado=quartoDecorado;
		
		}
	
	@Override
	public double getPagamento() {
		// TODO Auto-generated method stub
		return quartoDecorado.getPagamento() + 150.00;
	}

}

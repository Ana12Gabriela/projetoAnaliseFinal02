package br.edu.ifpe.apoo.persistencia;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifpe.apoo.entidades.Hospede;

public class HospedeDAOList implements IHospedeDAO{

	private List<Hospede> hospede;
	private static HospedeDAOList instancia;

	public HospedeDAOList() {
		this.hospede = new ArrayList<>();

	}

	protected static HospedeDAOList getInstancia() {
		if(instancia == null) {
			instancia = new HospedeDAOList();
		}
		return instancia;

	}
	
	public List<Hospede> getHospede(){
		return hospede;
	}

	public void setHospede(List<Hospede> hospede) {
		this.hospede = hospede;
	}

	public static void setInstancia(HospedeDAOList instancia) {
		HospedeDAOList.instancia = instancia;
	}

	public void inserir(Hospede hospede) {
		this.hospede.add(hospede);
	}
	
	@Override
	public void editar(Hospede hospede) {
		for (Hospede elementoHospede: this.hospede) {
			if(elementoHospede.getCpf().equals(hospede.getCpf())) {

				elementoHospede.setCpf(hospede.getCpf());
				elementoHospede.setNome(hospede.getNome());
				
				return;

			}
		}
	}
	@Override
	public Hospede remover(String cpf) {
		hospede.removeIf(hospede -> hospede.getCpf() == cpf);
		return null;
		
		
	}

	public Hospede consultar(String cpf){
		for (Hospede hospede : hospede) {
			if(hospede.getCpf() == hospede.getCpf()) {
				return hospede;
			}
		}
		return null;
		
	}

	

	@Override
	public List<Hospede> listarTodos() {
		return hospede;
	}

	
	}








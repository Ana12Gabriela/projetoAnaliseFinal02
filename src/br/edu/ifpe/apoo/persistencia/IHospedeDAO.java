package br.edu.ifpe.apoo.persistencia;

import java.util.List;

import br.edu.ifpe.apoo.entidades.Hospede;


public interface IHospedeDAO {
	void inserir(Hospede hospede);
	void editar(Hospede hospede);
	Hospede remover(String cpf);

	Hospede consultar(String cpf);
	List<Hospede> listarTodos();


}

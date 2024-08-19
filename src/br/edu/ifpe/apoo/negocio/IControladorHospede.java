package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

import java.util.List;

public interface IControladorHospede {
	void inserir(Hospede hospede) throws ExcecaoNegocio;

	void editar(Hospede hospede) throws ExcecaoNegocio;

	void remover(String cpf) throws ExcecaoNegocio;

	List<Hospede> listarTodos() throws ExcecaoNegocio;

	Hospede consultarHospede(String cpf) throws ExcecaoNegocio;
}

package br.edu.ifpe.apoo.negocio;
import br.edu.ifpe.apoo.persistencia.FabricaDAO;

import br.edu.ifpe.apoo.persistencia.GenericDAO;


import java.util.List;

import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

public abstract class ControladorGenerico<T> {

	private GenericDAO<T> dao;
	public ControladorGenerico() {
		this.dao = FabricaDAO.getDAO();
	}

	public T consultar(String cpf) throws ExcecaoNegocio {
		T entidade = dao.consultar(cpf);
		if (entidade == null) {
			throw new ExcecaoNegocio("Entidade não encontrada!");
		}
		return entidade;
	}

	public void remover(String cpf) throws ExcecaoNegocio {
		if (!dao.remover(cpf)) {
			throw new ExcecaoNegocio("Entidade não encontrada!");
		}
	}

	public List<T> consultarTodos() throws ExcecaoNegocio {
		return dao.listar();
	}

	protected GenericDAO<T> getDAO() {
		return dao;
	}
}

package br.edu.ifpe.apoo.persistencia;
import java.util.List;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

public interface IGenericDAO<T> {
	 void inserir(T objeto);
	
	void editar(T objeto)throws ExcecaoNegocio;
	
	boolean remover(String cpf)throws ExcecaoNegocio;
	T consultar(String cpf);
	public List<T> listar();
}

package br.edu.ifpe.apoo.persistencia;
import java.util.ArrayList;
import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
import java.util.List;

public class GenericDAO<T> implements IGenericDAO<T> {
	private List<T> lista;
	private static GenericDAO<?> instancia;

	private GenericDAO() {
		this.lista = new ArrayList<>();
	}

	public static <T> GenericDAO<T> getInstancia() {
		if (instancia == null) {
			instancia = new GenericDAO<>();
		}
		return (GenericDAO<T>) instancia;
	}

	@Override
	public void inserir(T objeto) {
		this.lista.add(objeto);
	}

	@Override
	public void editar(T objeto) throws ExcecaoNegocio {
		int index = lista.indexOf(objeto);
		if (index != -1) {
			lista.set(index, objeto);
		} else {
			throw new ExcecaoNegocio("Objeto não encontrado na lista.");
		}
	}

	@Override
	public boolean remover(String cpf) throws ExcecaoNegocio {
		T Remover = consultar(cpf);
		if (Remover != null) {
			return lista.remove(Remover);
		} else {
			throw new ExcecaoNegocio("Objeto não encontrado na lista.");
		}
	}

	@Override
	public List<T> listar() {
		return new ArrayList<>(this.lista);
	}

	@Override
	public T consultar(String cpf) {
		for (T objeto : lista) {
			if (objeto instanceof Hospede) {
				Hospede hospede = (Hospede) objeto;
				if (hospede.getCpf().equals(cpf)) {
					return objeto;
				}
			}
		}
		return null;
	}
}


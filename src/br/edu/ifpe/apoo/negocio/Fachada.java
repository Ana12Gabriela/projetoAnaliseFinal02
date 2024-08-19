package br.edu.ifpe.apoo.negocio;
import java.util.List;
import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

public class Fachada  {
	private ControladorHospede controladorHospede;
	public Fachada() {
		this.controladorHospede = new ControladorHospede();
	}

	public void cadastrarHospede(Hospede hospede) throws ExcecaoNegocio {
		controladorHospede.inserir(hospede);
	}

	public void editar(Hospede hospede) throws ExcecaoNegocio {
		controladorHospede.editar(hospede);
	}

	public void remover(String cpf) throws ExcecaoNegocio {
		controladorHospede.remover(cpf);
	}

	public Hospede consultar(String cpf) throws ExcecaoNegocio {
		return controladorHospede.consultar(cpf);
	}

	public List<Hospede> listarTodos() throws ExcecaoNegocio {
		return controladorHospede.consultarTodos();
	}
}
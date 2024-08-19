package br.edu.ifpe.apoo.negocio;




import java.util.List;

import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;

public class ControladorHospede extends ControladorGenerico<Hospede> implements IControladorHospede {

	public ControladorHospede() {
		super();
	}

	@Override
	public void inserir(Hospede hospede) throws ExcecaoNegocio {
		if (!isValido(hospede)) {
			throw new ExcecaoNegocio("Hóspede inválido!");
		}
		getDAO().inserir(hospede);
	}

	@Override
	public void editar(Hospede hospede) throws ExcecaoNegocio {
		if (!isValido(hospede)) {
			throw new ExcecaoNegocio("Hóspede inválido!");
		}
		getDAO().editar(hospede);
		
	 }

    @Override
    public void remover(String cpf) throws ExcecaoNegocio {
        if (!getDAO().remover(cpf)) {
            throw new ExcecaoNegocio("Hóspede não encontrado para remoção!");
        }
        
    }

    @Override
    public List<Hospede> listarTodos() throws ExcecaoNegocio {
        return getDAO().listar();
    }

    @Override
    public Hospede consultarHospede(String cpf) throws ExcecaoNegocio {
        Hospede hospede = getDAO().consultar(cpf);
        if (hospede == null) {
            throw new ExcecaoNegocio("Hóspede não encontrado!");
        }
        return hospede;
  
		
	}

	private boolean isValido(Hospede hospede) {
		return true;
	}

}
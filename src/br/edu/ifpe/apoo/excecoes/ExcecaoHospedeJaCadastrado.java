package br.edu.ifpe.apoo.excecoes;

import br.edu.ifpe.apoo.negocio.ExcecaoNegocio;

public class ExcecaoHospedeJaCadastrado extends ExcecaoNegocio{
	

	public ExcecaoHospedeJaCadastrado(String mensagem) {
        super(mensagem);
    }

}

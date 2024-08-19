package br.edu.ifpe.apoo.util;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class ValidaCpf implements AdapterCpf{
	private static final String CPF_PATTERN = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

	public boolean valida(String cpf) {

		if (!cpf.matches(CPF_PATTERN)) {
			System.err.println("Erro: CPF deve estar no formato 000.000.000-00.");
			return false;
		}

		if (cpf.length() != 14) {
			System.err.println("Erro: CPF deve ter 14 caracteres.");
			return false;
		}

		if (!cpf.equals(cpf)) {
			System.err.println("Erro: CPFs não correspondem.");
			return false;
		}

		CPFValidator cpfValidator = new CPFValidator(); 
		try{ cpfValidator.assertValid(cpf); 
		return true; 
		}catch(Exception e){ 
			e.printStackTrace(); 
			return false; 
		} 


}


}
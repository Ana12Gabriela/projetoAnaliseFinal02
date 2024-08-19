package br.edu.ifpe.apoo.persistencia;

import java.util.List;

import  br.edu.ifpe.apoo.entidades.Hospede;

public class FabricaDAO {
	  public static <T> GenericDAO getDAO() {
	        return GenericDAO.getInstancia();
	       

}

	
	}

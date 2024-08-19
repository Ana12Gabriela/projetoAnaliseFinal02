package br.edu.ifpe.apoo.log;

import java.io.FileWriter;
import java.io.IOException;

public class LogHotel {
	private static final String REGISTROS_HOSPEDES = "src/br/edu/ifpe/apoo/log/log.txt";
	public static void registrarHospedes(String descricao) throws IOException{
		FileWriter writer = new FileWriter(REGISTROS_HOSPEDES, true);
		writer.write(descricao);
		writer.close();	
	}

}

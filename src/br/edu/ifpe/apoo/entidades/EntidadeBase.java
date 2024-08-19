package br.edu.ifpe.apoo.entidades;

public class EntidadeBase {
	private static Integer proximoId = 1;
	private Integer id;

	public EntidadeBase() {
		this.id = proximoId++;
	}

	public EntidadeBase(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}



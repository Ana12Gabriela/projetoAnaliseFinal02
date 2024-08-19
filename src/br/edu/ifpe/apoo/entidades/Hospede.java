package br.edu.ifpe.apoo.entidades;

public class Hospede extends EntidadeBase {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String verificacaoReserva;
	private int nuQuartosDisponiveis;

	public Hospede(String cpf2, String novoHospede, String novoNome) {
	}

	public Hospede(String nome2, String cpf2, int nuQuartosDisponiveis2, String endereco2, String telefone2,
			String verificacaoReservas, int nuQuartosDisponiveis3) {

		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.verificacaoReserva = verificacaoReserva;
		this.nuQuartosDisponiveis = nuQuartosDisponiveis;
	}

	public Hospede() {
		// TODO Auto-generated constructor stub
	}

	public Hospede(String cpf2, String novoNome) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getVerificacaoReserva() {
		return verificacaoReserva;
	}

	public void setVerificacaoReserva(String verificacaoReserva) {
		this.verificacaoReserva = verificacaoReserva;
	}

	public int getNuQuartosDisponiveis() {
		return nuQuartosDisponiveis;
	}

	public void setNuQuartosDisponiveis(int nuQuartosDisponiveis) {
		this.nuQuartosDisponiveis = nuQuartosDisponiveis;
	}

	public static class HospedeBuilder {
		private String id;
		private String nome;
		private String cpf;
		private String endereco;
		private String telefone;
		private int nuQuartosDisponiveis;
		private String verificacaoReservas;

		public HospedeBuilder id(String id) {
			this.id = id;
			return this;
		}

		public HospedeBuilder nome(String nome) {
			this.nome = nome;

			return this;

		}

		public HospedeBuilder cpf(String cpf) {
			this.cpf = cpf;

			return this;

		}

		public HospedeBuilder endereco(String endereco) {
			this.endereco = endereco;

			return this;
		}

		public HospedeBuilder telefone(String telfone) {
			this.telefone = telefone;

			return this;
		}

		public HospedeBuilder verificacao(String verificacaoReserva) {
			this.verificacaoReservas = verificacaoReserva;

			return this;

		}

		public HospedeBuilder nuQuartosDisponiveis(int nuQuartosDisponiveis) {
			this.nuQuartosDisponiveis = nuQuartosDisponiveis;

			return this;

		}

		public Hospede criar() {
			return new Hospede(this.nome, this.cpf, nuQuartosDisponiveis, this.endereco, this.telefone,
					this.verificacaoReservas, this.nuQuartosDisponiveis);

		}

	}
}

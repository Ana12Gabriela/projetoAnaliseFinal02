package br.edu.ifpe.apoo.apresentacao;

import java.io.IOException;
import java.util.List;

import java.util.Scanner;

import br.edu.ifpe.apoo.entidades.Diaria;
import br.edu.ifpe.apoo.entidades.Hospede;
import br.edu.ifpe.apoo.entidades.QuartoDuplo;
import br.edu.ifpe.apoo.entidades.QuartoTriplo;
import br.edu.ifpe.apoo.entidades.Solteiro;
import br.edu.ifpe.apoo.excecoes.ExcecaoNegocio;
import br.edu.ifpe.apoo.log.LogHotel;
import br.edu.ifpe.apoo.negocio.Fachada;
import br.edu.ifpe.apoo.util.AdapterCpf;
import br.edu.ifpe.apoo.util.ValidaCpf;
import br.edu.ifpe.apoo.entidades.HotelTipoQuarto;

public class TelaHospede {

    private final Scanner scanner = new Scanner(System.in);
    private AdapterCpf validaCpf;
    private Fachada fachada;

    public TelaHospede() {
        this.validaCpf = new ValidaCpf();
        this.fachada = new Fachada();
    }

    public void exibir() throws IOException {
        int opcao = 0;
        do {
            System.out.println("Bem-vindo(a)!");
            System.out.println("Digite 1 para cadastrar um hóspede;");
            System.out.println("Digite 2 para editar os dados do hóspede;");
            System.out.println("Digite 3 para remover o hóspede;");
            System.out.println("Digite 4 para consultar um hóspede;");
            System.out.println("Digite 5 para consultar todos os hóspedes;");
            System.out.println("Digite 6 para sair");
            System.out.println("-------------------------------------------");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido!");
                continue;
            }

            switch (opcao) {
                case 1:
                    this.inserir();
                    break;
                case 2:
                    this.editar();
                    break;
                case 3:
                    this.remover();
                    break;
                case 4:
                    this.consultar();
                    break;
                case 5:
                    this.consultarTodos();
                    break;
                case 6:
                    System.out.println("Volte sempre");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número entre 1 e 6.");
                    break;
            }
        } while (opcao != 6);
    }

    private void inserir() throws IOException {
        System.out.println("Cadastro de Hóspedes");

        while (true) {
            String cpf = lerString("CPF do hóspede");

            if (!validaCpf.valida(cpf)) {
                System.out.println("CPF inválido! Verifique o número e tente novamente.");
                continue;
            }

            try {
                if (fachada.consultar(cpf) != null) {
                    System.out.println("CPF já cadastrado! Verifique o número e tente novamente.");
                    continue;
                }

                String nome = lerString("Nome");
                Hospede hospede = new Hospede.HospedeBuilder()
                		.cpf(cpf)
                		.nome(nome)
                		.criar();
                
                int tipoQuarto = lerInteiro("tipo de quarto (1-Simples, 2-Duplo, 3-Triplo)");

                HotelTipoQuarto hotelTipoQuarto = new Diaria();
                
                switch (tipoQuarto) {
                    case 1:
                        hotelTipoQuarto = new Solteiro(hotelTipoQuarto);
                        break;
                    case 2:
                    	hotelTipoQuarto = new QuartoDuplo(hotelTipoQuarto);
                        break;
                    case 3:
                    	hotelTipoQuarto = new QuartoTriplo(hotelTipoQuarto);
                        break;
                    default:
                        System.out.println("Tipo de quarto inválido. Tente novamente.");
                        continue;
                }

                fachada.cadastrarHospede(hospede);
                System.out.println("Hóspede cadastrado com sucesso!");
                LogHotel.registrarHospedes("Hóspede cadastrado com sucesso!");

                // Exibe a ficha com todas as informações
                System.out.println("\n--- Ficha do Hóspede ---");
                System.out.println("Nome: " + hospede.getNome());
                System.out.println("CPF: " + hospede.getCpf());
                System.out.println("--------------------------");

            } catch (ExcecaoNegocio excecao) {
                System.out.println("Erro ao cadastrar hóspede: " + excecao.getMessage());
            }

            System.out.println("Deseja cadastrar outro hóspede? [s/n]");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("n")) {
                break;
            }
        }
    }

    private void editar() {
        System.out.println("Editar Hóspede");

        String cpf = lerString("CPF do hóspede");

        try {
            Hospede hospedeExistente = fachada.consultar(cpf);

            if (hospedeExistente == null) {
                System.out.println("Hóspede não encontrado com o CPF: " + cpf);
                return;
            }

            String novoNome = lerString("novo nome");
            String novoCpf = lerString("novo CPF");

            Hospede hospedeAtualizado = new Hospede(novoNome, novoCpf);
            fachada.editar(hospedeAtualizado);
            System.out.println("Hóspede editado com sucesso!");

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao editar hóspede: " + e.getMessage());
        }
    }

    private void remover() {
        System.out.println("Remover Hóspede");

        String cpf = lerString("CPF do hóspede");

        try {
            fachada.remover(cpf);
            System.out.println("Hóspede removido com sucesso!");

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao remover hóspede: " + e.getMessage());
        }
    }

    private void consultar() {
        System.out.println("Consulta de Hóspede");

        String cpf = lerString("CPF do hóspede");

        try {
            Hospede hospede = fachada.consultar(cpf);

            if (hospede != null) {
                System.out.println("Hóspede encontrado:");
                System.out.println("Nome: " + hospede.getNome());
                System.out.println("CPF: " + hospede.getCpf());
            } else {
                System.out.println("Hóspede não encontrado.");
            }

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao consultar hóspede: " + e.getMessage());
        }
    }

    private void consultarTodos() {
        System.out.println("Lista de Todos os Hóspedes");

        try {
            List<Hospede> hospedes = fachada.listarTodos();

            if (!hospedes.isEmpty()) {
                System.out.println("Lista de hóspedes:");
                for (Hospede h : hospedes) {
                    System.out.println("---------------------------------------------");
                    System.out.println("Nome: " + h.getNome());
                    System.out.println("CPF: " + h.getCpf());
                }
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("Não há hóspedes cadastrados.");
            }

        } catch (ExcecaoNegocio e) {
            System.out.println("Erro ao consultar hóspedes: " + e.getMessage());
        }
    }

    private int lerInteiro(String mensagem) {
        int entrada = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println("Digite o " + mensagem + ": ");
            String input = scanner.nextLine();

            try {
                entrada = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException ex) {
                System.out.println("Digite apenas números inteiros!");
            }
        }
        return entrada;
    }

    private String lerString(String nomeAtributo) {
        String entrada = "";

        while (entrada.trim().isEmpty()) {
            System.out.println("Digite o " + nomeAtributo + ": ");
            entrada = scanner.nextLine();
        }
        return entrada;
    }
}
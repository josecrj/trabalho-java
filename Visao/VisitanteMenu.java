package Visao;

import java.util.Scanner;
import java.util.InputMismatchException;

import Dominio.Visitante;
import Servico.ServicoVISITANTE;

public class VisitanteMenu {

    private Scanner scanner = new Scanner(System.in);

    // O Menu possui um Serviço de Visitante
    private ServicoVISITANTE servicoVisitante = new ServicoVISITANTE();


    public void exibirMenu() {

        int opcao = -1;

        do {

            System.out.println("\n=== MENU VISITANTE ===");
            System.out.println("1 - Cadastrar Visitante");
            System.out.println("2 - Listar Visitantes");
            System.out.println("3 - Atualizar Visitante");
            System.out.println("4 - Buscar Visitante por Código");
            System.out.println("5 - Excluir Visitante");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");

            // Verifica se o usuário digitou um número
            if (!scanner.hasNextInt()) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        listarTodos();
                        break;

                    case 3:
                        atualizar();
                        break;

                    case 4:
                        buscarPorCodigo();
                        break;

                    case 5:
                        excluir();
                        break;

                    case 0:
                        System.out.println("Saindo do menu...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (InputMismatchException erro) {

                System.out.println("Digite apenas números inteiros dentro do intervalo permitido.");
                scanner.nextLine();

            } catch (IllegalArgumentException erro) {

                System.out.println("Erro: " + erro.getMessage());

            } catch (IllegalStateException erro) {

                System.out.println("Erro: " + erro.getMessage());
            }

        } while (opcao != 0);
    }


    // =========================
    // CADASTRAR
    // =========================

    private void cadastrar() {

        System.out.println("\n=== CADASTRAR VISITANTE ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Motivo da visita: ");
        String motivoVisita = scanner.nextLine();

        System.out.print("Número do crachá: ");
        int crachaNumero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Setor da visita: ");
        String setorVisita = scanner.nextLine();


        Visitante novo = new Visitante();

        novo.setCodigo(0);
        novo.setNome(nome);
        novo.setCpf(cpf);
        novo.setEmail(email);
        novo.setTelefone(telefone);
        novo.setEndereco(endereco);
        novo.setMotivoVisita(motivoVisita);
        novo.setCrachaNumero(crachaNumero);
        novo.setSetorVisita(setorVisita);


        Visitante criado = servicoVisitante.create(novo);

        System.out.println("\nVisitante cadastrado com sucesso!");

        criado.exibir();
    }


    // =========================
    // LISTAR TODOS
    // =========================

    private void listarTodos() {

        System.out.println("\n=== LISTA DE VISITANTES ===");

        for (Visitante visitante : servicoVisitante.readAll()) {

            visitante.exibir();
        }
    }


    // =========================
    // BUSCAR
    // =========================

    private void buscarPorCodigo() {

        System.out.print("Digite o código: ");

        int codigo = scanner.nextInt();
        scanner.nextLine();


        Visitante visitante =
            servicoVisitante.readOne(codigo);


        visitante.exibir();
    }


    // =========================
    // ATUALIZAR
    // =========================

    private void atualizar() {

        System.out.print("Código do visitante: ");

        int codigo = scanner.nextInt();
        scanner.nextLine();


        Visitante visitante =
            servicoVisitante.readOne(codigo);


        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        Visitante alterado = new Visitante(
            visitante.getCodigo(), nome, visitante.getCpf(),
            visitante.getEmail(), visitante.getTelefone(), visitante.getEndereco(),
            visitante.getMotivoVisita(), visitante.getCrachaNumero(),
            visitante.getSetorVisita());


        servicoVisitante.update(alterado);


        System.out.println("Visitante atualizado!");

        alterado.exibir();
    }


    // =========================
    // EXCLUIR
    // =========================

    private void excluir() {

        System.out.print("Código do visitante: ");

        int codigo = scanner.nextInt();
        scanner.nextLine();


        Visitante visitante =
            servicoVisitante.readOne(codigo);


        visitante.exibir();


        System.out.print("Deseja realmente excluir? (S/N): ");

        String resposta = scanner.nextLine();


        if (resposta.equalsIgnoreCase("S")) {

            servicoVisitante.deletePorId(codigo);

            System.out.println("Visitante excluído.");

        } else {

            System.out.println("Exclusão cancelada.");
        }
    }
}

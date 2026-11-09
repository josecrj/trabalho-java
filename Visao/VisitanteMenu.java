package Visao;

import java.util.Scanner;
import java.util.ArrayList;

import Dominio.Visitante;
import Servico.ServicoVISITANTE;

public class VisitanteMenu {

    private Scanner scanner = new Scanner(System.in);

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

            if (!scanner.hasNextInt()) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

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

        } while (opcao != 0);
    }



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
        if (!scanner.hasNextInt()) {
            System.out.println("Número do crachá inválido.");
            scanner.nextLine();
            return;
        }
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

        if (criado == null) {
            System.out.println("Dados inválidos. Visitante não cadastrado.");
            return;
        }

        System.out.println("\nVisitante cadastrado com sucesso!");

        criado.exibir();
    }


   

    private void listarTodos() {

        System.out.println("\n=== LISTA DE VISITANTES ===");

        ArrayList<Visitante> visitantes = servicoVisitante.readAll();

        if (visitantes == null || visitantes.isEmpty()) {
            System.out.println("Nenhum visitante cadastrado.");
            return;
        }

        for (Visitante visitante : visitantes) {

            visitante.exibir();
        }
    }


  

    private void buscarPorCodigo() {

        System.out.print("Digite o código: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Código inválido.");
            scanner.nextLine();
            return;
        }
        int codigo = scanner.nextInt();
        scanner.nextLine();


        Visitante visitante =
            servicoVisitante.readOne(codigo);

        if (visitante == null) {
            System.out.println("Visitante não encontrado.");
            return;
        }

        visitante.exibir();
    }


   

    private void atualizar() {

        System.out.print("Código do visitante: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Código inválido.");
            scanner.nextLine();
            return;
        }
        int codigo = scanner.nextInt();
        scanner.nextLine();


        Visitante visitante =
            servicoVisitante.readOne(codigo);

        if (visitante == null) {
            System.out.println("Visitante não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Novo endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Novo motivo da visita: ");
        String motivoVisita = scanner.nextLine();

        System.out.print("Novo número do crachá: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Número do crachá inválido.");
            scanner.nextLine();
            return;
        }
        int crachaNumero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo setor da visita: ");
        String setorVisita = scanner.nextLine();

        Visitante alterado = new Visitante(
            visitante.getCodigo(), nome, cpf,
            email, telefone, endereco,
            motivoVisita, crachaNumero, setorVisita);


        Visitante resultado = servicoVisitante.update(alterado);

        if (resultado == null) {
            System.out.println("Dados inválidos. Visitante não atualizado.");
            return;
        }

        System.out.println("Visitante atualizado com sucesso!");

        resultado.exibir();
    }



    private void excluir() {

        System.out.print("Código do visitante: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Código inválido.");
            scanner.nextLine();
            return;
        }
        int codigo = scanner.nextInt();
        scanner.nextLine();


        Visitante visitante =
            servicoVisitante.readOne(codigo);

        if (visitante == null) {
            System.out.println("Visitante não encontrado.");
            return;
        }

        visitante.exibir();


        System.out.print("Deseja realmente excluir? (S/N): ");

        String resposta = scanner.nextLine();


        if (resposta.equalsIgnoreCase("S")) {

            Visitante excluido = servicoVisitante.deletePorId(codigo);

            if (excluido != null) {
                System.out.println("Visitante excluído com sucesso.");
            }

        } else {

            System.out.println("Exclusão cancelada.");
        }
    }
}

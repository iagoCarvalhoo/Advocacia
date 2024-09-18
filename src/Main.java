// Criar um programa na linguagem java utilizando-se dos temas
// polimorfismo e scanner para apoio a um escritório de advocacia,
// sendo que, deve conter nas linhas de código áreas de atuação,
// advogados por área, clientes, podendo ser uma pessoa física
// ou uma pessoa jurídica, honorários advocatícios, processos,
// tribunais vinculados aos processos.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        // Declaração das variáveis
        Scanner scanner = new Scanner(System.in);
        List<AreaAtuacao> areasAtuacao = new ArrayList<>();
        List<Advogado> advogados = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Processo> processos = new ArrayList<>();

        // Cadastro inicial de Áreas de atuação
        areasAtuacao.add(new AreaAtuacao("Direito Civil"));
        areasAtuacao.add(new AreaAtuacao("Direito Penal"));
        areasAtuacao.add(new AreaAtuacao("Direito Trabalhista"));
        areasAtuacao.add(new AreaAtuacao("Direito Tributário"));
        areasAtuacao.add(new AreaAtuacao("Direito Empresarial"));
        areasAtuacao.add(new AreaAtuacao("Direito Imobiliário"));

        // Cadastro inicial de advogados
        advogados.add(new Advogado("Mirela da Silva", "024.168.985-98", areasAtuacao.get(0))); // Direito Civil
        advogados.add(new Advogado("Geovana Pereira", "056.648.879-56", areasAtuacao.get(1))); // Direito Penal
        advogados.add(new Advogado("Pedro Santos", "156.598.321-02", areasAtuacao.get(2))); // Direito Trabalhista
        advogados.add(new Advogado("Ana Oliveira", "465.852.325-00", areasAtuacao.get(3))); // Direito Tributário
        advogados.add(new Advogado("Augusto Rodrigues", "236.115.956-96", areasAtuacao.get(4))); // Direito Empresarial
        advogados.add(new Advogado("Laura Almeida", "365.145.753-33", areasAtuacao.get(5))); // Direito Imobiliário

        // Cadastro inicial de clientes
        clientes.add(new PessoaFisica("Carlos Santos", "321.456.789-00"));
        clientes.add(new PessoaFisica("Fernanda Silva", "147.285.369-11"));
        clientes.add(new PessoaJuridica("Carvalhos LTDA", "12.489.156/0001-10"));
        clientes.add(new PessoaJuridica("Empresa Y LTDA", "98.765.432/0003-20"));
        clientes.add(new PessoaFisica("Ricardo Costa", "234.678.323-64"));
        clientes.add(new PessoaJuridica("Empresa Z LTDA", "55.357.159/0004-30"));

        // Cadastro inicial de processos
        processos.add(new Processo("12345678901234", "Tribunal de Justiça", advogados.get(0), clientes.get(0), 5000.00));
        processos.add(new Processo("98765432101234", "Tribunal Regional Federal", advogados.get(1), clientes.get(1), 3000.00));
        processos.add(new Processo("11122233301234", "Tribunal Superior do Trabalho", advogados.get(2), clientes.get(2), 7000.00));
        processos.add(new Processo("44455566601234", "Superior Tribunal de Justiça", advogados.get(3), clientes.get(3), 2000.00));
        processos.add(new Processo("77788899901234", "Tribunal de Contas da União", advogados.get(4), clientes.get(4), 10000.00));
        processos.add(new Processo("22211100001234", "Tribunal de Justiça do Trabalho", advogados.get(5), clientes.get(5), 4000.00));

        // Menu principal
        while (true) {
            System.out.println("\n==== Sistema de Advocacia ====");
            System.out.println("1. Cadastrar Área de Atuação");
            System.out.println("2. Cadastrar Advogado");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Cadastrar Processo");
            System.out.println("5. Listar Áreas de Atuação");
            System.out.println("6. Listar Advogados");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Listar Processos");
            System.out.println("9. Sair");
            System.out.println("=============================");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();

            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarAreaAtuacao(areasAtuacao, scanner);
                    break;
                case 2:
                    cadastrarAdvogado(advogados, areasAtuacao, scanner);
                    break;
                case 3:
                    cadastrarCliente(clientes, scanner);
                    break;
                case 4:
                    cadastrarProcesso(processos, advogados, clientes, scanner);
                    break;
                case 5:
                    listarAreasAtuacao(areasAtuacao);
                    break;
                case 6:
                    listarAdvogados(advogados);
                    break;
                case 7:
                    listarClientes(clientes);
                    break;
                case 8:
                    listarProcessos(processos);
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Métodos para cadastrar os dados

    // Cadastrar Área de Atuação
    private static void cadastrarAreaAtuacao(List<AreaAtuacao> areasAtuacao, Scanner scanner) {
        System.out.print("Digite o nome da área de atuação: ");
        String nomeArea = scanner.nextLine();
        areasAtuacao.add(new AreaAtuacao(nomeArea));
        System.out.println("Área de atuação cadastrada com sucesso!");
    }

    // Cadastrar Advogado
    private static void cadastrarAdvogado(List<Advogado> advogados, List<AreaAtuacao> areasAtuacao, Scanner scanner) {
        System.out.print("Digite o nome do advogado: ");
        String nomeAdvogado = scanner.nextLine();
        System.out.print("Digite o CPF do advogado: ");
        String cpfAdvogado = scanner.nextLine();
        System.out.println("Selecione a área de atuação:");
        for (int i = 0; i < areasAtuacao.size(); i++) {
            System.out.println((i + 1) + ". " + areasAtuacao.get(i).getNome());
        }
        int opcaoArea = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        AreaAtuacao area = areasAtuacao.get(opcaoArea - 1);
        advogados.add(new Advogado(nomeAdvogado, cpfAdvogado, area));
        System.out.println("Advogado cadastrado com sucesso!");
    }

    // Cadastrar Cliente
    private static void cadastrarCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.print("Digite o tipo de cliente (F - Pessoa Física, J - Pessoa Jurídica): ");
        char tipoCliente = scanner.nextLine().toUpperCase().charAt(0);
        if (tipoCliente == 'F') {
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Digite o CPF do cliente: ");
            String cpfCliente = scanner.nextLine();
            clientes.add(new PessoaFisica(nomeCliente, cpfCliente));
        } else if (tipoCliente == 'J') {
            System.out.print("Digite o nome da empresa: ");
            String nomeEmpresa = scanner.nextLine();
            System.out.print("Digite o CNPJ da empresa: ");
            String cnpjEmpresa = scanner.nextLine();
            clientes.add(new PessoaJuridica(nomeEmpresa, cnpjEmpresa));
        } else {
            System.out.println("Tipo de cliente inválido!");
        }
    }

    // Cadastrar Processo
    private static void cadastrarProcesso(List<Processo> processos, List<Advogado> advogados, List<Cliente> clientes, Scanner scanner) {
        System.out.print("Digite o número do processo: ");
        String numeroProcesso = scanner.nextLine();
        System.out.print("Digite o nome do tribunal: ");
        String nomeTribunal = scanner.nextLine();
        System.out.println("Selecione o advogado:");
        for (int i = 0; i < advogados.size(); i++) {
            System.out.println((i + 1) + ". " + advogados.get(i).getNome());
        }
        int opcaoAdvogado = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        Advogado advogado = advogados.get(opcaoAdvogado - 1);
        System.out.println("Selecione o cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        int opcaoCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        Cliente cliente = clientes.get(opcaoCliente - 1);
        System.out.print("Digite o valor dos honorários: ");
        double honorarios = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        processos.add(new Processo(numeroProcesso, nomeTribunal, advogado, cliente, honorarios));
        System.out.println("Processo cadastrado com sucesso!");
    }

    // Listar Áreas de Atuação
    private static void listarAreasAtuacao(List<AreaAtuacao> areasAtuacao) {
        if (areasAtuacao.isEmpty()) {
            System.out.println("Nenhuma área de atuação cadastrada. :(");
        } else {
            System.out.println("\n======= Áreas de Atuação =======");
            for (AreaAtuacao area : areasAtuacao) {
                System.out.println(area.getNome());
            }
            System.out.println("================================");
        }
    }

    // Listar Advogados
    private static void listarAdvogados(List<Advogado> advogados) {
        if (advogados.isEmpty()) {
            System.out.println("Nenhum advogado cadastrado. :(");
        } else {
            System.out.println("\n========== Advogados ==========");
            for (Advogado advogado : advogados) {
                System.out.println("Nome: " + advogado.getNome());
                System.out.println("CPF: " + advogado.getCpf());
                System.out.println("Área de Atuação: " + advogado.getAreaAtuacao().getNome());
                System.out.println("==============================");
            }
        }
    }

    // Listar Clientes
    private static void listarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. :(");
        } else {
            System.out.println("\n================= Clientes =================");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
                System.out.println("============================================");
            }
        }
    }

    // Listar Processos
    private static void listarProcessos(List<Processo> processos) {
        if (processos.isEmpty()) {
            System.out.println("Nenhum processo cadastrado. :(");
        } else {
            System.out.println("\n=========== Processos ===========");
            for (Processo processo : processos) {
                System.out.println("Número do Processo: " + processo.getNumeroProcesso());
                System.out.println("Tribunal: " + processo.getNomeTribunal());
                System.out.println("Advogado: " + processo.getAdvogado().getNome());
                System.out.println("Cliente: " + processo.getCliente().getNome());
                System.out.println("Honorários: R$" + processo.getHonorarios());
                System.out.println("==================================");
            }
        }
    }
}
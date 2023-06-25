import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Discentes: Alexandrino Rodrigues dos Santos, Bruno de Oliveira Silva e Tiago Ribas Guedes
 * Disciplina: POO (Programação Orientada a Objetos)
 * Universidade do Estado de Matro Grosso (UNEMAT)
 */


public class Main {
    // Inicialização da imobiliária e da lista de consultores.
    static Imobiliaria imobiliaria = new Imobiliaria();
    private static List<Consultor> consultores = new ArrayList<>();


    // Método de cadastro de consultores
    public static void cadastra_consultor() throws IOException {

        // Criação de um objeto BufferedReader para leitura de dados do teclado.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Leitura dos dados do consultor.
        System.out.print("Digite o nome do consultor: ");
        String nome = reader.readLine();
        System.out.print("Digite o salário do consultor: ");
        double salario = Double.parseDouble(reader.readLine());

        // Criação do objeto consultor e adição do mesmo na lista de consultores.
        Consultor consultor = new Consultor(nome, salario);
        consultores.add(consultor);

        System.out.println("Consultor cadastrado com sucesso!");
    }

    // Método de cadastro de contratos
    public static void cadastra_contrato() throws IOException {

        // Criação de um objeto BufferedReader para leitura de dados do teclado.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Leitura dos dados do cliente:
        System.out.println("Cliente:");
        System.out.println("\t1 - Pessoa Física \n\t2 - Pessoa Jurídica");

        // Leitura do tipo de cliente.
        System.out.print("\nSelecione a opção: ");
        int tipo_cliente = Integer.parseInt(reader.readLine());

        // Leitura do nome do cliente.
        System.out.print("\nDigite o nome do locatário: ");
        String nome = reader.readLine();
        
        
        // Criação do objeto cliente.
        Cliente cliente;

        // Verificação do tipo de cliente.
        if (tipo_cliente == 1) {
            // Criação do objeto cliente Pessoa Física.
            cliente = new PessoaFisica(nome);
        } else if (tipo_cliente == 2) {
            // Criação do objeto cliente Pessoa Jurídica.
            cliente = new PessoaJuridica(nome);
        } else {
            // Tipo de cliente inválido.
            System.out.println("Tipo inválido!");
            return;
        }

        // Leitura do tipo de imóvel.
        System.out.println("\nImóvel:");
        System.out.println("\t1 - Casa \n\t2 - Apartamento \n\t3 - Galpão");
        
        // Leitura do tipo de imóvel.
        System.out.print("\nSelecione a opção: ");
        int tipo_imovel = Integer.parseInt(reader.readLine());

        // Criação do objeto imóvel.
        Imovel imovel;

        // Leitura do valor do aluguel.
        System.out.print("Digite o valor do aluguel: ");
        double valor = Double.parseDouble(reader.readLine());

        // Verificação do tipo de imóvel.
        if (tipo_imovel == 1) {
            // Criação do objeto imóvel Casa.
            imovel = new Casa(valor, nome);
        } else if (tipo_imovel == 2) {
            // Criação do objeto imóvel Apartamento.
            imovel = new Apartamento(valor, nome);
        } else if (tipo_imovel == 3) {
            // Criação do objeto imóvel Galpão.
            imovel = new Galpao(valor, nome);
        } else {
            // Tipo de imóvel inválido.
            System.out.println("Tipo inválido!");
            return;
        }

        // Listagem dos consultores cadastrados.
        System.out.println("\nConsultores: ");
        for (int i = 0; i < consultores.size(); i++) {
            System.out.println((i + 1) + " - " + consultores.get(i).getNome());
        }

        // Leitura do consultor.
        System.out.print("\nSelecione o consultor: ");
        int index_consultor = Integer.parseInt(reader.readLine()) - 1;

        // Verifica se a opção é válida.
        if (index_consultor < 0 || index_consultor > consultores.size() - 1) {
            System.out.println("Consultor inválido!");
            return;
        }

        // Criação do objeto consultor.
        Consultor consultor = consultores.get(index_consultor);

        // Criação do objeto contrato.
        ContratoAluguel contrato = new ContratoAluguel(imovel, cliente, consultor);

        // Adição do contrato na imobiliária.
        imobiliaria.adicionarContrato(contrato);
    }

    // Método de listagem de consultores.
    public static void listar_consultores() {
        // Verifica a lista está vazia.
        if (consultores.isEmpty()) {
            // Informa que não há consultores cadastrados.
            System.out.println("Não há consultores cadastrados!");
            return;
        }

        // Itera sobre a lista de consultores e imprime o nome e seu salário.
        for (int i = 0; i < consultores.size(); i++) {
            System.out.println((i + 1) + " - " + consultores.get(i).getNome() + " - Salário (R$): " + consultores.get(i).getSalario());
        }
    }


    // Método de listagem de contratos.
    public static void listar_contratos() {

        // Verifica se a lista de contratos está vazia.
        if (imobiliaria.getContratos().isEmpty()) {
            // Informa que não há contratos cadastrados.
            System.out.println("Não há contratos cadastrados!");
            return;
        }

        // Itera sobre a lista de contratos e imprime o nome do proprietário do imóvel.
        for (int i = 0; i < imobiliaria.getContratos().size(); i++) {
            // Imprime o nome do proprietário do imóvel.
            System.out.println((i + 1) + " - " + imobiliaria.getContratos().get(i).getImovel().getProprietario());
        }
    }

    
    public static void main(String[] args) {
        // Inicializa o BufferedReader para leitura de dados do teclado.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Variável para armazenar a opção do menu.
        int numeroOpcao;

        // Loop infinito para o menu.
        while (true) {
            // Imprime o menu.
            System.out.println("\nMenu de opções: \n\t1 - Cadastrar consultores, \n\t2 - Listar consultores, " +
                    "\n\t3 - Cadastrar contrato, \n\t4 - Listar contratos, \n\t5 - Relatório mensal, \n\t0 - Sair\n");

            // Leitura da opção do menu.
            try {
                // Leitura da opção do menu.
                System.out.print("Selecione a opção: ");
                numeroOpcao = Integer.parseInt(reader.readLine());

                switch (numeroOpcao) {
                    case 1:
                        // Cadastra um novo consultor.
                        System.out.println("\nCadastro de consultor: \n");
                        cadastra_consultor();
                        break;

                    case 2:
                        // Lista os consultores cadastrados.
                        System.out.println("\nConsultores: \n");
                        listar_consultores();
                        break;

                    case 3:
                        // Cadastra um novo contrato.
                        System.out.println("\nCadastro de contrato: \n");
                        cadastra_contrato();
                        break;

                    case 4:
                        // Lista os contratos cadastrados.
                        System.out.println("\nContratos\n");
                        listar_contratos();
                        break;

                    case 5:
                        // Gera o relatório mensal.
                        System.out.println("\nRelatório mensal \n");
                        imobiliaria.gerarRelatorioMensal();
                        break;

                    case 0:
                        // Encerra o programa.
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;

                    default:
                        // Opção inválida.
                        System.out.println("Opção inválida!");
                }
            // Tratamento de exceções.
            } catch (IOException | NumberFormatException e) {
                System.out.println("Erro ao ler a entrada do usuário: " + e.getMessage());
            }
        }
    }
}

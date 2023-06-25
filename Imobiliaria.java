import java.util.ArrayList;
import java.util.List;

// Classe imobiliária
public class Imobiliaria {
    private String nome;
    private List<ContratoAluguel> contratos;

    // Construtor
    public Imobiliaria() {
        this.nome = "Maria Bell";
        this.contratos = new ArrayList<>();
    }

    // Retorna o nome da imobiliária
    public String getNome() {
        return nome;
    }
    
    // Lista todos os contratos da imobiliária
    public List<ContratoAluguel> getContratos() {
        return this.contratos;
    }

    // Método para adicionar contrato a imobiliária
    public void adicionarContrato(ContratoAluguel contrato) {
        contratos.add(contrato);
    }


    // Método para calcular o total das comissões com base no contrato.

    public double calcularTotalComissoes() {
        double totalComissoes = 0.0;
        for (ContratoAluguel contrato : contratos) {
            totalComissoes += contrato.calcularValorComissao();
        }
        return totalComissoes;
    }


    // Método para gerar relatório mensal
    public void gerarRelatorioMensal() {

        // Relatório geral
        System.out.println("==== Relatório Financeiro Mensal ====");
        System.out.println("Imobiliária: " + this.nome);
        System.out.println("Total de contratos: " + contratos.size());
        System.out.println("Total de comissões paga para imobiliaria (R$): " + calcularTotalComissoes());
        
        // Inicializa as listas para armazenar os dados
        List<String> proprietarios = new ArrayList<>();
        List<Double> comissoesProprietarios = new ArrayList<>();
        List<Consultor> consultores = new ArrayList<>();
        List<Imovel> imoveis = new ArrayList<>();


        // Itera sobre os contratos para gerar os dados do relatórios
        for (ContratoAluguel contrato : contratos) {
            String proprietario = contrato.getImovel().getProprietario();
            double valorComissao = contrato.calcularValorComissao();
            Consultor consultor = contrato.getConsultor();
            Imovel imovel = contrato.getImovel();

            // Adiciona o imóvel a lista caso não exista
            if (!imoveis.contains(imovel)) {
                imoveis.add(imovel);
            }

            // Adiciona consultores a lista caso não exista 
            if (!consultores.contains(consultor)) {
                consultores.add(consultor);
            }
             
            // Verifica se o proprietário já existe na lista
            int index = proprietarios.indexOf(proprietario);
            if (index >= 0) {
                // Se existir, atualiza o valor da comissão
                double comissaoAtual = comissoesProprietarios.get(index);
                comissoesProprietarios.set(index, comissaoAtual + valorComissao);
            } else {
                // Se não existir, adiciona o proprietário e o valor da comissão
                proprietarios.add(proprietario);
                comissoesProprietarios.add(valorComissao);
            }
        }

        System.out.println("-------------------------------------");

        // Relatório detalhado de consultores
        System.out.println("Relatório de Consultores:");

        // Itera sobre a lista de consultores para gerar o relatório
        for (int i = 0; i < consultores.size(); i++) {
            // Imprime o nome do consultor e o valor da comissão recebida
            System.out.println(
                    "Consultor: " + consultores.get(i).getNome() + ", Comissão Recebida (R$): " + consultores.get(i).valorBonusContrato());
        }

        System.out.println("-------------------------------------");

        // Relatório detalhado de imóveis
        System.out.println("Relatório de Imóveis:");

        // Itera sobre a lista de imóveis para gerar o relatório
        for (int i = 0; i < imoveis.size(); i++) {
            // Imprime o nome do proprietário, o tipo do imóvel, o valor do aluguel e a taxa da imobiliária
            System.out.println(
                (i + 1) + " - " + "Proprietário: " + imoveis.get(i).getProprietario() +
                "\n\tTipo do imóvel: " + imoveis.get(i).getClass().getName() +
                "\n\tValor do imóvel (R$): " + imoveis.get(i).getValorAluguel() +
                 "\n\tTaxa imobiliária: R$" + imoveis.get(i).calcularComissao()); 
        }


        System.out.println("-------------------------------------");
        // Relatório detalhado de proprietários
        System.out.println("Relatório por proprietário:");

        // Itera sobre a lista de proprietários para gerar o relatório
        for (int i = 0; i < proprietarios.size(); i++) {
            // Imprime o nome do proprietário e o valor da comissão recebida
            System.out.println(
               "Proprietário: " + proprietarios.get(i) + 
                "\n\tTotal comisão paga para imobiliária (R$): " + comissoesProprietarios.get(i)
            );

        }
    }
}

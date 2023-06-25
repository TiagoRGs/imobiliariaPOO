
// Classe abstrata de imóvel, que possui um valor de aluguel e um proprietário.
public abstract class Imovel {

    // Propriedades da classe Imóvel
    private double valorAluguel;
    private String proprietario;

    // Construtor da classe Imóvel
    public Imovel(double valorAluguel, String proprietario) {
        this.valorAluguel = valorAluguel;
        this.proprietario = proprietario;
    }

    // Método abstrato para calcular a comissão do imóvel
    public abstract double calcularComissao();

    // getter para mostrar o valor do aluguel
    public double getValorAluguel() {
        return valorAluguel;
    }

    // getter para motrar o proprietário
    public String getProprietario() {
        return proprietario;
    }
}

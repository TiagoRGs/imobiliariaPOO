
// Classe que representa um imóvel do tipo casa
public class Casa extends Imovel {

    // Constante para determinar a porcentagem de comissão da Casa
    private static final double PORCENTAGEM_COMISSAO = 0.10;

    // Construtor
    public Casa(double valorAluguel, String proprietario) {
        super(valorAluguel, proprietario);
    }

    // Implementação do calcularComissao() da classe Imovel
    @Override
    public double calcularComissao() {
        return getValorAluguel() * PORCENTAGEM_COMISSAO;
    }
}

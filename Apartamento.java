public class Apartamento extends Imovel {

    // Constante que define a porcentagem da comissão para apartamentos
    private static final double PORCENTAGEM_COMISSAO = 0.15;

    // Construtor da classe
    public Apartamento(double valorAluguel, String proprietario) {
        super(valorAluguel, proprietario);
    }

    // Implementação do calcularComissao() da classe Imovel
    @Override
    public double calcularComissao() {
        return getValorAluguel() * PORCENTAGEM_COMISSAO;
    }
}

public class ContratoAluguel {
    private Imovel imovel;
    private Cliente cliente;
    private Consultor consultor;


    // Construtor da classe
    public ContratoAluguel(Imovel imovel, Cliente cliente, Consultor consultor) {
        this.imovel = imovel;
        this.cliente = cliente;
        this.consultor = consultor;

        consultor.incrementaContratos();
    }

    // Calcula o valor da comissão para o contrato com base no imóvel.
    public double calcularValorComissao() {
        double comissao = imovel.calcularComissao();
        return comissao;
    }

    // Retorna o imóvel do contrato
    public Imovel getImovel() {
        return this.imovel;
    }

    // Retorna o cliente do contrato
    public Cliente getCliente() {
        return this.cliente;
    }

    // Retorna o consultor do contrato.
    public Consultor getConsultor() {
        return this.consultor;
    }
 
    // Define o imóvel do contrato
    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    // Define o cliente do contrato
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Define o consultor do contrato
    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }
}

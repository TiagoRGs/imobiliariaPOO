
// Classe pessoa física que herda de Cliente
public class PessoaFisica extends Cliente {

    // Construtor
    public PessoaFisica(String nome) {
        super(nome);
    }

    // Implementação do getTipoCliente() da classe Cliente
    @Override
    public String getTipoCliente() {
        return "Pessoa Física";
    }
}

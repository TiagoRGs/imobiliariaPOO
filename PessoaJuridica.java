
// Classe PessoaJuridica que herda de Cliente
public class PessoaJuridica extends Cliente {

    // Construtor
    public PessoaJuridica(String nome) {
        super(nome);
    }

    // Implementação do getTipoCliente() da classe Cliente
    @Override
    public String getTipoCliente() {
        return "Pessoa Jurídica";
    }
}

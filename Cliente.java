
// Classe abstrata Cliente
public abstract class Cliente {

    protected String nome;

    // Construtor da classe
    public Cliente(String nome) {
        this.nome = nome;
    }

    // Metodo abstrato
    public abstract String getTipoCliente();

    //  Retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    // Setter do nome
    public void setNome(String nome) {
        this.nome = nome;
    }
}

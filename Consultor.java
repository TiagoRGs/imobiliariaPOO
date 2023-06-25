public class Consultor {
    private String nome;
    private double salario;
    private double numero_contratos;

    public Consultor(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.numero_contratos = 0;
    }

    // Retorna o nome do consultor.
    public String getNome() {
        return this.nome;
    }


    // Retorna o salário do consultor.
    public double getSalario() {
        return this.salario;
    }

    // Define o valor do salário de um consultor
    public void setSalario(double salario){
        this.salario = salario;
    } 

    // Incrementa o número de contratos do consultor. A cada chamada desse método, o valor de numero_contratos é aumentado em 1
    public void incrementaContratos(){
        this.numero_contratos++;
    }

    // Calcula o valor do bônus a ser recebido pelo consultor com base no número de contratos que ele possui
    public double valorBonusContrato() {
        double bonus = numero_contratos * 0.10;

        return this.salario * bonus; 
    }
}

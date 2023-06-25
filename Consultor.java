public class Consultor {
    private String nome;
    private double salario;
    private Integer numeroContratos;

    public Consultor(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.numeroContratos = 0;
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

    // Incrementa o número de contratos do consultor. A cada chamada desse método, o valor de numeroContratos é aumentado em 1
    public void incrementaContratos(){
        this.numeroContratos++;
    }

    // Calcula o valor do bônus a ser recebido pelo consultor com base no número de contratos que ele possui
    public double valorBonusContrato() {
        double bonus = numeroContratos * 0.10;

        return this.salario * bonus; 
    }
}

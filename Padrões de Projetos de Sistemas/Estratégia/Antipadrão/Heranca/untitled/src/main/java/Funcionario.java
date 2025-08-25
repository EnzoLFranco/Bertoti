class Funcionario {
    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public void trabalhar() {
        System.out.println(nome + " está trabalhando como " + cargo + ".");
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }
}

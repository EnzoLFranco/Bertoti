class Gerente extends Funcionario {
    public Gerente(String nome) {
        super(nome, "Gerente");
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " está gerenciando a equipe.");
    }
}

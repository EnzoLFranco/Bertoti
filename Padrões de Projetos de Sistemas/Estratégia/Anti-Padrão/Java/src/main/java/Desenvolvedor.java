class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome) {
        super(nome, "Desenvolvedor");
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " está escrevendo código.");
    }
}

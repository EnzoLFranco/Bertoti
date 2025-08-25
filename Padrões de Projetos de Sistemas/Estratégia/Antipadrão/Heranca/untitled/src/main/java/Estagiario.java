class Estagiario extends Funcionario {
    public Estagiario(String nome) {
        super(nome, "Estagiário");
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " está aprendendo e ajudando na equipe.");
    }
}

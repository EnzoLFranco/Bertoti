public class Main {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente("Alice");
        Funcionario desenvolvedor = new Desenvolvedor("Bob");
        Funcionario estagiario = new Estagiario("Carlos");

        gerente.trabalhar();
        desenvolvedor.trabalhar();
        estagiario.trabalhar();
    }
}

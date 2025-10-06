package model.composite;

public class TarefaSimples extends Tarefa {
    public TarefaSimples(String nome) {
        super(nome);
    }

    @Override
    public void concluir() {
        this.concluida = true;
        notificarObservadores();
    }

    @Override
    public void exibir(int nivel) {
        System.out.println("  ".repeat(nivel) + "- " + nome + (concluida ? " (ok)" : ""));
    }
}

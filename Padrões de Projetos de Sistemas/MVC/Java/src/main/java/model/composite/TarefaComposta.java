package model.composite;

import java.util.ArrayList;
import java.util.List;

public class TarefaComposta extends Tarefa {
    private List<Tarefa> subtarefas = new ArrayList<>();

    public TarefaComposta(String nome) {
        super(nome);
    }

    public void adicionar(Tarefa t) {
        subtarefas.add(t);
    }

    @Override
    public void concluir() {
        for (Tarefa t : subtarefas) {
            t.concluir();
        }
        this.concluida = true;
        notificarObservadores();
    }

    @Override
    public void exibir(int nivel) {
        System.out.println("  ".repeat(nivel) + "+ " + nome);
        for (Tarefa t : subtarefas) {
            t.exibir(nivel + 1);
        }
    }
}

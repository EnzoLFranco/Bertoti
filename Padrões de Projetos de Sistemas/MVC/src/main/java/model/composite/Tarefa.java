package model.composite;

import model.observer.Observador;
import java.util.ArrayList;
import java.util.List;

public abstract class Tarefa {
    protected String nome;
    protected boolean concluida = false;
    protected List<Observador> observadores = new ArrayList<>();

    public Tarefa(String nome) {
        this.nome = nome;
    }

    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.atualizar("Tarefa " + nome + " foi concluída!");
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public abstract void concluir();
    public abstract void exibir(int nivel);
}

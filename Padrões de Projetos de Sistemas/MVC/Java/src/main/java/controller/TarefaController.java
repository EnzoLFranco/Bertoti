package controller;

import model.composite.*;
import model.strategy.*;
import view.TarefaView;

public class TarefaController {
    private TarefaComposta projeto;
    private EstrategiaPrioridade estrategia;
    private TarefaView view;

    public TarefaController(TarefaComposta projeto, EstrategiaPrioridade estrategia, TarefaView view) {
        this.projeto = projeto;
        this.estrategia = estrategia;
        this.view = view;
    }

    public void exibirEstrutura() {
        view.mostrarMensagem("Estrutura do projeto:");
        projeto.exibir(0);
    }

    public void concluirTarefa(String nomeTarefa) {
        view.mostrarMensagem("Concluindo tarefa: " + nomeTarefa);
        projeto.concluir();
    }

    public void calcularPrioridade(int diasRestantes, int importancia) {
        int prioridade = estrategia.calcularPrioridade(diasRestantes, importancia);
        view.mostrarMensagem("Prioridade calculada: " + prioridade);
    }
}

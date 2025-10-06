import model.composite.*;
import model.observer.*;
import model.strategy.*;
import controller.TarefaController;
import view.TarefaView;

public class Main {
    public static void main(String[] args) {
        TarefaSimples t1 = new TarefaSimples("Configurar ambiente");
        TarefaSimples t2 = new TarefaSimples("Criar banco de dados");
        TarefaComposta projeto = new TarefaComposta("Projeto MVC");

        projeto.adicionar(t1);
        projeto.adicionar(t2);

        Usuario ana = new Usuario("Ana");
        projeto.adicionarObservador(ana);
        t1.adicionarObservador(ana);

        TarefaView view = new TarefaView();

        EstrategiaPrioridade estrategia = new PrioridadePorPrazo();

        TarefaController controller = new TarefaController(projeto, estrategia, view);

        controller.exibirEstrutura();
        controller.concluirTarefa("Configurar ambiente");
        controller.calcularPrioridade(3, 5);
    }
}

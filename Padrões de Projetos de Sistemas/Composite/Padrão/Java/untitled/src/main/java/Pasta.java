import java.util.ArrayList;
import java.util.List;

public class Pasta implements ArquivoComponent {
    private String nome;
    private List<ArquivoComponent> componentes = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(ArquivoComponent componente) {
        componentes.add(componente);
    }

    public void remover(ArquivoComponent componente) {
        componentes.remove(componente);
    }

    @Override
    public void exibir(String indent) {
        System.out.println(indent + "📁 " + nome);
        for (ArquivoComponent componente : componentes) {
            componente.exibir(indent + "   ");
        }
    }
}

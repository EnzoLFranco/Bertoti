public class Arquivo implements ArquivoComponent {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionar(ArquivoComponent componente) {
        throw new UnsupportedOperationException("Não é possível adicionar em um arquivo.");
    }

    @Override
    public void remover(ArquivoComponent componente) {
        throw new UnsupportedOperationException("Não é possível remover de um arquivo.");
    }

    @Override
    public void exibir(String indent) {
        System.out.println(indent + "📄 " + nome);
    }
}

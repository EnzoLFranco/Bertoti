public class Arquivo implements ArquivoComponent {
    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir(String indent) {
        System.out.println(indent + "📄 " + nome);
    }
}

public class Main {
    public static void main(String[] args) {
        ArquivoComponent foto = new Arquivo("foto.png");
        ArquivoComponent musica = new Arquivo("musica.mp3");

        Pasta midias = new Pasta("Mídias");
        midias.adicionar(foto);
        midias.adicionar(musica);

        midias.exibir("");
    }
}

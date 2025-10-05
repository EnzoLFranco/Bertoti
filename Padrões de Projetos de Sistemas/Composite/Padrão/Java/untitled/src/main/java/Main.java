public class Main {
    public static void main(String[] args) {
        // Criando arquivos individuais
        ArquivoComponent a1 = new Arquivo("foto.png");
        ArquivoComponent a2 = new Arquivo("documento.txt");
        ArquivoComponent a3 = new Arquivo("musica.mp3");

        // Criando pastas
        Pasta imagens = new Pasta("Imagens");
        Pasta documentos = new Pasta("Documentos");
        Pasta midias = new Pasta("Mídias");

        // Adicionando arquivos às pastas
        imagens.adicionar(a1);
        documentos.adicionar(a2);
        midias.adicionar(a3);

        // Criando uma pasta principal e adicionando outras dentro dela
        Pasta raiz = new Pasta("Meu Computador");
        raiz.adicionar(imagens);
        raiz.adicionar(documentos);
        raiz.adicionar(midias);

        // Exibir toda a estrutura
        raiz.exibir("");
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Camiseta", 49.90);
        Pedido pedido = new Pedido(produto, 3);

        pedido.imprimirDetalhes();
    }
}

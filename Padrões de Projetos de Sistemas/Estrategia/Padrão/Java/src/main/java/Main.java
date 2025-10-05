public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        // Usando Cartão de Crédito
        pedido.setPagamento(new PagamentoCartaoCredito());
        pedido.realizarPagamento(150.00);

        // Usando PayPal
        pedido.setPagamento(new PagamentoPaypal());
        pedido.realizarPagamento(200.00);
    }
}

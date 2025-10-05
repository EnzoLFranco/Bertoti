class PagamentoPaypal implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando R$ " + valor + " com PayPal.");
    }
}

class PagamentoCartaoCredito implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando R$ " + valor + " com Cartão de Crédito.");
    }
}

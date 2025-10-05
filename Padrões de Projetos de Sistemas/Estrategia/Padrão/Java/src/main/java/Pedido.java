class Pedido {
    private Pagamento pagamento;

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void realizarPagamento(double valor) {
        if (pagamento != null) {
            pagamento.pagar(valor);
        } else {
            System.out.println("Método de pagamento não definido.");
        }
    }
}

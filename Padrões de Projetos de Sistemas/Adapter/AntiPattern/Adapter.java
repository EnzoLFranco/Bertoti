public class Adapter implements Refeicao {
    private RefeicaoSimples refeicaoSimples;

    public Adapter(RefeicaoSimples refeicaoSimples) {
        this.refeicaoSimples = refeicaoSimples;
    }

    @Override
    public String getDescricao() {
        // Nenhuma adaptação real — apenas repassa a chamada.
        return refeicaoSimples.getDescricao();
    }

    @Override
    public int getCalorias() {
        // Nenhuma conversão, nenhuma lógica.
        return refeicaoSimples.getCalorias();
    }
}
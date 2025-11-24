public class RefeicaoSimples implements Refeicao {
    private String descricao;
    private int calorias;

    public RefeicaoSimples(String descricao, int calorias) {
        this.descricao = descricao;
        this.calorias = calorias;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public int getCalorias() {
        return calorias;
    }
}
public class AdapterAlmoco implements Refeicao {
    private AlmocoAntigo almocoAntigo;

    public AdaptadorAlmoco(AlmocoAntigo almocoAntigo) {
        this.almocoAntigo = almocoAntigo;
    }

    @Override
    public String getDescricao() {
        return almocoAntigo.obterNomeDoPrato();
    }

    @Override
    public int getCalorias() {
        // 1 quilojoule ≈ 0.239006 kcal
        double kcal = almocoAntigo.obterEnergia() * 0.239006;
        return (int) Math.round(kcal);
    }
}
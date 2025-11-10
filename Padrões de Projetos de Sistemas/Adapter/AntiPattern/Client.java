public class Client {
    public static void main(String[] args) {
        RefeicaoSimples refeicao = new RefeicaoSimples("Macarrão com queijo", 650);

        // Uso correto:
        System.out.println(refeicao.getDescricao() + " → " + refeicao.getCalorias() + " kcal");

        // Uso incorreto (antipattern):
        Refeicao refeicaoComAdaptador = new AdaptadorDesnecessario(refeicao);
        System.out.println(refeicaoComAdaptador.getDescricao() + " → " + refeicaoComAdaptador.getCalorias() + " kcal");
    }
}
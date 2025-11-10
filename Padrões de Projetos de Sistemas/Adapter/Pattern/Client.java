
public class Client {
    public static void main(String[] args) {
        Refeicao refeicao1 = new RefeicaoSimples("Salada de frango", 400);
        System.out.println(refeicao1.getDescricao() + " → " + refeicao1.getCalorias() + " kcal");

        AlmocoAntigo almocoAntigo = new AlmocoLegacy("Almoço executivo", 2100.0); // 2100 kJ
        Refeicao refeicaoAdaptada = new AdapterAlmoco(almocoAntigo);
        System.out.println(refeicaoAdaptada.getDescricao() + " → " + refeicaoAdaptada.getCalorias() + " kcal");
    }
}

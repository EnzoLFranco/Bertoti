public class AlmocoLegacy {
    private String nomeDoPrato;
    private double energia; // em quilojoules (kJ)

    public AlmocoAntigo(String nomeDoPrato, double energia) {
        this.nomeDoPrato = nomeDoPrato;
        this.energia = energia;
    }

    public String obterNomeDoPrato() {
        return nomeDoPrato;
    }

    public double obterEnergia() {
        return energia;
    }
}
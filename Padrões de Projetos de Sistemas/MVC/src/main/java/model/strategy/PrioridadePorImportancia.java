package model.strategy;

public class PrioridadePorImportancia implements EstrategiaPrioridade {
    @Override
    public int calcularPrioridade(int diasRestantes, int importancia) {
        return importancia * 10;
    }
}

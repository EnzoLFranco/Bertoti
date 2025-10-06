package model.strategy;

public class PrioridadePorPrazo implements EstrategiaPrioridade {
    @Override
    public int calcularPrioridade(int diasRestantes, int importancia) {
        return 100 - diasRestantes * 10;
    }
}

import java.util.ArrayList;
import java.util.List;

class EventoConferencia implements Evento {
    private List<Participante> participantes;
    private String nomeEvento;
    private String status;

    public EventoConferencia(String nomeEvento) {
        this.nomeEvento = nomeEvento;
        this.participantes = new ArrayList<>();
    }

    @Override
    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }

    @Override
    public void removerParticipante(Participante participante) {
        participantes.remove(participante);
    }

    @Override
    public void notificarParticipantes() {
        for (Participante participante : participantes) {
            participante.atualizar("Atualização do evento: " + nomeEvento + " - Status: " + status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notificarParticipantes();
    }
}

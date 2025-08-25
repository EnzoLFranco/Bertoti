import java.util.ArrayList;
import java.util.List;

interface Evento {
    void adicionarParticipante(Participante participante);
    void removerParticipante(Participante participante);
    void notificarParticipantes();
}

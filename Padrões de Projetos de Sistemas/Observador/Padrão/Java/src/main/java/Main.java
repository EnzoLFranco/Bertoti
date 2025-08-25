public class Main {
    public static void main(String[] args) {
        EventoConferencia conferencia = new EventoConferencia("Conferência de Tecnologia");

        ParticipanteEvento participante1 = new ParticipanteEvento("Alice");
        ParticipanteEvento participante2 = new ParticipanteEvento("Bob");

        conferencia.adicionarParticipante(participante1);
        conferencia.adicionarParticipante(participante2);
        
        conferencia.setStatus("Iniciado");
        conferencia.setStatus("Pausa");
        conferencia.setStatus("Encerrado");
    }
}

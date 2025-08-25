class ParticipanteEvento implements Participante {
    private String nome;

    public ParticipanteEvento(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu a notificação: " + mensagem);
    }
}

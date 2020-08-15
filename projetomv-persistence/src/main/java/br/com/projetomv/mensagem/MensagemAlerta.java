package br.com.projetomv.mensagem;

public class MensagemAlerta extends Mensagem {

    /**
     * Construtor recebendo o conteúdo da mensagem do tipo alerta.
     * 
     * @param conteudo conteúdo da mensagem
     */
    public MensagemAlerta(String conteudo) {
        super("warning", conteudo);
    }
    
}
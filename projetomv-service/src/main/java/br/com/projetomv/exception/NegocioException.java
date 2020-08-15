package br.com.projetomv.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.ApplicationException;

import br.com.projetomv.mensagem.Mensagem;
import br.com.projetomv.mensagem.MensagemAlerta;
import br.com.projetomv.mensagem.MensagemErro;

/**
 * Exceção de negocio do tipo {@link RuntimeException}
 * 
 * @author Rafael
 *
 */
@ApplicationException(rollback = true)
public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    /**
     * Lista de mensagens.
     */
    private final transient List<Mensagem> mensagens = new ArrayList<>();

    /**
     * Constrói a exceção adicionando uma mensagem.
     *
     * @param messages
     */
    public NegocioException(String... messages) {
        for (String mensagem : Arrays.asList(messages)) {
            this.mensagens.add(new MensagemErro(mensagem));
        }
    }
    
    /**
     * Constrói a exceção adicionando uma mensagem.
     *
     * @param messages
     */
    public NegocioException(Mensagem... messages) {
        this.mensagens.addAll(Arrays.asList(messages));
    }

    public NegocioException() {
    }

    /**
     * Adiciona uma mensagem à exceção.
     *
     * @param message mensagem
     */
    public void add(Mensagem message) {
        this.mensagens.add(message);
    }

    /**
     * Retorna a lista de mensagens.
     * 
     * @return lista de mensagens
     */
    public List<Mensagem> getMessages() {
        return mensagens;
    }

    /**
     * Constrói e lança uma exceção com uma mensagem de erro.
     * 
     * @param mensagem mensagem de erro
     */
    public static void throwExceptionErro(String mensagem) {
        throw new NegocioException(new MensagemErro(mensagem));
    }

    /**
     * Constrói e lança uma exceção com uma mensagem de alerta.
     * 
     * @param mensagem mensagem de alerta
     */
    public static void throwExceptionAlerta(String mensagem) {
        throw new NegocioException(new MensagemAlerta(mensagem));
    }

    /**
     * Constrói e lança uma exceção com uma mensagem de erro caso o objeto passado como parâmetro seja <code>null</code>.
     * 
     * @param objeto objeto que será verificado
     * @param mensagem mensagem de erro
     */
    public static <T> void throwExceptionErroIfNull(T objeto, String mensagem) {
        if (objeto == null) {
            throwExceptionErro(mensagem);
        }
    }

    /**
     * Constrói e lança uma exceção com uma mensagem de alerta caso o objeto passado como parâmetro seja <code>null</code>.
     * 
     * @param objeto objeto que será verificado
     * @param mensagem mensagem de alerta
     */
    public static <T> void throwExceptionAlertaIfNull(T objeto, String mensagem) {
        if (objeto == null) {
            throwExceptionAlerta(mensagem);
        }
    }
}
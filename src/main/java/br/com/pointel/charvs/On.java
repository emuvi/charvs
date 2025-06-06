package br.com.pointel.charvs;

/**
 *
 * @author emuvi
 * @param <P> parameter expected
 * @param <R> result returned
 */
public abstract class On<P, R> {
    
    public abstract R execute(P param);
    
}

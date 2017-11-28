/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

/**
 *
 * @author Bruno
 */
public class Produto extends ItemFinanceiro implements Entidade{
    private int quantidade;
    private long precoCusto;

    public Produto() {
    }

    public Produto(int quantidade, long precoCusto) {
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ViolacaoRegraNegocioException{
        if(quantidade <= 0)
            throw new ViolacaoRegraNegocioException("A quantidade deve ser maior que: '0' (Zero)");
        this.quantidade = quantidade;
    }

    public long getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(long precoCusto) throws ViolacaoRegraNegocioException{
        if (precoCusto < 0)
            throw new ViolacaoRegraNegocioException("Preço de custo não pode ser menor que: '0' (Zero)");
        this.precoCusto = precoCusto;
    }

    @Override
    public String toString() {
        return "Produto{" + "quantidade=" + quantidade + ", precoCusto=" + precoCusto + '}';
    }
    
    
    
}

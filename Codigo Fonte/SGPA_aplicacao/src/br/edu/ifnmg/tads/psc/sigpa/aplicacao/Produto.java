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
    private int estoque;
    private long precoCusto;

    public Produto() {
    }

    public Produto(int estoque, long precoCusto) {
        this.estoque = estoque;
        this.precoCusto = precoCusto;
    }

    public int getestoque() {
        return estoque;
    }

    public void setestoque(int estoque) throws ViolacaoRegraNegocioException{
        if(estoque <= 0)
            throw new ViolacaoRegraNegocioException("A estoque deve ser maior que: '0' (Zero)");
        this.estoque = estoque;
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
        return "Produto{" + "estoque=" + estoque + ", precoCusto=" + precoCusto + '}';
    }
    
    
    
}

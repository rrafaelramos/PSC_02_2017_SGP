/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.util.Objects;

/**
 *
 * @author Bruno
 */
public class ItemFinanceiro implements Entidade{
    long id;
    private long precoVenda;
    private String descricao;

    public ItemFinanceiro() {
    }

    public ItemFinanceiro(long id, long precoVenda, String descricao) {
        this.id = id;
        this.precoVenda = precoVenda;
        this.descricao = descricao;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(long precoVenda) throws ViolacaoRegraNegocioException{
        if(precoVenda < 0)
            throw new ViolacaoRegraNegocioException("O Valor de venda não pode ser menor que '0' (Zero)");
        this.precoVenda = precoVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ItemFinanceiro{" + "precoVenda=" + precoVenda + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + (int) (this.precoVenda ^ (this.precoVenda >>> 32));
        hash = 59 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemFinanceiro other = (ItemFinanceiro) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.precoVenda != other.precoVenda) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    
    
    
}

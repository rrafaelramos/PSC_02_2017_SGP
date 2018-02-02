/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Bruno
 */
public class ItemFinanceiro implements Entidade{
    long id;
    private BigDecimal precoVenda, precoCusto;
    private String descricao, nome, categoria;
    private Fornecedor fornecedor;
    private int estoque;

    public ItemFinanceiro() {
    }

    public ItemFinanceiro(long id, BigDecimal precoVenda, BigDecimal precoCusto, String descricao, String nome, String categoria, int estoque, Fornecedor fornecedor) {
        this.id = id;
        this.precoVenda = precoVenda;
        this.precoCusto = precoCusto;
        this.descricao = descricao;
        this.nome = nome;
        this.categoria = categoria;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) throws ViolacaoRegraNegocioException{
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.precoVenda);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        return hash;
    }
    
    
    
}

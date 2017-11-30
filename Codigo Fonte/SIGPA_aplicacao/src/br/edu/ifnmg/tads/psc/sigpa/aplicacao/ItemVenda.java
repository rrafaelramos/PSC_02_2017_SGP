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
public class ItemVenda implements Entidade{
    private long id;
    private Produto produto;
    //private Servico servico;
    private int quantidade;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(long id, Produto produto, int quantidade, Venda venda) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.venda = venda;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) throws ViolacaoRegraNegocioException{
        if(produto == null)
            throw new ViolacaoRegraNegocioException("Produto de preenchimento obrigatório!");
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ViolacaoRegraNegocioException{
        if(quantidade <= 0)
            throw new ViolacaoRegraNegocioException("A quantidade deve ser maior que: '0' (Zero)");
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + this.quantidade;
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }
    
}

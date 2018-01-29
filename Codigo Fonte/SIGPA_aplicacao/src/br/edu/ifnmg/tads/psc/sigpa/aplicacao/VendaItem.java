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
 * @author petronio
 */
public class VendaItem implements Entidade {
    private long id;
    private Venda venda;
    private ItemFinanceiro item;
    private int quantidade;
    private BigDecimal valorUnitario;

    public VendaItem() {
    }

    public VendaItem(long id, Venda venda, ItemFinanceiro item, int quantidade, BigDecimal valorUnitario) {
        this.id = id;
        this.venda = venda;
        this.item = item;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItemFinanceiro getItem() {
        return item;
    }

    public void setItem(ItemFinanceiro item) {
        this.item = item;
        if(id == 0 && valorUnitario == null)
            valorUnitario = item.getPrecoVenda();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public BigDecimal getValorTotal() {
        return this.valorUnitario.multiply(BigDecimal.valueOf(this.quantidade));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.venda);
        hash = 41 * hash + Objects.hashCode(this.item);
        hash = 41 * hash + this.quantidade;
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
        final VendaItem other = (VendaItem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }
    
    
}

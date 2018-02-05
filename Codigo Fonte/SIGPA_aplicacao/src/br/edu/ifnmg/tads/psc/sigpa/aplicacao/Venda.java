/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Venda implements Entidade{
    private long id;
    private Date data;
    private Cliente cliente;
    private BigDecimal valorVenda;
    private List<VendaItem> itens;

    public Venda() {
        id = 0;
        itens = new ArrayList<>();
        data = new Date();
        valorVenda = new BigDecimal("0.00");
    }

   

    

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
    
    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }
    
    public void addItem(VendaItem item){
        if(!this.itens.contains(item)){
            item.setVenda(this);
            itens.add(item);
            this.valorVenda = this.valorVenda.add(item.getValorTotal());
        }
    }
    
    public void removeItem(VendaItem item){
        if(this.itens.contains(item)){
            itens.remove(item);
            this.valorVenda = this.valorVenda.subtract(item.getValorTotal());
        }
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", cliente=" + cliente + ", valorVenda=" + valorVenda + ", itens=" + itens + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.data);
        hash = 37 * hash + Objects.hashCode(this.cliente);
        hash = 37 * hash + Objects.hashCode(this.valorVenda);
        hash = 37 * hash + Objects.hashCode(this.itens);
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.valorVenda, other.valorVenda)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return true;
    }

   
    
    
}

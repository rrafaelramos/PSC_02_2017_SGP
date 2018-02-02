/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ItemFinanceiro;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ItemFinanceiroRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Venda;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.VendaItem;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.VendaRepositorio;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio {

    ClienteRepositorio clientes = RepositorioBuilder.getClienteRepositorio();
    ItemFinanceiroRepositorio itemFinanceiro;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public VendaDAO() throws ClassNotFoundException {
        this.itemFinanceiro = RepositorioBuilder.getItemFinanceiroRepositorio();
    }

    @Override
    protected String consultaAbrir() {
        return "select id, datavenda, cliente_fk, valorvenda from venda where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into venda(datavenda, cliente_fk, valorvenda ) values(?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update venda set datavenda=?, cliente_fk=?, valorvenda=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete venda where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select id, datavenda, cliente_fk, valorvenda, from venda";
    }

    @Override
    protected void carregaParametros(Venda obj, PreparedStatement consulta) {
        try {
            consulta.setLong(1, obj.getCliente().getId());
            consulta.setDate(2, new Date(obj.getData().getTime()));
            consulta.setBigDecimal(3, obj.getValorVenda());
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Venda carregaObjeto(ResultSet dados) {
        try {

            Venda obj = new Venda();
            obj.setId(dados.getLong(1));
            obj.setCliente(clientes.Abrir(dados.getLong(2)));
            obj.setData(new java.util.Date(dados.getDate(3).getTime()));
            obj.setValorVenda(dados.getBigDecimal(4));

            obj.setItens(AbrirItens(obj));

            return obj;

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<VendaItem> AbrirItens(Venda obj) {
        try {
            // Utilizando a conexão aberta, cria um Statement (comando)
            PreparedStatement consulta = BD.getConexao().prepareStatement(
                    "select id, venda, produto, quantidade, valorunitario from vendasitens where venda = ?");

            // Coloca o parâmetro da consulta (id)
            consulta.setLong(1, obj.getId());

            // Executa a consulta select e recebe os dados de retorno
            ResultSet dados = consulta.executeQuery();

            List<VendaItem> itens = new ArrayList<>();
            while (dados.next()) {
                itens.add(carregaObjetoItem(obj, dados));
            }

            return itens;

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    private VendaItem carregaObjetoItem(Venda venda, ResultSet dados) {
        try {
            VendaItem item = new VendaItem();
            item.setId(dados.getLong("id"));
            item.setVenda(venda);
            item.setItem(itemFinanceiro.Abrir(dados.getLong("itemfinanceiro")));
            item.setQuantidade(dados.getInt("quantidade"));
            item.setValorUnitario(dados.getBigDecimal("valorunitario"));

            return item;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected String carregaParametrosBusca(Venda obj) {
        String sql = "";
        if (obj.getId() > 0) {
            sql = this.filtrarPor(sql, "id", Long.toString(obj.getId()));
        }

        if (obj.getData() != null) {
            sql = this.filtrarPor(sql, "data", df.format(obj.getData()));
        }

        if (obj.getCliente() != null) {
            sql = this.filtrarPor(sql, "cliente", Long.toString(obj.getCliente().getId()));
        }

        return sql;
    }

    @Override
    public boolean Salvar(Venda obj) {
        if (super.Salvar(obj)) {
            
            long id = obj.getId();
            
            if(id == 0){
            
                try {
                    String pegaid = "select max(id) from vendas where cliente = ? and data = ?";
                    
                    PreparedStatement consultaid = BD.getConexao().prepareStatement(pegaid);
                    
                    consultaid.setLong(1, obj.getCliente().getId());
                    consultaid.setDate(2, new java.sql.Date(obj.getData().getTime()));
                    
                    ResultSet retorno = consultaid.executeQuery();
                    
                    retorno.next();
                    
                    id = retorno.getLong(1);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            try {
                String sql = "insert into itemvenda(venda, produto, quantidade, valorunitario) values(?,?,?,?)";

                for (VendaItem i : obj.getItens()) {

                    PreparedStatement consulta = BD.getConexao().prepareStatement(sql);

                    consulta.setLong(1, id);
                    consulta.setLong(2, i.getItem().getId());
                    consulta.setInt(3, i.getQuantidade());
                    consulta.setBigDecimal(4, i.getValorUnitario());
                    
                    consulta.executeUpdate();

                }

                return true;
            } catch (SQLException ex) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ItemFinanceiro;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ItemFinanceiroRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class ItemFinanceiroDAO extends DAOGenerico<ItemFinanceiro> implements ItemFinanceiroRepositorio{
    
    @Override
    protected String consultaAbrir() {
        return "select * from itemfinanceiro where id=?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into itemfinanceiro (precounitario, precocusto, estoque, descricao) values(?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update itemfinanceiro precounitario=?, precocusto=?, estoque=?, descricao=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from itemfinanceiro where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from itemfinanceiro"; 
    }

    @Override
    protected void carregaParametros(ItemFinanceiro obj, PreparedStatement consulta) {
       
        try {
            consulta.setLong(1, obj.getPrecoVenda());
            consulta.setLong(2, obj.getPrecoCusto());
            consulta.setInt(3, obj.getEstoque());
            consulta.setString(4, obj.getDescricao());
        } catch (SQLException ex) {
            Logger.getLogger(ItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(ItemFinanceiro obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getDescricao()!= null && !obj.getDescricao().isEmpty())
            sql = this.filtrarPor(sql, "descricao", obj.getDescricao());
        
        return sql;
    }

    @Override
    protected ItemFinanceiro carregaObjeto(ResultSet dados) {
        try {
            ItemFinanceiro obj = new ItemFinanceiro();
            obj.setId(dados.getLong(1));
            obj.setPrecoVenda(dados.getLong(2));
            obj.setPrecoCusto(dados.getLong(3));
            obj.setEstoque(dados.getInt(4));
            obj.setDescricao(dados.getString(5));
            
            return obj;
            
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    

}

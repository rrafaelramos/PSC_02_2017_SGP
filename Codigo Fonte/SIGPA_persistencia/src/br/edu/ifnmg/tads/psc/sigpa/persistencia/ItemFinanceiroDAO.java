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
        return "insert into itemfinanceiro (nome, precounitario, precocusto, estoque, descricao, categoria, fornecedor_fk) values(?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update itemfinanceiro nome=?, precounitario=?, precocusto=?, estoque=?, descricao=?, categoria=?, fornecedor_fk=? where id = ?";
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
            consulta.setString(1, obj.getNome());
            consulta.setBigDecimal(2, obj.getPrecoVenda());
            consulta.setBigDecimal(3, obj.getPrecoCusto());
            consulta.setInt(4, obj.getEstoque());
            consulta.setString(5, obj.getDescricao());
            consulta.setString(6, obj.getCategoria());
            consulta.setString(7, obj.getFornecedor());
        } catch (SQLException ex) {
            Logger.getLogger(ItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(ItemFinanceiro obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome()!= null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getDescricao());
        
        if(obj.getClass()!= null && !obj.getCategoria().isEmpty())
            sql = this.filtrarPor(sql, "categoria", obj.getDescricao());
        
        return sql;
    }

    @Override
    protected ItemFinanceiro carregaObjeto(ResultSet dados) {
        try {
            ItemFinanceiro obj = new ItemFinanceiro();
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setPrecoVenda(dados.getBigDecimal(3));
            obj.setPrecoCusto(dados.getBigDecimal(4));
            obj.setEstoque(dados.getInt(4));
            obj.setDescricao(dados.getString(5));
            obj.setCategoria(dados.getString(6));
            obj.setFornecedor(dados.getString(7));
            
            return obj;
            
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ItemFinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    
    

}

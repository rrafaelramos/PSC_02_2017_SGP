/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Cliente;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ClienteRepositorio;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio {

    @Override
    protected String consultaAbrir() {
        return "select id, cpf, rg, nome, email, telefone, sexo, "
                + "nascimento, endereco, limiteCompra from Clientes where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into Clientes(cpf, rg, nome, email, telefone, sexo, "
                + "nascimento, endereco, limiteCompra) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update Clientes set cpf = ?, rg = ?, nome = ?, email = ?, telefone = ?, sexo = ?,"
                + "nascimento = ?, endereco = ?, limiteCompra = ? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from Clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from Clientes "; 
    }

    @Override
    protected void carregaParametros(Cliente obj, PreparedStatement consulta) {
        try {
           
            consulta.setString(1, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setString(2, obj.getRg());
            consulta.setString(3, obj.getNome());
            consulta.setString(4, obj.getEmail());
            consulta.setString(5, obj.getTelefone());
            //como inserir um char?
            //consulta.(6, obj.getSexo());
            consulta.setDate(7, (Date) obj.getNascimento());
            consulta.setObject(8, obj.getEndereco());
            consulta.setBigDecimal(9, obj.getLimiteCompra());
            
//inserir data de nascimento
            consulta.setDate(3, null);
            
            if(obj.getId() > 0)
                consulta.setLong(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Cliente obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getCpf() != null && !obj.getCpf().isEmpty())
            sql = this.filtrarPor(sql, "cpf", obj.getCpf().replace(".", "").replace("-", ""));        
        
        return sql;
    }

    @Override
    protected Cliente carregaObjeto(ResultSet dados) {
        try {
            Cliente obj = new Cliente();
            dados.getLong("id");
            dados.getString("nome");
            dados.getString("rg");
            dados.getString("cpf");
            dados.getDate("nascimento");
           // dados.getC("sexo");
            
          
            
            return obj;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

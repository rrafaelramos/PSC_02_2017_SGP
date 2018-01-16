/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Cliente;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Endereco;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Sexo;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException;
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
        return "select * from clientes where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into clientes (cpf, rg, nascimento, sexo, email, endereco, telefone, limite, nome) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update clientes cpf=?, rg=?, nascimento=?, sexo=?, email=?, endereco=?, telefone=?, limite=?, nome=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from clientes "; 
    }

    
    @Override
    protected void carregaParametros(Cliente obj, PreparedStatement consulta) {
        EnderecoDAO e =  new EnderecoDAO();
        try {
            consulta.setString(1, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setString(2, obj.getRg());
            consulta.setDate(3, new java.sql.Date(obj.getNascimento().getTime()));// Convertendo a data para sql
            consulta.setString(5, obj.getEmail());
            consulta.setString(6, obj.getTelefone());
            consulta.setString(4, obj.getSexo().getValor());
            consulta.setBigDecimal(7, obj.getLimite());
            consulta.setString(8, obj.getNome());
            consulta.setInt(9, e.buscarUltimo());
            if(obj.getId() > 0)
                consulta.setLong(9, obj.getId());
            
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
            obj.setId(dados.getLong("id"));
            obj.setNome(dados.getString("nome"));
            obj.setRg(dados.getString("rg"));
            obj.setCpf(dados.getString("cpf"));
            obj.setNascimento(dados.getDate("nascimento"));
            obj.setSexo(Sexo.parse(dados.getString("sexo")));
            obj.setEmail(dados.getString("email"));
            obj.setEndereco(dados.getLong("endereco"));
            obj.setTelefone(dados.getString("telefone"));
            obj.setLimite(dados.getBigDecimal("limite"));
            
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

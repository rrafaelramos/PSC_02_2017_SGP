/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Endereco;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Funcionario;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.FuncionarioRepositorio;
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
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements FuncionarioRepositorio {

    
    private EnderecoDAO endereco = new EnderecoDAO();
    
    @Override
    protected String consultaAbrir() {
        return "select * from funcionarios where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into funcionarios (nome, cpf, rg, nascimento, sexo, email, endereco_fk, telefone, admissao, cargo, salario, username, senha, tipo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update funcionarios nome=?, cpf=?, rg=?, nascimento=?, sexo=?, email=?, endereco_fk=?, telefone=?, admissao=?, cargo=?, salario=?, username=?, senha=?, tipo=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from funcionarios where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from funcionarios "; 
    }
    
    public String  pegaID (){
        
        return "select max(id) from endereco";
    }
    
    public long buscarUltimo() throws SQLException{
              
                String pegaid = pegaID ();
        
                PreparedStatement consultaid = BD.getConexao().prepareStatement(pegaid);
        
                ResultSet retorno = consultaid.executeQuery();
                
                retorno.next();
                    
                long id = retorno.getLong(1);
                return id;
                    
                
    }

    
    @Override
    protected void carregaParametros(Funcionario obj, PreparedStatement consulta) {
        
        try {
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setString(3, obj.getRg());
            consulta.setDate(4, new java.sql.Date(obj.getNascimento().getTime()));// Convertendo a data para sql
            consulta.setString(5, obj.getSexo().getValor());
            consulta.setString(6, obj.getEmail());
            consulta.setLong(7, buscarUltimo());
            consulta.setString(8,obj.getTelefone());
            consulta.setDate(9, new java.sql.Date(obj.getDataAdmissao().getTime()));
            consulta.setString(10, obj.getCargo());
            consulta.setLong(11, obj.getSalario());
            consulta.setString(12, obj.getUserName());
            consulta.setString(13, obj.getPassword());
            consulta.setInt(14, obj.getTipo());
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Funcionario obj){
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
    protected Funcionario carregaObjeto(ResultSet dados) {
        try {
            Funcionario obj = new Funcionario();
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setCpf(dados.getString(3));
            obj.setRg(dados.getString(4));
            obj.setNascimento(dados.getDate(5));
            obj.setSexo(Sexo.parse(dados.getString(6)));
            obj.setEmail(dados.getString(7));
            obj.setEndereco(endereco.Abrir(dados.getInt(8)));
            obj.setTelefone(dados.getString(9));
            obj.setDataAdmissao(dados.getDate(10));
            obj.setCargo(dados.getString(11));
            obj.setSalario(dados.getLong(12));
            obj.setUserName(dados.getString(13));
            obj.setPassword(dados.getString(14));
            obj.setTipo(dados.getInt(15));
            return obj;
            
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    
    
}

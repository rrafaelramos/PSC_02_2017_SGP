/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.apresentacao;


import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Cliente;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ConverterData;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Endereco;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.EnderecoRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.RepositorioBuilder;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Sexo;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author Bruno
 */
public class Sigpa_apresentacao {

    /**
     * @param args the command line arguments
     * @throws br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException
     */
    public static void main(String[] args) throws ViolacaoRegraNegocioException, ParseException, ClassNotFoundException {
        // TODO code application logic here
        
    ClienteRepositorio clientes = RepositorioBuilder.getClienteRepositorio();
        EnderecoRepositorio endereco = RepositorioBuilder.getEnderecoRepositorio();
    
    Endereco e = new Endereco();
    Cliente c = new Cliente();
      
    c.setCpf("123.456.789-01");
    c.setRg("1234567889");
    c.setNome("ahsjhfsdf");
    c.setEmail("ldjfgeoksdfkko");
    c.setTelefone("12345678");
    c.setSexo(Sexo.Masculino);
    c.setLimite(new BigDecimal(123));
    c.setNascimento(ConverterData.FormatarData("07/01/1992"));
    
    
    e.setNumero(2);
    e.setBairro("teste");
    
    boolean Salvar = endereco.Salvar(e);
    boolean Salva = clientes.Salvar(c);
    }
    
}

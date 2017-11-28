/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.SGPA.aplicacao;

/**
 *
 * @author Bruno
 */
public class SGPA_aplicacao {

    /**
     * @param args the command line arguments
     * @throws br.edu.ifnmg.psc.SGPA.aplicacao.ViolacaoRegraNegocioException
     */
    public static void main(String[] args) throws ViolacaoRegraNegocioException {
      
       //System.out.println("Rua: "+p.getEndereco().getRua() + " Número: "+p.getEndereco().getNumero()+" CEP: "+p.getEndereco().getCep());
       
       //System.out.println(p.toString());
       
       Pessoa p = new Pessoa();
       
       p.setNome("wesley");
       p.setId(1);
       p.setCpf("12345678901");
       p.getEndereco().setRua("troll");
       
       System.out.println(p.toString());
       
       ItemVenda i = new ItemVenda();
       
       
       Produto a = new Produto();
       a.setId(1);
       a.setPrecoVenda(100);
       a.setDescricao("produto teste");
       
       i.setId(1);
       i.setProduto(a);
       i.setQuantidade(2);
       
       System.out.println(i.toString());
       
       Compra c = new Compra();
       c.setId(1);
       c.setValorTotal(1000);
       
       System.out.println(c.toString());
       
    }
    
}

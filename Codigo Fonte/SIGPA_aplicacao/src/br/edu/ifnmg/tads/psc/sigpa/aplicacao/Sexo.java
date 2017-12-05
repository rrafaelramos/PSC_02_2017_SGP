/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

/**
 *
 * @author Bruno
 */
public enum Sexo {
    Masculino("M"), Feminino("F");
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private Sexo(String valor) {
        this.valor = valor;
    }
     
    public static Sexo parse(String s){
        if(s == "M")
            return Sexo.Masculino;
        else if(s == "F")
            return Sexo.Feminino;
        else
            return null;
    }
    
}

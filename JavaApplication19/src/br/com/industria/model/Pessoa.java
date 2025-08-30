/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.industria.model;

import java.time.LocalDate;


/**
 *
 * @author Meu Computador
 */
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    
    public Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Pessoa(){
        this("",null);
    }
    
    public String getNome(){
        return nome;
    }
    
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
}

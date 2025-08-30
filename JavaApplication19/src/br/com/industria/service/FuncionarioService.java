/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.industria.service;

import br.com.industria.model.Funcionario;
import br.com.industria.util.Formatador;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Meu Computador
 */
public class FuncionarioService {
    //listar funcionarios formatados
    public static void listarFuncionarios(List<Funcionario> funcionarios){
        for(Funcionario f: funcionarios){
            System.out.println(f.getNome() + " | "
            + Formatador.formatarData(f.getDataNascimento())+ " | "
            + Formatador.formatarSalario(f.getSalario()) + " | "
            + f.getFuncao());
            }
    }
    
    //remover funcionário pelo nome
    public static void removerFuncionario(List<Funcionario> funcionarios, String nome){
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }
    //aplicar aumento percentual
    public static void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentual){
        for(Funcionario f : funcionarios){
            BigDecimal aumento = f.getSalario().multiply(percentual).setScale(2, RoundingMode.HALF_UP);
            f.setSalario(f.getSalario().add(aumento));
        }
    }
    //agrupar por função
    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }
    //listar aniversariante mês específico
    public static void aniversariantes(List<Funcionario> funcionarios, int... meses){
      for(Funcionario f: funcionarios){
          int mes = f.getDataNascimento().getMonthValue();
          for (int m : meses){
              if(mes == m){
                  System.out.println(f.getNome() + " faz aniversário em " + Formatador.formatarDiaMes(f.getDataNascimento()));
              }
          }
      }  
    }
    //encontrar funcionário mais velho
    public static Funcionario maisVelho(List<Funcionario> funcionarios){
        Funcionario maisVelho = funcionarios.get(0);
        for(Funcionario f: funcionarios){
            if(f.getDataNascimento().isBefore(maisVelho.getDataNascimento())){
                maisVelho = f;
            }
        }
        return maisVelho;
    }
    //listar funcionários em ordem alfabética
    public static void ordenadosPorNome(List<Funcionario> funcionarios) {
        List<Funcionario> copia = new ArrayList<>(funcionarios);
        Collections.sort(copia, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getNome().compareTo(f2.getNome());
            }
        });
        for (Funcionario f : copia) {
            System.out.println(f.getNome());
        }
    }
    //somar salários
    public static BigDecimal somarSalarios(List<Funcionario> funcionarios) {
        BigDecimal soma = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            soma = soma.add(f.getSalario());
        }
        return soma;
    }
    //relação de salários em comparação com o salário mínimo (1.212,00)
    public static void salariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        for (Funcionario f : funcionarios) {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos.");
        }
    }
    //retorna idade
    public static int idade(Funcionario f){
        return Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
    }
}

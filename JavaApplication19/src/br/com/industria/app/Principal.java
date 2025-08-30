/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.industria.app;

import br.com.industria.model.Funcionario;
import br.com.industria.service.FuncionarioService;
import br.com.industria.util.Formatador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("1917.47"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2967.88"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        System.out.println("--- Lista Inicial ---");
        FuncionarioService.listarFuncionarios(funcionarios);

        //remover funcionário João
        FuncionarioService.removerFuncionario(funcionarios, "João");

        System.out.println("\n=== Após Remover João ===");
        FuncionarioService.listarFuncionarios(funcionarios);

        //aplicar aumento de 10%
        FuncionarioService.aplicarAumento(funcionarios, new BigDecimal("0.10"));

        System.out.println("\n=== Após Aumento de 10% ===");
        FuncionarioService.listarFuncionarios(funcionarios);

        //agrupar por função
        Map<String, List<Funcionario>> agrupados = FuncionarioService.agruparPorFuncao(funcionarios);
        System.out.println("\n=== Agrupados por Função ===");
        agrupados.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            FuncionarioService.listarFuncionarios(lista);
        });
        //aniversariantes de outubro e dezembro
        System.out.println("\n=== Aniversariantes em Outubro e Dezembro ===");
        FuncionarioService.aniversariantes(funcionarios, 10, 12);
        
        //mais velho
        Funcionario maisVelho = FuncionarioService.maisVelho(funcionarios);
        System.out.println("\n===Funcionário mais velho: " + maisVelho.getNome() + " "
                + "(" + FuncionarioService.idade(maisVelho) + " anos)");

        //ordenar por nome
        System.out.println("\n=== Ordenados por Nome ===");
        FuncionarioService.ordenadosPorNome(funcionarios);

        //soma dos salários
        BigDecimal somaSalarios = FuncionarioService.somarSalarios(funcionarios);
        System.out.println("\nSoma dos salários: " + Formatador.formatarSalario(somaSalarios));

        //salários em relação ao mínimo (considerando 1.212,00)
        System.out.println("\n=== Salários em salários mínimos ===");
        FuncionarioService.salariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}
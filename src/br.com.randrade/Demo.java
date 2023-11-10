package br.com.randrade;

import br.com.randrade.entities.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        //LISTA PARA ARMAZENAR OS USUÁRIOS
        List<Pessoa> pessoas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        boolean fluxo = true;

        //FLUXO CRIADO PARA QUESTIONAR SE O USUÁRIO DESEJA CONTINUAR ADICIONANDO PESSOAS NA LISTA
        while (fluxo) {
            System.out.println("Deseja adicionar uma pessoa na lista? [S/N] ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("N")) {
                fluxo = false;
                break;
            }

            System.out.println("Digite o nome: ");
            String nome = sc.nextLine();


            System.out.println("Digite o sexo [Masculino/Feminino]: ");
            String sexo = sc.nextLine();

            Pessoa novaPessoa = new Pessoa(nome, sexo);
            pessoas.add(novaPessoa);
        }
        sc.close();

        //SEPARANDO SOMENTE AS MULHERES E IMPRIMINADO NO CONSOLE UTILIZANDO LAMBDAS EXPRESSIONS
        boolean naoPossuiMulheres = pessoas.stream()
                .noneMatch(pessoa -> pessoa.getSexo().equalsIgnoreCase("Feminino"));

        if (naoPossuiMulheres) {
            System.out.println("NÃO POSSUEM MULHERES NA LISTA!");
        } else {
            System.out.println("***AS PESSOAS NA LISTA DO SEXO FEMININO SÃO: *****");
            pessoas.stream()
                    .filter(pessoa -> pessoa.getSexo().equalsIgnoreCase("Feminino"))
                    .forEach(pessoa -> System.out.println(pessoa.getNome()));

        }
    }

    public boolean somenteMulheres(Pessoa pessoa) {
        return false;
    }

}
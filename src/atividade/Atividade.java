/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;

import Model.Aluno;
import Model.Diario;
import Model.Exame;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.zanghelini
 */
public class Atividade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Diario diario = new Diario("Português");        
        Scanner reader = new Scanner(System.in);
        
        int opcao;
        do{
            System.out.println("Menu");            
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar exame");
            System.out.println("3 - Exibir média de aluno");
            System.out.println("4 - Exibir média da classe");
            opcao = reader.nextInt();
            
            switch (opcao) {
                case 1:
                    {
                        Aluno aluno = new Aluno();
                        System.out.println("Nome:");
                        String nome = reader.next();
                        aluno.setNome(nome);
                        System.out.println("Matricula:");
                        int matr = reader.nextInt();
                        aluno.setMatricula(matr);
                        System.out.println("Nascimento: dd/MM/yyyy");
                        String nasc = reader.next();
                        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                        Date dt = new Date();
                        try {
                            dt = date.parse(nasc);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        aluno.setDataNascimento(dt);
                        diario.addAluno(aluno);
                        break;
                    }
                case 2:
                    {
                        Exame exame = new Exame();
                        System.out.println("Aluno:");
                        int matricula = reader.nextInt();
                        exame.setAluno(diario.getAluno(matricula));
                        System.out.println("Data:");
                        String data = reader.next();
                        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                        Date dt = new Date();
                        try {
                            dt = date.parse(data);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }       exame.setData(dt);
                        System.out.println("Nota:");
                        double nota = reader.nextDouble();
                        exame.setNota(nota);
                        diario.addExame(exame);
                        break;
                    }
                case 3:
                    {
                        System.out.println("Matricula:");
                        int matr = reader.nextInt();
                        Aluno aluno = diario.getAluno(matr);
                        ArrayList<Double> notas = diario.getNotasAluno(matr);
                        Double total = 0.0;
                        for(Double nota : notas){
                            total += nota;
                        }       Double media = total/notas.size();
                        System.out.println("Média desse aluno: " + media);
                        break;
                    }
                case 4:
                    HashMap<Integer, Aluno> map = diario.getAlunos();
                    Set<Integer> matriculas = map.keySet();
                    // Iterating over values only
                    Double totalClasse = 0.0;
                    for (Integer matricula : matriculas) {
                        ArrayList<Double> notasAluno = diario.getNotasAluno(matricula);
                        for(Double notaAluno : notasAluno){
                            totalClasse += notaAluno;
                        }
                    }   Double mediaClasse = totalClasse/matriculas.size();
                    System.out.println("A média da classe é: " + mediaClasse);
                    break;
                default:
                    break;
            }
            
        }while(opcao != 0);
    }
    
}

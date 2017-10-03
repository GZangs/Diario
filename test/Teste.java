/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabriel.zanghelini
 */
public class Teste {
    
    Scanner reader = new Scanner(System.in);
    Diario diario = new Diario("Teste");
    Aluno aluno = new Aluno();
    @Test
    public void testCadastrodeAlunos(){        
        aluno.setNome("Jeferson");
        aluno.setMatricula(01);
        String nasc = "27/02/1998";
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        try {
            dt = date.parse(nasc);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        aluno.setDataNascimento(dt);
        diario.addAluno(aluno);
        
        assertEquals(diario.getAluno(01), aluno);
    }


//    @Test
//    public void testCadastrodeExames(){
//        Diario diario = new Diario("Teste");
//        Exame exame = new Exame();        
//        exame.setAluno(diario.getAluno(01));
//        exame.setNota(10.0);
//        String nasc = "02/10/2017";
//        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//        Date dt = new Date();
//        try {
//            dt = date.parse(nasc);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        exame.setData(dt);
//        diario.addExame(exame);
//        
//        Aluno aluno1 = diario.getAluno(01);
//        assertEquals(aluno1, exame);
//    }
    
    @Test
    public void testMediadoAluno(){
        double notadoAluno = 10.0;
        Exame exame = new Exame();
        exame.setNota(10.0);        
        String data = "02/10/2017";
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        try {
            dt = date.parse(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        exame.setData(dt);            
        exame.setAluno(aluno);
        diario.addExame(exame);
        
        assertEquals(diario.getNotasAluno(01), notadoAluno);
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

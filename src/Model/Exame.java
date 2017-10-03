/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author gabriel.zanghelini
 */
public class Exame {
    private Aluno Aluno;
    private Date Data;
    private double Nota;

    public Exame(){}
    
    public Exame(Aluno Aluno, Date Data, double Nota) {
        this.Aluno = Aluno;
        this.Data = Data;
        this.Nota = Nota;
    }
    
    public Aluno getAluno() {
        return Aluno;
    }

    public void setAluno(Aluno Aluno) {
        this.Aluno = Aluno;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }
    
    
}

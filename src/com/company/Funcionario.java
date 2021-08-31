package com.company;

import java.text.DecimalFormat;
import java.util.Formatter;

public class Funcionario {

    private int codigo;
    private String nome;
    private String turno;
    private String cargo;
    private double horasTrabalhadas;
    private double valorHoraTrabalhada;
    private double salarioInical;
    private double auxilioAlimentacao;
    private double salarioFinal;

    public String getNome() {
        return nome;
    }

    public Funcionario(int codigo, String nome, String turno, String cargo, double horasTrabalhadas, double salarioBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.turno = turno;
        this.cargo = cargo;
        this.horasTrabalhadas = horasTrabalhadas;
        calculaValorHorasTrabalhadas(salarioBase);
        calculaSalarioInical();
        calculaAuxilioAlimentacao();
        calculaSalarioFinal();
    }

    public String getTurno() {
        return turno;
    }

    public String getCargo() {
        return cargo;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getValorHoraTrabalhada() {
        return this.valorHoraTrabalhada;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getSalarioInical() {
        return salarioInical;
    }

    public double getAuxilioAlimentacao() {
        return auxilioAlimentacao;
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void calculaValorHorasTrabalhadas(double salarioBase) {

        if(this.cargo.equals("G") && this.turno.equals("N")) {
            this.valorHoraTrabalhada = salarioBase * 0.16;
        } else if(this.cargo.equals("G") && (this.turno.equals("M") || this.turno.equals("V"))) {
            this.valorHoraTrabalhada = salarioBase * 0.14;
        } else if(this.cargo.equals("O") && this.turno.equals("N")) {
            this.valorHoraTrabalhada = salarioBase * 0.12;
        } else {
            this.valorHoraTrabalhada = salarioBase * 0.10;
        }

    }

    public void calculaSalarioInical() {
        this.salarioInical = valorHoraTrabalhada * horasTrabalhadas;
    }

    public void calculaAuxilioAlimentacao() {
        if(this.salarioInical <= 800) {
            this.auxilioAlimentacao = salarioInical * 0.15;
        } else if(this.salarioInical > 800 && this.salarioInical <= 1500) {
            this.auxilioAlimentacao = salarioInical * 0.10;
        } else {
            this.auxilioAlimentacao = salarioInical * 0.05;
        }
    }

    public void calculaSalarioFinal() {
        this.salarioFinal = this.salarioInical + this.auxilioAlimentacao;
    }

}

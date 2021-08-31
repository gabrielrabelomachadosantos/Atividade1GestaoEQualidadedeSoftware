package com.company;

import java.util.ArrayList;

public class CalcularFolhaDePagamento {

    private double salarioInicialTotal;
    private double auxilioAlimentacaoTotal;
    private double salarioFinalTotal;

    public double calculaSalarioInicialTotal(ArmazenaFuncionarios armazenaFuncionarios) {
        for(int i = 0; i < armazenaFuncionarios.getListaFuncionario().size(); i++) {
            this.salarioInicialTotal += armazenaFuncionarios.getListaFuncionario().get(i).getSalarioInical();
        }

        return this.salarioInicialTotal;
    }

    public double calculaAuxilioAlimentacaoTotal(ArmazenaFuncionarios armazenaFuncionarios) {
        for(int i = 0; i < armazenaFuncionarios.getListaFuncionario().size(); i++) {
            this.auxilioAlimentacaoTotal += armazenaFuncionarios.getListaFuncionario().get(i).getAuxilioAlimentacao();
        }

        return this.auxilioAlimentacaoTotal;
    }

    public double calculaSalarioFinalTotal(ArmazenaFuncionarios armazenaFuncionarios) {
        for(int i = 0; i < armazenaFuncionarios.getListaFuncionario().size(); i++) {
            this.salarioFinalTotal += armazenaFuncionarios.getListaFuncionario().get(i).getSalarioFinal();
        }

        return this.salarioFinalTotal;
    }

}

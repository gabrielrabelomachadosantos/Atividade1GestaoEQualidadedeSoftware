package com.company;

import java.util.ArrayList;

public class ArmazenaFuncionarios {

    private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(Funcionario funcionario) {
        listaFuncionario.add(funcionario);
    }

}

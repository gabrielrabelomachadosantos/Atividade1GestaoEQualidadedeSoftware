package com.company;

import java.util.Scanner;

public class CadastrarFuncionario {

    Scanner in = new Scanner(System.in);

    public String cadastrarNomeFuncionario() {

        System.out.print("Digite o nome do funcionário: ");
        String nome = in.nextLine();

        return nome;
    }

    public String cadastrarTurnoFuncionario() {

        System.out.print("Digite o turno (M — matutino, V — vespertino ou N — noturno): ");
        String turno = in.nextLine();
        turno = turno.toUpperCase();
        while (!(turno.equals("M") || turno.equals("V") || turno.equals("N"))) {
            System.out.print("Opção de turno inválida. Digite novamente: ");
            turno = in.nextLine();
            turno = turno.toUpperCase();
        }

        return turno;
    }

    public String cadastrarCargoFuncionario() {

        System.out.print("Digite o cargo (O — operário ou G — gerente): ");
        String cargo = in.nextLine();
        cargo = cargo.toUpperCase();
        while (!(cargo.equals("O") || cargo.equals("G"))) {
            System.out.print("Opção de cargo inválida. Digite novamente: ");
            cargo = in.nextLine();
            cargo = cargo.toUpperCase();
        }

        return cargo;
    }

    public double cadastrarTotalHorasTrabalhadas() {

        System.out.print("Digite o total horas trabalhadas: ");
        double horasTrabalhadas = in.nextDouble();

        return horasTrabalhadas;
    }

}

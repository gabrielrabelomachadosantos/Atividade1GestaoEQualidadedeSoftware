package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bem vindo!");

        int codigoGeradoFuncionario = 200;

        ArmazenaFuncionarios armazenaFuncionarios = new ArmazenaFuncionarios();

        Scanner in = new Scanner(System.in);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        int continuarPrograma = 0;

        double salarioBase = 300;

        menu();

        while (continuarPrograma < 5) {

            try {
                continuarPrograma = in.nextInt();
            } catch (Exception exception) {
                System.out.println("");
                System.out.print("Você não digitou uma opção disponível. Tente novamente: ");
                in.nextLine();
                continuarPrograma = 0;
                continue;
            }

            switch (continuarPrograma) {
                case 1:

                    CadastrarFuncionario cadastrarFuncionario = new CadastrarFuncionario();

                    String nome = cadastrarFuncionario.cadastrarNomeFuncionario();
                    String cargo = cadastrarFuncionario.cadastrarCargoFuncionario();
                    String turno = cadastrarFuncionario.cadastrarTurnoFuncionario();
                    double horasTrabalhadas = cadastrarFuncionario.cadastrarTotalHorasTrabalhadas();

                    armazenaFuncionarios.setListaFuncionario(new Funcionario(codigoGeradoFuncionario, nome, turno, cargo, horasTrabalhadas, salarioBase));

                    codigoGeradoFuncionario++;

                    System.out.println("Funcionário cadastrado com sucesso!!!");

                    menu();

                    break;

                case 2:

                    if (armazenaFuncionarios.getListaFuncionario() != null) {
                        System.out.println("Codigo | Nome | Cargo | Turno | Horas Trabalahdas | Valor Hora Trabalhada | Salario Inicial | Auxílio Alimentação | Salário Final");
                        System.out.println("");
                        for (int i = 0; i < armazenaFuncionarios.getListaFuncionario().size(); i++) {
                            System.out.println(armazenaFuncionarios.getListaFuncionario().get(i).getCodigo() + " | "
                                                + armazenaFuncionarios.getListaFuncionario().get(i).getNome() + " | "
                                                + armazenaFuncionarios.getListaFuncionario().get(i).getCargo() + " | "
                                                + armazenaFuncionarios.getListaFuncionario().get(i).getTurno() + " | "
                                                + armazenaFuncionarios.getListaFuncionario().get(i).getHorasTrabalhadas() + " | "
                                                + decimalFormat.format(armazenaFuncionarios.getListaFuncionario().get(i).getValorHoraTrabalhada()) + " | "
                                                + decimalFormat.format(armazenaFuncionarios.getListaFuncionario().get(i).getSalarioInical()) + " | "
                                                + decimalFormat.format(armazenaFuncionarios.getListaFuncionario().get(i).getAuxilioAlimentacao()) + " | "
                                                + decimalFormat.format(armazenaFuncionarios.getListaFuncionario().get(i).getSalarioFinal()));
                        }
                    } else {
                        System.out.println("Você não possui nenhum funcionario cadastrado.");
                    }

                    menu();

                    break;

                case 3:

                    CalcularFolhaDePagamento calcularFolhaDePagamento = new CalcularFolhaDePagamento();

                    System.out.println("Salário Inicial Total | Auxílio Alimentação Total | Salário Final Total");
                    System.out.println(decimalFormat.format(calcularFolhaDePagamento.calculaSalarioInicialTotal(armazenaFuncionarios)) + " | "
                                        + decimalFormat.format(calcularFolhaDePagamento.calculaAuxilioAlimentacaoTotal(armazenaFuncionarios)) + " | "
                                        + decimalFormat.format(calcularFolhaDePagamento.calculaSalarioFinalTotal(armazenaFuncionarios)));

                    menu();

                    break;

                case 4:

                    System.out.print("Digite o novo salário base: ");
                    salarioBase = in.nextDouble();
                    System.out.println("Salário base alterado com sucesso.");
                    for (int i = 0; i < armazenaFuncionarios.getListaFuncionario().size(); i++) {
                        armazenaFuncionarios.getListaFuncionario().get(i).calculaValorHorasTrabalhadas(salarioBase);
                        armazenaFuncionarios.getListaFuncionario().get(i).calculaSalarioInical();
                        armazenaFuncionarios.getListaFuncionario().get(i).calculaAuxilioAlimentacao();
                        armazenaFuncionarios.getListaFuncionario().get(i).calculaSalarioFinal();
                    }
                    System.out.println("O salário inicial, final e auxílio alimentação dos funcionários já cadastrados também foi ajustado.");

                    menu();

                    break;

                case 5:

                    System.out.println("Obrigado por utilizar nosso sistema!");
                    System.out.close();

            }

        }

    }

    public static void menu() {
        System.out.println("");
        System.out.println("Digite 1 para cadastrar funcionário.");
        System.out.println("Digite 2 para listar funcionários.");
        System.out.println("Digite 3 para gerar folha de pagamento.");
        System.out.println("Digite 4 para alterar salário base.");
        System.out.println("Digite 5 para encerrar o programa.");
    }

}

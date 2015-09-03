/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author matheus.ssouza1
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    static Scanner tc = new Scanner(System.in);
    static int disp = 10;

    static void IncluirNumero(String agenda[][], String nome, String numero) {

        boolean validarNumero = false,validarnome= false;
        int indice = 0;
        System.out.println("Digite o nome que vai adicionar");
        nome = tc.next();
        for (int i = 0; i < agenda.length; i++) {
            for (int j = 0; j < agenda[i].length; j++) {
                if (agenda[i][0] == null) {
                    agenda[i][0] = nome;
                    validarnome =true;
                    indice = i;
                    break;
                }
                
            }
            if (validarnome) {
                break;
            }
        }
        

        do {
            System.out.println("Digite o novo numero");
            numero = tc.next();
            for (int i = 0; i < agenda.length; i++) {
                for (int j = 0; j < agenda[i].length; j++) {
                    if (numero.equalsIgnoreCase(agenda[i][1])) {
                        validarNumero = false;
                        System.out.println("Este numero ja existe em outro contato, tente outro");
                        break;

                    }
                }

            }
        } while (validarNumero);
        disp--;
        agenda[indice][1] = numero;

    }// inclui dados

    static void AlterarAgenda(String agenda[][], String nome, String numero) {
        System.out.println("Quer alterar nome (1) ou numero (2)");
        int ops = tc.nextInt();
        int indice = 0;
        String nomeAlterado;
        boolean nomeEncontrado = false, validarNumero = false;

        switch (ops) {
// altera o nome 
            case 1:
                System.out.println("Qual nome deseja alterar");
                nome = tc.next();
                for (int i = 0; i < agenda.length; i++) {
                    for (int j = 0; j < agenda[i].length; j++) {
                        if (nome.equalsIgnoreCase(agenda[i][0])) {
                            nomeEncontrado = true;
                            indice = i;
                            break;
                        }
                    }
                }
                if (nomeEncontrado) {
                    System.out.println("Digite o novo nome");
                    nomeAlterado = tc.next();
                    agenda[indice][0] = nomeAlterado;
                    System.out.println("O nome foi alterado para " + nomeAlterado);
                    break;
                } else {
                    System.out.println(" o nome não foi encontrado");
                }
                break;
// aletra o numero 
            case 2:
                System.out.println("Escolha o nome de quem quer alterar o numero");
                nome = tc.next();
                for (int i = 0; i < agenda.length; i++) {
                    for (int j = 0; j < agenda[i].length; j++) {
                        if (nome.equalsIgnoreCase(agenda[i][0])) {
                            nomeEncontrado = true;
                            indice = i;
                            break;
                        }
                    }
                }
                if (nomeEncontrado) {

                    do {
                        System.out.println("Digite o novo numero");
                        numero = tc.next();
                        for (int i = 0; i < agenda.length; i++) {
                            for (int j = 0; j < agenda[i].length; j++) {
                                if (numero.equalsIgnoreCase(agenda[i][1])) {
                                    validarNumero = false;
                                    System.out.println("Este numero ja existe em outro contato, tente outro");
                                    break;

                                }
                            }

                        }

                    } while (validarNumero);

                    agenda[indice][1] = numero;
                    System.out.println("O numero foi alterado para " + numero);
                } else {
                    System.out.println(" o nome não foi encontrado");
                }

        }

    }// altera dados

    static void PesquidaDados(String agenda[][], String nome, String numero) {
        System.out.println("Digite o nome ou o numero que deseja pesquisar");
        String pesquisa = tc.next();
        int nomeTel = 0, indice = 0;

        boolean encontrado = false;
        for (int i = 0; i < agenda.length; i++) {
            for (int j = 0; j < agenda[i].length; j++) {
                if (pesquisa.equalsIgnoreCase(agenda[i][j])) {
                    encontrado = true;
                    indice = i;
                    if (j == 1) {
                        nomeTel = j;
                    }
                    break;

                }
            }
        }
        if (encontrado && nomeTel == 0) {
            System.out.println("O nome " + pesquisa + " foi encontrado, seu numero é " + agenda[indice][1]);
        } else if (encontrado && nomeTel == 1) {
            System.out.println("O numero " + pesquisa + " foi encontrado, seu nome é " + agenda[indice][0]);
        } else {
            System.out.println("Não foi encontrado nome ou numero pesquisado");
        }

    }// pesquisa nome e numero

    // remove contato     
    static String[][] RemoveContato(String agenda[][], String nome, String numero) {

        System.out.println("Digite o nome ou o numero que deseja remover");
        String pesquisa = tc.next();
        int nomeTel = 0, indice = 0;
        String agendaLimpa[][] = new String[10][2];
        boolean encontrado = false;
        for (int i = 0; i < agenda.length; i++) {
            for (int j = 0; j < agenda[i].length; j++) {
                if (pesquisa.equalsIgnoreCase(agenda[i][j])) {
                    encontrado = true;
                    indice = i;
                    if (j == 1) {
                        nomeTel = j;
                    }
                    break;

                }
                
            }
        }
        if (encontrado) {
            System.out.println("O nome " + agenda[indice][0] + " e o numero " + agenda[indice][1] + " foram apagados");
            agenda[indice][0] = null;
            agenda[indice][1] = null;
            disp++;
            for (int i = 0; i < agendaLimpa.length; i++) {
                for (int j = 0; j < agendaLimpa[i].length; j++) {
                    if (agenda[i][0] != null) {
                        agendaLimpa[i][0] = agenda[i][0];
                        agendaLimpa[i][1] = agenda[i][1];
                    }
                }
            }

        } else {
            System.out.println("Não foi encontrado nome ou numero para apagar ");
        }

        return agendaLimpa;
    }

    // mostra agenda  
    static void MostrarContatos(String agenda[][], String nome, String numero) {
        boolean listaVazia = false;
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i][0] != null) {
                listaVazia = true;
                break;

            }

        }
        if (listaVazia) {
            for (int i = 0; i < agenda.length; i++) {
                for (int j = 0; j < agenda[i].length; j++) {
                    if (agenda[i][j]!= null) {
                        System.out.println(agenda[i][j]);

                    }
                }

            }
        } else {
            System.out.println("A lista esta vazia ");
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        String agenda[][] = new String[10][2];
        String fim, nome = null, numero = null;
        do {
            System.out.println("1 Incluir um Contato");
            System.out.println("2 Alterar os dados");
            System.out.println("3 Pesquisar um Contato");
            System.out.println("4 Remover um Contato");
            System.out.println("5 Listar todos os Contatos");
            System.out.println("0 Sair da Agenda");
            System.out.println("");
            System.out.println("Voce tem " + disp + " posições para adicionar");
            fim = tc.next();
            switch (fim) {
                case "1":
                    IncluirNumero(agenda, nome, numero);

                    break;
                case "2":
                    AlterarAgenda(agenda, nome, numero);
                    break;
                case "3":
                    PesquidaDados(agenda, nome, numero);
                    break;
                case "4":
                    RemoveContato(agenda, nome, numero);
                    break;
                case "5":
                    MostrarContatos(agenda, nome, numero);
                    break;
                case "0":
                    fim = "0";
                    break;

            }

        } while (fim != "0");
    }

}

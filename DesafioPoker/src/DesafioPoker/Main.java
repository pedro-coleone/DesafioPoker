/*
Desafio do módulo de Lógica de programação 1 do curso Santander Coders | Automação de Testes
Autor: Pedro Coleone
Professor: Thalles Trevizan
*/
package DesafioPoker;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.embaralha();

        System.out.print("Olá! Informe quantos jogadores existem na mesa: ");
        Scanner scanner = new Scanner(System.in);
        int nJogadores = scanner.nextInt();
        try {
            if(nJogadores <= 1){
                throw new IllegalArgumentException();
            }
            System.out.println("JOGADORES NA MESA:");
            for (int i = 0; i < nJogadores; i++) {
                System.out.print("Jogador (" + (i + 1) + "): ");
                baralho.imprimeCartas(i * 2, 2);
            }
            System.out.println();

            // APOSTA OU ABANDONA
            boolean[] verificaAbandono = new boolean[26];
            Arrays.fill(verificaAbandono, false);
            double apostaAtual = 0;
            double[] valor = new double[26];
            int jogadoresValidos = 0, abandonos = 0;
            for (int i = 0; jogadoresValidos != nJogadores; i++) {
                if (i >= nJogadores) {
                    i = 0;
                }
                if (!verificaAbandono[i]) {
                    System.out.print("Jogador (" + (i + 1) + "), digite 1 para APOSTAR ou 2 para ABANDONAR a mão: ");
                    int escolha = scanner.nextInt();
                    if (escolha == 1) {
                        System.out.print("Insira o valor total da sua aposta nesta rodada: ");
                        valor[i] = scanner.nextDouble();
                        while (valor[i] < apostaAtual) {
                            System.out.print("Por favor, insira um valor maior ou igual à " + apostaAtual + ": ");
                            valor[i] = scanner.nextDouble();
                        }
                        if (valor[i] == apostaAtual) {
                            System.out.println("\n=================== APOSTA MANTIDA EM " + apostaAtual + " ===================");
                            jogadoresValidos++;
                        } else {
                            System.out.println("\n================= APOSTA AUMENTADA PARA " + valor[i] + " =================");
                            jogadoresValidos = 1 + abandonos;
                            apostaAtual = valor[i];
                        }

                    } else if (escolha == 2) {
                        System.out.println("\n============= JOGADOR NÚMERO (" + (i + 1) + ") ABANDONOU A MESA =============");
                        System.out.println("JOGADORES NA MESA:");
                        baralho.retiraPar(i * 2);
                        verificaAbandono[i] = true;
                        jogadoresValidos++;
                        abandonos++;
                        for (int j = 0; j < nJogadores; j++) {
                            if (!verificaAbandono[j]) {
                                System.out.print("Jogador número (" + (j + 1) + "): ");
                                baralho.imprimeCartas(j * 2, 2);
                            }
                        }
                    } else {
                        i--;
                    }
                }
            }
            // FIM DE JOGO
            System.out.println("====================== VIRANDO 5 CARTAS =======================");
            baralho.imprimeCartas(nJogadores * 2, 5);
            System.out.println("\n⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");
            System.out.print("Segundo a configuração das carta acima,\ndigite o número do jogador ganhador: ");
            int ganhador = scanner.nextInt();
            System.out.println("\n💸💰💵🪙🤑💸💰💵🪙🤑💸💰💵🪙🤑💸💰💵🪙🤑💸💰💵🪙🤑💸💰💵");
            System.out.println("🤑PARABÉNS JOGADOR NÚMERO (" + ganhador + "), VOCÊ GANHOU O TOTAL DE " + baralho.somaApostas(valor) + "!!💸");
            System.out.println("💵🤑💵🪙💸💰💵🤑💵🪙💸💰💵🤑💵🪙💸💰💵🤑💵🪙💸💰💵🤑💵🪙");
        }
        catch (IllegalArgumentException e){
            System.err.println("Número de jogadores deve ser maior do que 1.");
        }
    }
}
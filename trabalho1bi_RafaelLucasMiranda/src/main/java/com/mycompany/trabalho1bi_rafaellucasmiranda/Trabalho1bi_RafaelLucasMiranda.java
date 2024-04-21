package com.mycompany.trabalho1bi_rafaellucasmiranda;

import java.util.Scanner;


public class Trabalho1bi_RafaelLucasMiranda {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o tamanho do vetor:");
            int tamanho = scanner.nextInt();
            
            int[] vetor = new int[tamanho];
            
           
            System.out.println("Digite os numeros desejados:");
            for (int i = 0; i < tamanho; i++) {
                vetor[i] = scanner.nextInt();
            }
            
            
            exibirMenu(vetor);
        }
        
    }

    public static void exibirMenu(int[] vetor) {
        Scanner scanner = new Scanner(System.in);
        Ordenacao ordenacao = new Ordenacao();

        while (true) {
            
            System.out.println("\nEscolha o método de ordenação:");
            System.out.println("1. Ordenação por inserção");
            System.out.println("2. Ordenação por seleção");
            System.out.println("3. Ordenação por bolha");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    
                    int[] vetorInsercao = vetor.clone();
                    long inicioInsercao = System.nanoTime();
                    ordenacao.insercao(vetorInsercao);
                    long finalInsercao = System.nanoTime();
                    Resultado(vetorInsercao, "Ordenação por Inserção", finalInsercao - inicioInsercao);
                    break;
                case 2:
                    
                    int[] vetorSelecao = vetor.clone();
                    long inicioSelecao = System.nanoTime();
                    ordenacao.selecao(vetorSelecao);
                    long finalSelecao = System.nanoTime();
                    Resultado(vetorSelecao, "Ordenação por Seleção", finalSelecao - inicioSelecao);
                    break;
                case 3:
                    
                    int[] vetorBolha = vetor.clone();
                    long inicioBolha = System.nanoTime();
                    ordenacao.bolha(vetorBolha);
                    long finalBolha = System.nanoTime();
                    Resultado(vetorBolha, "Ordenação Bolha", finalBolha - inicioBolha);
                    break;
                case 4:
                    
                    System.out.println("Saindo!!!");
                    scanner.close();
                    System.exit(0);
                default:
                    
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void Resultado(int[] vetorOrdenado, String metodo, long tempo) {
        System.out.println("\nMétodo de ordenação: " + metodo);
        System.out.println("Vetor ordenado:");
        for (int num : vetorOrdenado) {
            System.out.print(num + " ");
        }
        System.out.println("\nTempo de execução: " + tempo + " nanossegundos");
    }
}

class Ordenacao {
    
    public void insercao(int[] vetor) {
        int n = vetor.length;
        for (int i = 1; i < n; ++i) {
            int inser = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > inser) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = inser;
        }
    }

    public void selecao(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int sel = i;
            for (int j = i + 1; j < n; j++)
                if (vetor[j] < vetor[sel])
                    sel = j;

            int ordena = vetor[sel];
            vetor[sel] = vetor[i];
            vetor[i] = ordena;
        }
    }

    public void bolha(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (vetor[j] > vetor[j + 1]) {
                    int bol = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = bol;
                }
    }
}

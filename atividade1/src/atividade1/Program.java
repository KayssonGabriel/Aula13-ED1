package atividade1;

// Criar uma aplicação para gerar 1000 números aleatórios de-9999 a 9999 e armazená-los num vetor de 1000 posições.Faça a impressão desses números na sua ordem
// de geração.Crie uma lista duplamente encadeada e vá inserindo os números presentes no vetor na lista encadeada.Porém cada número deverá ser colocado na sua 
// posição correta na lista duplamente encadeada,ou seja,serão inseridos em ordem crescente na lista.Imprima lista em ordem crescente e depois em ordem 
// decrescente.O vetor deve ser percorrido(o vetor não deve ser ordenado),e o número será inserido na posição correta na lista
// posteriormente remova todos os números primos da lista e faça a impressão novamente da lista

import java.util.Random;

public class Program {

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();

		Random random = new Random();
		int[] vetor = new int[1000];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = random.nextInt(9999 - (-9999) + 1) + (-9999);
		}

		System.out.print("Vetor: [");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + ", ");
		}
		System.out.println("]");

		for (int i = 0; i < vetor.length; i++) {
			lista.ordenarCrescente(vetor[i]);

		}
		System.out.println();
		System.out.println("Ordem crescente: " + lista.imprimir());
		lista.inverterLista();
		System.out.println();
		System.out.println("Ordem decrescente: " + lista.imprimir());
		lista.removerPrimos();
		System.out.println();
		System.out.println("Lista sem números primos: " + lista.imprimir());

	}

}

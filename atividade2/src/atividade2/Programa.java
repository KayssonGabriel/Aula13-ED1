package atividade2;

import java.util.Random;

public class Programa {
	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();

		Random random = new Random();

		for (int i = 0; i < 51000000; i++) {
			int numeroSorteado = random.nextInt(60) + 1;
			lista.adicionaNoFinal(numeroSorteado);
		}

		lista.encontrarSequenciaDireta();
		System.out.println();
		System.out.println("==================================");
		System.out.println();
		lista.encontrarSequenciaInversa();

	}
}

package atividade2;

import java.util.Random;

public class Programa {
	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();

		Random random = new Random();

		int quantidade = args.length == 0 ? 51_000_000 : Integer.parseInt(args[0]);
		if (quantidade < 0) {
			throw new IllegalArgumentException("A quantidade deve ser não negativa.");
		}
		for (int i = 0; i < quantidade; i++) {
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

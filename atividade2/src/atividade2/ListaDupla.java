package atividade2;

public class ListaDupla {
	Celula primeira;
	Celula ultima;
	int totalDeElementos = 0;

	public void encontrarSequenciaDireta() {
		int[] vetor = { 1, 15, 16, 25, 32, 36 };
		int quantidadeDeSequencias = 0;
		int[] vetorPosicao = null;

		System.out.println("Direta: ");

		for (int i = 0; i < tamanho() - 1; i++) {

			if (pegaElemento(i) == vetor[0]) {
				i++;
				if (pegaElemento(i) == vetor[1]) {
					i++;
					if (pegaElemento(i) == vetor[2]) {
						i++;
						if (pegaElemento(i) == vetor[3]) {
							i++;
							if (pegaElemento(i) == vetor[4]) {
								i++;
								if (pegaElemento(i) == vetor[5]) {
									quantidadeDeSequencias++;
									vetorPosicao = new int[] { i - 5, i - 4, i - 3, i - 2, i - 1, i };
									i++;
								} else {
									i--;
								}
								if (quantidadeDeSequencias > 0) {
									System.out.println();
									System.out.println(quantidadeDeSequencias + "º sequencia: ");
									for (int j = 0; j < vetorPosicao.length; j++) {
										System.out.print(vetorPosicao[j] + " ");
									}
									System.out.println();
								}
							} else {
								i--;
							}
						} else {
							i--;
						}
					} else {
						i--;
					}
				} else {
					i--;
				}
			}

		}
		System.out.println();
		System.out.println("Quantidade de Sequencias = " + quantidadeDeSequencias);
	}

	public void encontrarSequenciaInversa() {
		int[] vetor = { 1, 15, 16, 25, 32, 36 };
		int quantidadeDeSequencias = 0;
		int[] vetorPosicao = null;

		System.out.println("Inversa: ");

		for (int i = tamanho() - 1; i > 0; i--) {
			if (pegaElemento(i) == vetor[0]) {
				i--;
				if (pegaElemento(i) == vetor[1]) {
					i--;
					if (pegaElemento(i) == vetor[2]) {
						i--;
						if (pegaElemento(i) == vetor[3]) {
							i--;
							if (pegaElemento(i) == vetor[4]) {
								i--;
								if (pegaElemento(i) == vetor[5]) {
									quantidadeDeSequencias++;
									vetorPosicao = new int[] { i + 5, i + 4, i + 3, i + 2, i + 1, i };
									i--;
								}
								if (quantidadeDeSequencias > 0) {
									System.out.println();
									System.out.println(quantidadeDeSequencias + "º sequencia: ");
									for (int j = 0; j < vetorPosicao.length; j++) {
										System.out.print(vetorPosicao[j] + " ");
									}
									System.out.println();
								}
							} else {
								i++;
							}
						} else {
							i++;
						}
					} else {
						i++;
					}
				} else {
					i++;
				}
			}

		}
		System.out.println();
		System.out.println("Quantidade de Sequencias = " + quantidadeDeSequencias);
	}

	public void adicionaNoComeco(int elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}

	public void adicionaNoFinal(int elemento) {
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}

	public boolean posicaoOcupada(int pos) {
		return ((pos >= 0) && (pos < this.totalDeElementos));
	}

	public Celula pegaCelula(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe!!!");
		} else {
			Celula atual = this.primeira;
			for (int i = 0; i < pos; i++) {
				atual = atual.getProxima();
			}

			return (atual);
		}
	}

	public void adicionaNaPos(int pos, int elemento) {
		if (pos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			if (pos == this.totalDeElementos) {
				this.adicionaNoFinal(elemento);
			} else {
				Celula anterior = this.pegaCelula(pos - 1);
				Celula proxima = anterior.getProxima();
				Celula nova = new Celula(anterior.getProxima(), elemento);
				anterior.setProxima(nova);
				proxima.setAnterior(nova);
				this.totalDeElementos++;
			}
		}
	}

	public int pegaElemento(int posicao) {
		return (this.pegaCelula(posicao).getElemento());
	}

	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		} else {
			this.primeira = this.primeira.getProxima();
			this.totalDeElementos--;
			if (this.totalDeElementos == 0) {
				this.ultima = null;
			}

		}
	}

	public void removeDoFim() {
		if (!this.posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			if (this.totalDeElementos == 1) {
				this.removeDoComeco();
			} else {
				Celula penultima = this.ultima.getAnterior();
				penultima.setProxima(null);
				this.ultima = penultima;
				this.totalDeElementos--;
			}
		}
	}

	public void removePos(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		} else {
			if (pos == 0) {
				this.removeDoComeco();
			} else if (pos == this.totalDeElementos - 1) {
				this.removeDoFim();
			} else {
				Celula anterior = this.pegaCelula(pos - 1);
				Celula atual = anterior.getProxima();
				Celula proxima = atual.getProxima();
				anterior.setProxima(proxima);
				proxima.setAnterior(anterior);
				this.totalDeElementos--;
			}
		}
	}

	public boolean contemPrimeiroParaUltimo(int elemento) {
		Celula atual = this.primeira;
		while (atual != null) {
			if (atual.getElemento() == (elemento)) {
				return (true);
			}

			atual = atual.getProxima();
		}

		return (false);
	}

	public boolean contemUltimoParaPrimeiro(int elemento) {
		Celula atual = this.ultima;
		while (atual != null) {
			if (atual.getElemento() == (elemento)) {
				return (true);
			}

			atual = atual.getAnterior();
		}

		return (false);
	}

	public int tamanho() {
		return (this.totalDeElementos);
	}

	public void esvaziaLista() {
		this.primeira = null;
		this.ultima = null;
		this.totalDeElementos = 0;
	}

	public String imprimir() {
		if (this.totalDeElementos == 0) {
			return ("[]");
		} else {
			StringBuilder builder = new StringBuilder("[");
			Celula atual = this.primeira;
			for (int i = 0; i < this.totalDeElementos - 1; i++) {
				builder.append(atual.getElemento());
				builder.append(", ");
				atual = atual.getProxima();
			}
			builder.append(atual.getElemento());
			builder.append("]");
			return (builder.toString());
		}
	}

}

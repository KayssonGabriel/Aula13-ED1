package atividade1;

public class ListaDupla {
	Celula primeira;
	Celula ultima;
	int totalDeElementos = 0;

	public void ordenarCrescente(int elemento) {
		if (this.totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else if (this.totalDeElementos == 1) {
			if (pegaElemento(0) >= elemento) {
				adicionaNoComeco(elemento);
			} else {
				adicionaNoFinal(elemento);
			}
		} else {
			int indexDoMaior = 0;
			for (int i = 0; i < tamanho(); i++) {
				if (pegaElemento(i) >= elemento) {
					indexDoMaior = i;
					break;
				}
			}
			if (indexDoMaior == 0 && pegaElemento(0) >= elemento) {
				adicionaNoComeco(elemento);
			} else if (indexDoMaior == 0) {
				adicionaNoFinal(elemento);
			} else {
				adicionaNaPos((indexDoMaior), elemento);
			}
		}
	}

	public void inverterLista() {
		if (this.totalDeElementos <= 1) {
			return;
		}

		Celula atual = this.primeira;
		Celula proxima = atual.getProxima();
		atual.setProxima(null);
		atual.setAnterior(proxima);

		while (proxima != null) {
			Celula anterior = proxima.getProxima();
			proxima.setProxima(atual);
			proxima.setAnterior(anterior);

			atual = proxima;
			proxima = anterior;
		}

		this.ultima = this.primeira;
		this.primeira = atual;
	}

	public void removerPrimos() {
		for (int i = 0; i < tamanho(); i++) {
			int elementoAtual = pegaElemento(i);
			boolean primo = true;

			if (elementoAtual < 2) {
				primo = false;
			} else {
				for (int j = 2; j <= Math.sqrt(elementoAtual); j++) {
					if (elementoAtual % j == 0) {
						primo = false;
						break;
					}
				}
			}
			if (primo) {
				removePos(i);
				i--;
			}
		}
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

package atividade1;

public class Celula {
	Celula Proxima;
	Celula Anterior;
	int Elemento;

	public Celula(int elemento) {
		this.Proxima = null;
		this.Anterior = null;
		this.Elemento = elemento;
	}

	public Celula(Celula proxima, int elemento) {
		this.Proxima = proxima;
		this.Anterior = null;
		this.Elemento = elemento;
	}

	public void setProxima(Celula proxima) {
		this.Proxima = proxima;
	}

	public Celula getProxima() {
		return (this.Proxima);
	}

	public Celula getAnterior() {
		return (this.Anterior);
	}

	public void setAnterior(Celula anterior) {
		this.Anterior = anterior;
	}

	public int getElemento() {
		return (this.Elemento);
	}
}


public class Nodo {

	
	private Nodo nodoIzq=null;
	private Nodo nodoDer=null;
	private Nodo nodoPadre=null;
	private Dato dato;
	private int bit;
	private boolean procesado=false;
	
	public Nodo() {
		
	}
	public Nodo(Dato dato) {
		this.dato=dato;
	}

	
	public void setProcesado(boolean procesado) {
		this.procesado= procesado;
	}
	
	public boolean isProcesado() {
		return this.procesado;
	}
	
	public Nodo getNodoIzq() {
		return nodoIzq;
	}

	public void setNodoIzq(Nodo nodoIzq) {
		this.nodoIzq = nodoIzq;
	}

	public Nodo getNodoDer() {
		return nodoDer;
	}

	public void setNodoDer(Nodo nodoDer) {
		this.nodoDer = nodoDer;
	}

	public Nodo getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(Nodo nodoPadre) {
		this.nodoPadre = nodoPadre;
	}

	
	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}
	
	public Dato getDato() {
		return dato;
	}
	
	public void setDato(Dato dato) {
		this.dato=dato;
	}
	
	
	
	
	
	
	
}

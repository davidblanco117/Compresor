
public class Dato {

	private char caracter;
	private int frecuencia=0;
	
	public Dato() {
		
	}	
	public Dato(char c) {
		this.caracter=c;
		this.frecuencia++;
	}
	
	protected void aumentarFrecuencia() {
		this.frecuencia++;
	}
	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

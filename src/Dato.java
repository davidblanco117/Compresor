
public class Dato {

	private char caracter;
	private int frecuencia=0;
	private boolean finDeArchivo=false;

	public Dato() {
		
	}	
        public void setFinDeArchivo( boolean valor){
                this.finDeArchivo=valor;
        }

        public boolean isFinDeArchivo (){
                return this.finDeArchivo;
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

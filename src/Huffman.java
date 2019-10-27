import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Huffman {

	private ArrayList<Dato> alfabeto;
	private ArrayList<Nodo> arbol;
	private File archivo;

	public Huffman(File file) {
		this.archivo = file;
		alfabeto = new ArrayList<Dato>();
		arbol = new ArrayList<Nodo>();

	}

	private void agregarCaracter(char c) {

		if (!alfabeto.isEmpty())
			for (Dato dato : alfabeto)
				if (dato.getCaracter() == c) {
					dato.aumentarFrecuencia();
					return;
				}
			alfabeto.add(new Dato(c));
		
	}

	protected void mostrarAlfabeto() {
		for (Dato dato : alfabeto) {
			System.out.println(dato.getCaracter() + ": " + dato.getFrecuencia());
		}
	}
	

	protected void mostrarArbol() {
		for (Nodo nodo : arbol) {
			System.out.println(nodo.getDato().getFrecuencia());
		}
		System.out.println("-------------------------------");
	}

	public void crearArbol() {
		while (arbol.size() > 1) {
			int menor1;
			int menor2;
			int indice1 = 0;
			int indice2 = 0;
			int i = 0;

			Nodo primero = arbol.get(i);
			menor1 = primero.getDato().getFrecuencia();
			while (i < arbol.size()) {
				int frec = arbol.get(i).getDato().getFrecuencia();
				if (frec < menor1) {
					primero = arbol.get(i);
					indice1 = i;
					menor1 = frec;
				}
				i++;
			}
			arbol.remove(indice1);
			i = 0;
			Nodo segundo = arbol.get(i);
			menor2 = segundo.getDato().getFrecuencia();
			while (i < arbol.size()) {
				int frec = arbol.get(i).getDato().getFrecuencia();
				if (frec < menor2 ) {
					segundo = arbol.get(i);
					indice2 = i;
					menor2 = frec;
				}
				i++;
			}
			arbol.remove(indice2);


			Nodo nuevo = new Nodo();
			Dato dat = new Dato();
			primero.setNodoPadre(nuevo);
			primero.setBit(0);
			segundo.setNodoPadre(nuevo);
			segundo.setBit(1);
			dat.setFrecuencia(primero.getDato().getFrecuencia() + segundo.getDato().getFrecuencia());
		//	System.out.println("frec: "+primero.getDato().getFrecuencia()+" + " + segundo.getDato().getFrecuencia() + " : "+(primero.getDato().getFrecuencia() + segundo.getDato().getFrecuencia()));
			nuevo.setDato(dat);
			nuevo.setNodoIzq(primero);
			nuevo.setNodoDer(segundo);
			arbol.add(nuevo);
		//	mostrarArbol();
			i=0;

		}

	}

	public void prepararArbol() {
		for (Dato dato : alfabeto)
			arbol.add(new Nodo(dato));
	}

	public int comprimir() throws IOException {

		FileReader fr = new FileReader(archivo);

		int c = fr.read();
		while (c != -1) {
			agregarCaracter((char) c);
			c = fr.read();
		}
		prepararArbol();
		
		crearArbol();
		System.out.println(arbol.get(0).getDato().getFrecuencia());
		System.out.println(arbol.size());
		fr.close();

		return 0;
	}

}

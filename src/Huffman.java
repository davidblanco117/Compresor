import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Huffman {

	private ArrayList<Dato> alfabeto;
	private ArrayList<Nodo> arbol;
	private File archivo;
	
	public Huffman(File file) {
		this.archivo=file;	
		alfabeto= new ArrayList<Dato>();
		arbol= new ArrayList<Nodo>();
		
		
	}
	
	
	private void agregarCaracter(char c) {
		
		if(!alfabeto.isEmpty())
			for (Dato dato : alfabeto) 
				if(dato.getCaracter()==c) {
					dato.aumentarFrecuencia();
					return;
				}
		alfabeto.add(new Dato(c));
	}
	
	
	protected void mostrarAlfabeto() {
		for (Dato dato : alfabeto) {
			System.out.println(dato.getCaracter() +": "+dato.getFrecuencia());
		}
	}
	
	
	
	public int comprimir() throws IOException {
		
		FileReader fr = new FileReader(archivo);
		
		int  c= fr.read();	
		while(c!=-1) {
			agregarCaracter((char)c);
			c=fr.read();
		}
		fr.close();
		
		return 0;
	}
	
	
	
	
	


















}

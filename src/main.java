import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Compresor comp= new Compresor();
//		comp.prepararByte("01001000011011110110110001100001");
//		comp.comprimir(new File("aaa.txt"));
//		comp.grabarBinario("01001000011011110110110001100001001000000111010001101111011001000110111100100000011001010110110000100000"
//				+ "0110110101110101011011100110010001101111",new FileOutputStream( new File("salida.dat")));
	
		
		comp.comprimir(new File("aaa.txt"));
		Huffman huff= new Huffman(new File("bbb.txt"));
		huff.comprimir();

		huff.mostrarAlfabeto();
		System.out.println(huff.codificar('a'));
	
	
	}

}

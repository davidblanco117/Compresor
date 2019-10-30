import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Compresor {

	public Compresor() {

	}
	
	
	
	public void grabarBinario(String cadena, FileOutputStream fileSal) throws IOException {

		DataOutputStream ds;
		int i=0;
		int j=0;
		byte cadenaDeByte= (byte)(' '>>>6);
		byte byteAuxiliar= (byte)(' '>>>5);
		
		ds = new DataOutputStream(fileSal);
		
		
		while(i<cadena.length()) {
			
			
			cadenaDeByte=(byte)(cadenaDeByte<<1);
			
			if(cadena.charAt(i)=='1') 
				cadenaDeByte=(byte)(cadenaDeByte|byteAuxiliar);
			
			i++;
			j++;

			if(j==8) {
				ds.write(cadenaDeByte);
				cadenaDeByte= (byte)(' '>>>6);
				j=0;
			}

		}			
			ds.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void comprimir(File file) throws IOException {

		Huffman huffman= new Huffman(file);
		
		huffman.comprimir();
		grabarBinario(huffman.getCadenaComprimida(), new FileOutputStream(new File(file.getName()+"_comp.dat")));
		
	}

}

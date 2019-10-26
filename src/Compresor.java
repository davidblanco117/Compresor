import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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
				System.out.print((char)cadenaDeByte);
				cadenaDeByte= (byte)(' '>>>6);
				j=0;
			}

		}			
			ds.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void comprimir(File file) {

		FileReader fr;
		String cadena = "";

		try {
			int c;
			fr = new FileReader(file);
			c = fr.read();
			while (c != -1) {
				String aux = String.format(Integer.toBinaryString(c));

				if (aux.length() == 7)
					cadena = cadena.concat("0" + aux);

				else if (aux.length() == 6)
					cadena = cadena.concat("00" + aux);

				c = fr.read();
			}

			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}

}

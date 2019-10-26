import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Compresor {

	public Compresor() {

	}
	
	
	public byte[] prepararByte(String cad) {
		char b1 = ' ';
		byte bit1= (byte) b1;
		String cadenaFinal="";
		byte[] cadenaBytes= new byte[cad.length()/8+1];
		int i=0;
		byte inicial= (byte) (b1<<2);
		byte fin= (byte)(bit1&~bit1);
		int j=i;
		while(i<cad.length()) {
			byte aux=0;
			if(cad.charAt(i)=='1') {
				aux= (byte) (inicial>>>j);
				fin=(byte)(aux|fin);
			}
			i++;
			j++;
			if(j==8) {
				j=0;
				cadenaFinal=cadenaFinal.concat(String.valueOf((char) fin));
				cadenaBytes[i]=fin;
				fin= (byte)(bit1&~bit1);
			}
			
		}
		
		System.out.println(cadenaFinal);
	

		return cadenaBytes;
		
	}
	
	public String aBinario(int numero) {

		String retorno = "";
		while (numero > 1) {
			if (numero % 2 == 1) {
				String aux = retorno;
				retorno = "1";
				retorno = retorno.concat(aux);
			} else {
				String aux = retorno;
				retorno = "0";
				retorno = retorno.concat(aux);
			}
			numero = numero / 2;
		}
		String aux = retorno;
		retorno = "1";
		retorno = retorno.concat(aux);

		return retorno;
	}

	public void grabarBinario(byte[] bytes, FileOutputStream fileSal) {

		DataOutputStream ds;
		
		ds = new DataOutputStream(fileSal);

		try {

			
			ds.write(bytes);
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String comprimir(String cadena) {
		int i = 0;
		String retorno = "";
		while (i < cadena.length()) {
			if (i % 8 == 0)
				i++;
			else {
				retorno = retorno.concat(cadena.substring(i, i + 1));
				i++;
			}
		}

		return retorno;
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
			FileOutputStream fileSal = new FileOutputStream("comprimido.dat");
			grabarBinario(prepararByte(comprimir(cadena)), fileSal);

			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}

}

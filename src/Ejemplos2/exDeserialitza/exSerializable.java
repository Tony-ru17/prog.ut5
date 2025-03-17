package Ejemplos2.exDeserialitza;
/* Exemple de serialització d'objectes Rectangle */

// Primer exemple de CLASSE INSTANCIABLE

import java.io.*;

class exSerializable {
	public static void main(String[] args) {
		rectangle r1 = new rectangle();
		rectangle r2 = new rectangle(2,5);
		rectangle r3 = new rectangle(3,4);

		try(FileOutputStream fos = new FileOutputStream("rectangles.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);)
		{
					// Serialització
			oos.writeObject(r1);
			oos.writeObject(r2);
			oos.writeObject(r3);
		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
}


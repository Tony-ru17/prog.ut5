/*A. Programa que genere 100 números de loteria (de 0 a 99999), els guarde en un
 array estàtic, genere un Stream a partir de l'array i, fent ús de fluxes,
  mostre el màxim.
    
    A utilitzar Arrays.streams(), max() 

	Hauràs de tindre en compte que:

	- Arrays.streams() en aquest cas no retorna un Stream, sino un IntStream
	- la funció max() de Stream<T> retorna un Optional<T>, i la d'IntStream,
	  en aquest cas, un OptionalInt. Mira la documentació i utilitza la funció
	  que retorne el valor corresponent.
*/
import java.util.Random;
public class ej1{
	public static void main(String[] args) {
		Random ran = new Random();
		int[] loteria= new int[100];
		for(int i=0;i<loteria.lenght;i++)
			loteria[i]=ran.nextInt();
		for(int num:loteria)
			System.out.print(num);
		    
		
	}
}
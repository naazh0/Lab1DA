import java.io.*;
import java.util.*;

public class Lab{
	public static void main(String []args) {
		int[] numeros = new int[1000000];
		try
		{
			int i = 0;
			BufferedReader reader = new BufferedReader(new FileReader("desordenado.in"));
			String line;
			while ((line = reader.readLine()) != null)
			{
				numeros[i] = Integer.parseInt(line);
				//System.out.println(line);
				i++;
			}
			reader.close();
			System.out.println("Ordenar ahora...");
			long startTime = System.currentTimeMillis();
			Lab.bubbleSort(numeros);
			long stopTime = System.currentTimeMillis();
      		long elapsedTime = stopTime - startTime;
      		
			for(i = 0; i<1000000; i++){
				System.out.println(line);
			}
			System.out.println("Elapsed time: "+Long.toString(elapsedTime) +"ms");
		}
		catch(Exception e)
		{
			System.out.println("Error al abrir archivo");
			e.printStackTrace();
		}

	}
	public static void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {                          
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}                
		}
	}	
}
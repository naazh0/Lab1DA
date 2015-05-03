import java.io.*;
import java.util.*;
//http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Bubble_sort#Java
public class Bubble{
	public static void main(String []args) {
		int[] numeros = new int[9];
		try
		{
			int i = 0;
			BufferedReader reader = new BufferedReader(new FileReader("num.in"));
			String line;
			while ((line = reader.readLine()) != null)
			{
				numeros[i] = Integer.parseInt(line);
				i++;
			}
			reader.close();
			System.out.println("Ordenar ahora...");
			long startTime = System.currentTimeMillis();
			Bubble.bubbleSort(numeros);
			long stopTime = System.currentTimeMillis();
      		long elapsedTime = stopTime - startTime;
      		
			for(i = 0; i<9; i++){
				System.out.println(numeros[i]);
			}
			System.out.println("Elapsed time: "+Long.toString(elapsedTime) +"ms");
		}
		catch(Exception e)
		{
			System.out.println("Error al abrir archivo");
			e.printStackTrace();
		}

	}
	public static int[] bubbleSort(int[] numbers) {
		boolean swapped = true;
		for(int i = numbers.length - 1; i > 0 && swapped; i--){
			swapped = false;
			for (int j = 0; j < i; j++){
				if (numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					swapped = true;
				}
			}
		}
		return numbers;
	}
}
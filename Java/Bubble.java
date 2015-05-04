import java.io.*;
import java.util.*;
// 3985708ms
// 9ms menorMayor
//
public class Bubble{
	public static void main(String []args) {
		int[] numeros = new int[1000000];
		try
		{
			int i = 0;
			BufferedReader reader = new BufferedReader(new FileReader("mayorMenor.in"));
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
      		PrintWriter writer = new PrintWriter("Bubble_Sort_mayorMenor", "UTF-8");
			for(i = 0; i<1000000; i++){
				writer.println(numeros[i]);
			}
			System.out.println("Elapsed time: "+Long.toString(elapsedTime) +"ms");
			writer.close();
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
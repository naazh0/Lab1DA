import java.io.*;
import java.util.*;

public class Quick{
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
			Quick.quickSort(numeros);
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
	public static void quickSort(int array[]) {
		quickSort(array, 0, array.length - 1);
	}


	public static void quickSort(int array[], int start, int end){
		int i = start;
		int k = end;
		if (end - start >= 1){
			int pivot = array[start];
			while (k > i){
				while (array[i] <= pivot && i <= end && k > i)
					i++;
				while (array[k] > pivot && k >= start && k >= i)
					k--;
				if (k > i)
					swap(array, i, k);
			}
			swap(array, start, k);
			quickSort(array, start, k - 1);
			quickSort(array, k + 1, end);
		}
		else
		{
			return;                     
		}
	}

	public static void swap(int array[], int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
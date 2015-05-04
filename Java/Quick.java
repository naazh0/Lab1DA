import java.io.*;
import java.util.*;
//0,235 seconds
public class Quick{
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
			Quick.quickSort(numeros);
			long stopTime = System.currentTimeMillis();
      		long elapsedTime = (stopTime - startTime);
      		PrintWriter writer = new PrintWriter("Quick_Sort_mayorMenor.out", "UTF-8");
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
	public static void quickSort(int array[]) {
		quick_Sort(array, 0, array.length - 1);
	}


	public static void quick_Sort(int array[], int start, int end){
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
			quick_Sort(array, start, k - 1);
			quick_Sort(array, k + 1, end);
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
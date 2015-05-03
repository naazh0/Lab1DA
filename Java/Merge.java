import java.io.*;
import java.util.*;
//http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Merge_sort#Java
public class Merge{
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
			Merge.mergeSort(numeros);
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

	public static int[] mergeSort(int array[])
	{
	if(array.length > 1)
	{
		int elementsInA1 = array.length / 2;
		int elementsInA2 = array.length - elementsInA1;
		int arr1[] = new int[elementsInA1];
		int arr2[] = new int[elementsInA2];
		for(int i = 0; i < elementsInA1; i++)
			arr1[i] = array[i];
		for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
			arr2[i - elementsInA1] = array[i];
		arr1 = mergeSort(arr1);
		arr2 = mergeSort(arr2);
		int i = 0, j = 0, k = 0;
		while(arr1.length != j && arr2.length != k)
		{
			if(arr1[j] < arr2[k])
			{
				array[i] = arr1[j];
				i++;
				j++;
			}
			else
			{
				array[i] = arr2[k];
				i++;
				k++;
			}
		}
		while(arr1.length != j)
		{
			array[i] = arr1[j];
			i++;
			j++;
		}
		while(arr2.length != k)
		{
			array[i] = arr2[k];
			i++;
			k++;
		}
	}
	return array;
	}	
}
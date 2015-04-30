import java.io.*;
import java.util.*;

public class Radix{
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
			Radix.radixSort(numeros);
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
	public static void radixSort( int[] a)
	{
		int i, m = a[0], exp = 1, n = a.length;
		int[] b = new int[10];
		for (i = 1; i < n; i++)
			if (a[i] > m)
				m = a[i];
		while (m / exp > 0)
		{
			int[] bucket = new int[10];
			for (i = 0; i < n; i++)
				bucket[(a[i] / exp) % 10]++;
			for (i = 1; i < 10; i++)
				bucket[i] += bucket[i - 1];
			for (i = n - 1; i >= 0; i--)
				b[--bucket[(a[i] / exp) % 10]] = a[i];
			for (i = 0; i < n; i++)
				a[i] = b[i];
			exp *= 10;        
		}
	}    		
}

// http://www.sanfoundry.com/java-program-implement-radix-sort/
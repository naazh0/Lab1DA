import java.io.*;
import java.util.*;
//0,196 seconds desordenado
//0,219 seconds mayorMenor
//0,252 seconds menorMayor
public class Radix{
	public static void main(String []args) {
		int[] numeros = new int[1000000];
		try
		{
			int i = 0;
			BufferedReader reader = new BufferedReader(new FileReader("menorMayor.in"));
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
      		PrintWriter writer = new PrintWriter("Radix_Sort_menorMayor.out", "UTF-8");			
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
	public static void radixSort( int[] a)
	{
		int i, m = a[0], exp = 1, n = a.length;
		int[] b = new int[1000001];
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

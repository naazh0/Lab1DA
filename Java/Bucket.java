import java.io.*;
import java.util.*;
//0,075 seconds desordenado
//0,046 seconds menorMayor
//0,049 seconds mayorMenor
public class Bucket{
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
			Bucket.bucketSort(numeros, 1000000);
			long stopTime = System.currentTimeMillis();
      		long elapsedTime = stopTime - startTime;
      		PrintWriter writer = new PrintWriter("Bucket_Sort_mayorMenor.out", "UTF-8");
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
	public static void bucketSort(int[] a, int maxVal) {
      int [] bucket=new int[maxVal+1];
 
      for (int i=0; i<bucket.length; i++) {
         bucket[i]=0;
      }
 
      for (int i=0; i<a.length; i++) {
         bucket[a[i]]++;
      }
 
      int outPos=0;
      for (int i=0; i<bucket.length; i++) {
         for (int j=0; j<bucket[i]; j++) {
            a[outPos++]=i;
         }
      }
   }
}
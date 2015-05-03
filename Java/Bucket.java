import java.io.*;
import java.util.*;
//http://www.javacodex.com/Sorting/Bucket-Sort
public class Bucket{
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
			Bucket.bucketSort(numeros, 9);
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
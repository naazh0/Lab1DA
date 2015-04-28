import java.io.*;
import java.util.*;

public class Lab{
	public static void main(String []args) {
		List<Integer> numeros = new ArrayList<Integer>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line;
			while ((line = reader.readLine()) != null)
			{
				numeros.add(Integer.parseInt(line));
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("Error al abrir archivo");
			e.printStackTrace();
		}
	}
}
import java.io.*;
import java.util.*;

public class Test{
	public static void main(String []args) {
		System.out.println("Combate!");
		Minion a = new Minion(1000, 100, 20, 70, 1, "red");
		Minion b = new Minion(1000, 100, 70, 20, 2, "blue");
		Random rand = new Random();
		int randomNum = 0;

		//Solo una iteracion c:
		while(b.isAlive() && a.isAlive())
		{
			randomNum = rand.nextInt((2 - 1) + 1) + 1;

			if(randomNum == 1)
			{
				b.onDamaged(a.getAttackDamage(), a.getAttackType());
				System.out.println("El minion de color "+a.getColor()+" ataco!\n");
			}
			else if(randomNum == 2)
			{
				a.onDamaged(b.getAttackDamage(), b.getAttackType());
				System.out.println("El minion de color "+b.getColor()+" ataco!\n");
			}
			System.out.println(a.getColor()+": "+Integer.toString(a.getHealth())+"HP\n");
			System.out.println(b.getColor()+": "+Integer.toString(b.getHealth())+"HP\n");
		}
		if(a.isAlive())
		{
			System.out.println("Gano el minion de color: "+a.getColor());
		}
		else
		{
			System.out.println("Gano el minion de color: "+b.getColor());
		}
	}
}
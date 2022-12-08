import java.util.*;
import java.io.*;

public class rauschenbach_lab13 
{		
	ArrayList <Integer> numList = new ArrayList <Integer>();
	public void readData(String filename)
	{
		try
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String line;
			while((line = input.readLine()) != null)
			{
				numList.add(Integer.valueOf(line.trim()));
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public long getTotalCount()
	{
		return numList.stream().count();
	}
	public long getOddCount()
	{
		return numList.stream().filter(x -> x % 2 != 0).count();
	}
	public long getEvenCount()
	{
		return numList.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return numList.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1()
	{
		return numList.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return numList.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return numList.stream().filter(x -> x % 2 != 0).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}

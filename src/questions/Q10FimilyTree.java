package questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Comparator;


//Pesho Peshev
//11/11/1951 - 23/05/1980
//Penka Pesheva - 23/05/1980
//Penka Pesheva 09/02/1953
//Pesho Peshev - Gancho Peshev
//Gancho Peshev 01/01/2005
//Stamat Peshev 11/11/1951
//Pesho Peshev 23/05/1980
//End

public class Q10FimilyTree {

	static final int PA = 0;
	static final int CH = 1;

	public static void main(String[] args) {

		HashMap<String, String> nameMap = new HashMap<String, String>();
		HashMap<String, String> dateMap = new HashMap<String, String>();
		HashMap<String, Integer> orderMap = new HashMap<String, Integer>();
		ArrayList<String> dataLine = new ArrayList<String>();
		// ArrayList<Pair<String,String>> parsedLine;

		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();

		int i = 0;
		while (true) {
			String inputLine = sc.nextLine();

			if (inputLine.equals("End")) {
				sc.close();
				System.out.println(inputLine);
				break;
			} else {
				String[] input = inputLine.split(" - ");
				if (input.length < 2) {
					input = inputLine.split(" ");
					String name = input[0] + " " + input[1];
					orderMap.putIfAbsent(name, ++i);
					String date = input[2];
					orderMap.putIfAbsent(date, ++i);
					System.out.println(name + " " + date);
					nameMap.put(name, date);
					dateMap.put(date, name);
				} else {
					String name = input[0];
					orderMap.putIfAbsent(name, ++i);
					String date = input[1];
					orderMap.putIfAbsent(date, ++i);
					dataLine.add(inputLine);
				}
			}
		}

		DataForm dataForm = new DataForm();
		dataForm.dateMap = dateMap;
		dataForm.nameMap = nameMap;
		dataForm.dataLine = dataLine;
		dataForm.orderMap = orderMap;

		String tname, tdate;

		if (checkDate(temp)) {
			tname = dateMap.get(temp);
			tdate = temp;
		} else {
			tdate = nameMap.get(temp);
			tname = temp;
		}

		Q11Person target = new Q11Person();
		target.name = tname;
		target.birthDate = tdate;
		searchTree(dataForm, target);

	}


	static boolean checkDate(String Date) {

		// Pattern p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
		return Pattern.matches("[0-9]{2}/[0-9]{2}/[0-9]+", Date);

	}

	static void putHelper(LinkedHashMap<String, ArrayList<String>> map, String fi, String se) {
		if (map.containsKey(fi)) {
			map.get(fi).add(se);
		} else {
			ArrayList<String> t = new ArrayList<String>();
			t.add(se);
			map.put(fi, t);
		}
	}

	static orderedOutput printHelper(String t, DataForm dataForm) {
		if (checkDate(t)) {
			return (new orderedOutput(dataForm.dateMap.get(t) + " " + t,
					Math.min(dataForm.orderMap.get(t), dataForm.orderMap.get(dataForm.dateMap.get(t)))));
		} else {
			return (new orderedOutput(t + " " + dataForm.nameMap.get(t),
					Math.min(dataForm.orderMap.get(t), dataForm.orderMap.get(dataForm.nameMap.get(t)))));
		}
	}

	public static void searchTree(DataForm dataForm,Q11Person target)
	{
		ArrayList<orderedOutput> paLines  = new ArrayList<orderedOutput>();
		ArrayList<orderedOutput> chLines = new ArrayList<orderedOutput>();
		Set<String> dealt = new HashSet<String>();
		
		
		System.out.println(target.name +" "+ target.birthDate);
		
		for (String line:dataForm.dataLine)
		{
			String[] sub = line.split(" - ");
			String pa = sub[PA];
			String ch = sub[CH];
			;
			if(pa.equals(target.name) || pa.equals(target.birthDate)) {
				orderedOutput chLine = printHelper(ch, dataForm);
				if(!dealt.contains(chLine.line))
				{
					chLines.add(chLine);
					dealt.add(chLine.line);
				}
			}
			if(ch.equals(target.name) || ch.equals(target.birthDate)) {
				orderedOutput paLine = printHelper(pa, dataForm);
				if(!dealt.contains(paLine.line))
				{
					paLines.add(paLine);
					dealt.add(paLine.line);
				}
			}
			
		}
		
		System.out.println("Parents:");
		Comparator<? super orderedOutput> com = new OutputComparator();
		paLines.sort(com);
		chLines.sort(com);
		for(orderedOutput line:paLines)
		{
			System.out.println(line.line);
		}
		System.out.println("Children:");
		for(orderedOutput line:chLines)
		{
			System.out.println(line.line);
		}
	}


}

class OutputComparator implements Comparator<orderedOutput> 
{
	@Override
	public int compare(orderedOutput o1, orderedOutput o2) {
		if (o1.order > o2.order)
			return 1;
		if (o1.order < o2.order)
			return -1;
		if (o1.order == o2.order)
			return 0;
		return -1;
	}
}


class orderedOutput {
	String line;
	int order;

	public orderedOutput() {

	}

	public orderedOutput(String line, int order) {
		this.line = line;
		this.order = order;
	}

}

class DataForm {
	ArrayList<String> dataLine;
	HashMap<String, Integer> orderMap;
	HashMap<String, String> nameMap;
	HashMap<String, String> dateMap;
	LinkedHashMap<String, ArrayList<String>> pcMap;
	LinkedHashMap<String, ArrayList<String>> cpMap;
}

class Q11Person {

	String name = "";
	String birthDate = "";
	ArrayList<Q11Person> parent = new ArrayList<Q11Person>();
	ArrayList<Q11Person> child = new ArrayList<Q11Person>();

	// setter
	// getter

}
package com.sapient.ReadWrite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.transactions.Transactions;

public class ReadCSV {

	public static final String delimiter=",";
	static List<Transactions> list= new ArrayList<Transactions>();
	
	public static List<Transactions> read(String filename) {

		FileReader fr;
		BufferedReader reader = null;
		try {
			fr= new FileReader(filename);
			reader= new BufferedReader(fr);
			String[] tempArr;
			String st="";
			
			while((st=reader.readLine())!=null)
			{
				tempArr=st.split(delimiter);
				list.add(new Transactions(tempArr));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
		

	}
}
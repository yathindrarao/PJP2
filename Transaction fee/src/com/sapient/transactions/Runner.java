package com.sapient.transactions;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sapient.ReadWrite.ReadCSV;
import com.sapient.ReadWrite.WriteCSV;

public class Runner {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String file_input;
		String file_output;
		
		System.out.println("input file path:");
		file_input=sc.nextLine();
		
		System.out.println("output file path:");
		file_output=sc.nextLine();
		
		
		List<Transactions> list=new ArrayList<Transactions>();
		list=ReadCSV.read(file_input); 
		
		transactionsProcessing.processFee(list);

		List<Transactions> groupedList=new ArrayList<Transactions>();
		groupedList=grouping.group(list);
		
		WriteCSV.Write(groupedList, file_output);
		
	}
}

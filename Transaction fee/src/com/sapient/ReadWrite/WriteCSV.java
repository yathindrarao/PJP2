package com.sapient.ReadWrite;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sapient.transactions.Transactions;

public class WriteCSV {
	private static String SEPARATOR=",";
	public static void Write(List<Transactions> list,String filename) {
		
		try {
			FileWriter writer=new FileWriter(filename);
			BufferedWriter out=new BufferedWriter(writer);
			String heading="ClientId , TransactionType , TransactionDate , Priority , ProcessingFee";
			out.append(heading);
			out.newLine();
			for(Transactions tr: list)
			{
				String data=tr.getClientId()+SEPARATOR+tr.getTransactionType()+SEPARATOR+
						tr.getTransactionDate()+SEPARATOR+tr.getPriorityFlag()+SEPARATOR+tr.getFee();
				out.append(data);
				out.newLine();
				
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


package com.sapient.transactions;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class transactionsProcessing {
	
	//Normal transaction
	public static void processFee(List<Transactions> transactions) {
		for(Transactions t: transactions) {
			normalTransaction(t);
		}
		intraDayTransaction(transactions);
	}
	public static void normalTransaction(Transactions obj) {

		if (obj.getPriorityFlag() == 'Y') { //priority check

			obj.setFee(500);
		} else if (obj.getTransactionType().equalsIgnoreCase("sell")
				|| obj.getTransactionType().equalsIgnoreCase("withdraw")) {
			obj.setFee(100);
		} else {
			obj.setFee(50);
		}
	}
		
	//single day transactions
	public static void intraDayTransaction(List<Transactions> list)
	{
		HashSet<String> set=new HashSet<String>();
		HashMap<String,String> map=new HashMap<String,String>();
		
		for(Transactions tr:list) {
			String key=tr.getClientId()+"_"+tr.getSecurityId()+"_"+
					tr.getTransactionDate();
			if(tr.getTransactionType().equalsIgnoreCase("sell")) {
				String findKey=key+"_buy";
				if(map.containsKey(findKey))
				{
					set.add(map.get(findKey));
					map.remove(findKey);
				}
				else {
					key=key+"_sell";
					map.put(key, tr.getExtTransactionId());
				}
			}
			else if(tr.getTransactionType().equalsIgnoreCase("buy")) {
				String findKey=key+"_sell";
				if(map.containsKey(findKey))
				{
					set.add(map.get(findKey));
					map.remove(findKey);
				}
				else {
					key=key+"_buy";
					map.put(key, tr.getExtTransactionId());
				}
			}
			
		}
		
		for(Transactions tr:list) {
			if(set.contains(tr.getExtTransactionId()))
			{
				int fee=tr.getFee()+10;
				tr.setFee(fee);
				set.remove(tr.getExtTransactionId());
			}
		}
	}

}


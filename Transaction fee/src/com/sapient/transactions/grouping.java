package com.sapient.transactions;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class grouping {
	
	public static List<Transactions> group(List<Transactions> transaction)
	{
		List<Transactions> list=new ArrayList<Transactions>();
		Map<String, Map<String, Map<java.util.Date, Map<Character, List<Transactions>>>>> groupedTransactions= transaction.stream()
				.collect(Collectors.groupingBy(p->p.getClientId(),
				Collectors.groupingBy(p->p.getTransactionType(),
				Collectors.groupingBy(p->p.getTransactionDate(),
				Collectors.groupingBy(p->p.getPriorityFlag())))));
		System.out.println(groupedTransactions);
		
		for (var grpKey1 : groupedTransactions.keySet()) {
			Map<String, Map<Date, Map<Character, List<Transactions>>>> map2 = groupedTransactions.get(grpKey1);
			for (var groupKey2 : map2.keySet()) {
				Map<Date, Map<Character, List<Transactions>>> map3 = map2.get(groupKey2);
				for (var groupKey3 : map3.keySet()) {
					Map<Character, List<Transactions>> map4 = map3.get(groupKey3);
					for (var groupKey4 : map4.keySet()) {
						var grpOutput = map4.get(groupKey4);
						list.addAll(grpOutput);
					}
				}
			}
		}
		return list;
	}

}



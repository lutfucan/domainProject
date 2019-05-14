package com.meddomain.util;

import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
public class CompareTwoLists {

//	public HashSet<String> compareStartsWith(HashSet<String> domainsList, HashSet<String> wordList,
//			HashSet<String> blackList) {
//
//		HashSet<String> resultList = new HashSet<>();
//		int counter = 0;
//		long startTime = System.currentTimeMillis();
//
//
//		for (String domainToBeCompared : domainsList) {
//			System.out.println(domainsList.size() + " : " + counter++);
//			
//			for (String wordToBeCompared : wordList) {
//				if (domainToBeCompared.startsWith(wordToBeCompared)) {
//					
//					for (String blackWord : blackList) {
//						if (!domainToBeCompared.contains(blackWord)) {
//							
//							resultList.add(domainToBeCompared);
//						}
//					}					
//				}				
//			}			
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//		return resultList;
//	}

	public HashSet<String> compareStartsWith(HashSet<String> domainsList, HashSet<String> wordList,
			HashSet<String> blackList) {

		HashSet<String> blackListFiltered = new HashSet<>();
		HashSet<String> domainsFiltered = new HashSet<>();

		int counter1 = 0;
		int counter2 = 0;
		long startTime = System.currentTimeMillis();

		for (String domainToBeCompared : domainsList) {
			System.out.println(domainsList.size() + " : " + counter1++);

			for (String blackWord : blackList) {
				if (!domainToBeCompared.contains(blackWord)) {
					blackListFiltered.add(domainToBeCompared);
				}
			}
		}
		for (String domainToBeCompared : blackListFiltered) {
			System.out.println(domainsList.size() + " : " + counter2++);

			for (String wordToBeCompared : wordList) {
				if (domainToBeCompared.startsWith(wordToBeCompared)) {
					domainsFiltered.add(domainToBeCompared);
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		return domainsFiltered;
		
	}
	

}

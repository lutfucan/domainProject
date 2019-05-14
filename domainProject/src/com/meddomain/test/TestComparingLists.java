package com.meddomain.test;

import java.util.HashSet;

import com.meddomain.service.FileImportService;
import com.meddomain.service.FileImportServiceImlp;
import com.meddomain.util.CollectionConverter;
import com.meddomain.util.CompareTwoLists;

public class TestComparingLists {

	public static void main(String[] args) {
//		CollectionConverter<String> col = new CollectionConverter<>();
//		CompareTwoLists myCompare = new CompareTwoLists();
//		ArrayList<String> list = new ArrayList<>();
//		ArrayList<String> wordList = new ArrayList<>();
//		ArrayList<String> blackList = new ArrayList<>();
//		
//		list.add("deneme.com");
//		list.add("arabalar.com");
//		list.add("arabalar.com");
//		list.add("myaraba.com");
//		list.add("arabakara.com");
//		list.add("arabakara.com");
//		
//		
//		wordList.add("araba");
//		
//		blackList.add("kara");
//		
//		HashSet<String> mySet = col.convertArrayListToHashSet(list);
//		HashSet<String> wordSet = col.convertArrayListToHashSet(wordList);
//		HashSet<String> blackSet = col.convertArrayListToHashSet(blackList);
//		
//		System.out.println(myCompare.compareStartsWith(mySet, wordSet, blackSet));
		
		
		
		CompareTwoLists comparer = new CompareTwoLists();	
		CollectionConverter<String> converter = new CollectionConverter<>();
		
		FileImportService service = new FileImportServiceImlp(comparer, converter);

		
		HashSet<String> domainsToFilter = service.getGenericListAndReadHashSet("c:/test/domains.txt");
		HashSet<String> words = service.getGenericListAndReadHashSet("c:/test/turkce.txt");
		HashSet<String> blackWords = service.getGenericListAndReadHashSet("c:/test/karaliste.txt");
		System.out.println(comparer.compareStartsWith(domainsToFilter, words, blackWords));	

		
	}
}

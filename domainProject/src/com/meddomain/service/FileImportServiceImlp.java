package com.meddomain.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meddomain.pojo.FilteredDomain;
import com.meddomain.util.CollectionConverter;
import com.meddomain.util.CompareTwoLists;

@Service
public class FileImportServiceImlp implements FileImportService {

	@Autowired
	private CompareTwoLists listComparer;
	@Autowired
	private CollectionConverter<String> collectionConverter;

	public FileImportServiceImlp(CompareTwoLists listComparer, CollectionConverter<String> collectionConverter) {
		this.listComparer = listComparer;
		this.collectionConverter = collectionConverter;
	}

	@Override
	public List<FilteredDomain> getImportedDomains(String file) {
		List<FilteredDomain> domainsListObj = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(file)));
			String line = reader.readLine();
			while (line != null) {
				domainsListObj.add(new FilteredDomain(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return domainsListObj;
	}

	@Override
	public List<FilteredDomain> getImportedDomains() {
		List<FilteredDomain> domainsListObj = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("domains.txt"));
			String line = reader.readLine();
			while (line != null) {
				domainsListObj.add(new FilteredDomain(line));
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return domainsListObj;
	}
	
	@Override
	public List<String> getGenericListAndRead(String file) {
		List<String> listOfObjects = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				listOfObjects.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfObjects;
	}
	
	@Override
	public HashSet<String> getGenericListAndReadHashSet(String file) {
		ArrayList<String> listOfObjects = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				listOfObjects.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return collectionConverter.convertArrayListToHashSet(listOfObjects);
	}

	@Override
	public List<String> getWordList(String file) {
		return null;
	}

	@Override
	public List<String> getWordList() {
		return null;
	}

	@Override
	public List<String> getBlackList(String file) {
		return null;
	}

	@Override
	public List<String> getBlackList() {
		return null;
	}

	public List<String> compareListsStartingWith(HashSet<String> domainsList, HashSet<String> wordList,
			HashSet<String> blackList) {
		
		HashSet<String> comparedSet = listComparer.compareStartsWith(domainsList, wordList, blackList);
		return collectionConverter.convertHashSetToArrayList(comparedSet);

	}

}

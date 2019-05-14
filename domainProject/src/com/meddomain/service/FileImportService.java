package com.meddomain.service;

import java.util.HashSet;
import java.util.List;

import com.meddomain.pojo.FilteredDomain;

public interface FileImportService {

	List<FilteredDomain> getImportedDomains(String file);

	List<FilteredDomain> getImportedDomains();

	List<String> getWordList(String file);

	List<String> getWordList();

	List<String> getBlackList(String file);

	List<String> getBlackList();

	HashSet<String> getGenericListAndReadHashSet(String file);

	List<String> getGenericListAndRead(String file);

}

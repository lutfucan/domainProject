package com.meddomain.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CollectionConverter<E> {
	
	public HashSet<E> convertArrayListToHashSet(ArrayList<E> list){		
		HashSet<E> resultSet = new HashSet<E>(list);
		return resultSet;		
	}
	
	public List<E> convertHashSetToArrayList(HashSet<E> list) {
		ArrayList<E> resultList = new ArrayList<>(list);
		return resultList;
	}
	
	public HashSet<E> getFirstXMembers(HashSet<E> list, int i) {
		List<E> firstNElementsList = list.stream().limit(i).collect(Collectors.toList());
		return new HashSet<>(firstNElementsList);		
	}

}

package com.meddomain.dao;

import java.util.List;

import com.meddomain.entity.Registrar;

public interface RegistrarDao {

	void merge(Registrar registrar);

	List<Registrar> getRegistrarList();

	Registrar getRegistrar(Class<Registrar> class1, Integer registrarId);

	void delete(int registrarId);
}

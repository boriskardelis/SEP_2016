package ftn.uns.ac.rs.tim6.service;

import java.util.List;

public interface GenericService<T> {
	
	List<T> getAll();
    T save(T t);

}

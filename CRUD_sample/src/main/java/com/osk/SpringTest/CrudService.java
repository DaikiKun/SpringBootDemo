package com.osk.SpringTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {
	@Autowired
	private CrudRepository repo;
	public List<CrudData> listAll(){
		return repo.findAll();
	}
	public void save(CrudData crud) {
		repo.save(crud);
	}
	public CrudData get(Long id) {
		return repo.findById(id).get();
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
}

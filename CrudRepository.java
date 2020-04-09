package com.osk.SpringTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<CrudData,Long>{
	 

}

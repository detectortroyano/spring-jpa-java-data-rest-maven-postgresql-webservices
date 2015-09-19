package com.jcg.examples.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jcg.examples.entity.User;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long>
{
		//http://localhost:8080/SpringDataRestExample/api/users/search/byName?name=angel
		@RestResource(path="byName") 
		public List<User> findByName(@Param("name") String name);
		
		//http://localhost:8080/SpringDataRestExample/api/users/search/findByEmail?email=angelricardo.uthh@gmail.com
	    @Query("SELECT u FROM User u "
	            +" WHERE u.email = :email")
	    List<User> findByEmail(@Param("email")String email);		
}

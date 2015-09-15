package com.jcg.examples.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jcg.examples.entity.User;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long>
{
		@RestResource(path="byName") 
		public List<User> findByName(@Param("name") String name);
}

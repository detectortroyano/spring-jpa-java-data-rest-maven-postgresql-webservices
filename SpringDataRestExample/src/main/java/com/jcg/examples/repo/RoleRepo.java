package com.jcg.examples.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jcg.examples.entity.Role;

@RepositoryRestResource
public interface RoleRepo extends JpaRepository<Role, Long>
{
		@RestResource(path="byDescription") 
		public List<Role> findByDescription(@Param("description") String description);
}

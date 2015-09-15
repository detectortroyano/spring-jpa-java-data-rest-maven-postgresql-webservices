package com.jcg.examples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Role implements java.io.Serializable{
	
		private static final long serialVersionUID = 1L;
	
	 	@Id
	 	//@GeneratedValue
	    @SequenceGenerator(name = "IDROLES_SEQ_GENERADOR",allocationSize = 1, sequenceName = "IDROLES_SEQ")
		@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "IDROLES_SEQ_GENERADOR")
	 	@Column(name="ID", unique=true, nullable=false, precision=22, scale=0)	
	    private Long id;
	     
	    @Column(name="DESCRIPTION")
	    private String description;
	    
	    @OneToMany(cascade=CascadeType.ALL)  
	    @JoinTable(name="USERROLES",   
	        joinColumns = {@JoinColumn(name="IDROLE", referencedColumnName="ID")},  
	        inverseJoinColumns = {@JoinColumn(name="IDUSER", referencedColumnName="ID")}  
	    )
	    private Set<User> userRoles;
	    
	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	   public Set<User> getUserRoles(){
		   return userRoles;
	   }
	   
	   public void setUserRoles(Set<User> userRoles){
		   this.userRoles=userRoles;
	   }
}
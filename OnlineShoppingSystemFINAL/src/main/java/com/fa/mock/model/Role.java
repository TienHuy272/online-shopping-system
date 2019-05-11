package com.fa.mock.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Role_Id")
	private int roleId;
	@Column(name = "Role_Name")
	private String roleName;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "UserSystem_Role", 
        joinColumns = { @JoinColumn(name = "Role_Id") }, 
        inverseJoinColumns = { @JoinColumn(name = "User_Id") }
    )
    Set<UserSystem> userSystems = new HashSet<UserSystem>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserSystem> getUserSystems() {
		return userSystems;
	}

	public void setUserSystems(Set<UserSystem> userSystems) {
		this.userSystems = userSystems;
	}

	public Role() {
		super();
	}
	
	
}

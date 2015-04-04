package com.ly.web.db.entity;


import javax.persistence.*;

@Entity(name=UserEntity.TAG_NAME)
public class UserEntity {

    public static final String TAG_NAME = "users";


	public UserEntity(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="userName",length=32)
	private String userName;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="niceName",length=32)
	private String niceName;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNiceName() {
		return niceName;
	}

	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	

}

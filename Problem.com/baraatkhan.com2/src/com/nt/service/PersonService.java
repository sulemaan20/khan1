package com.nt.service;


import com.nt.dto.PersonDto;

public interface PersonService {
	public String register(PersonDto dto)throws Exception;
	public PersonDto readUser(String email,String pass)throws Exception;
	public String deletuser(PersonDto dto)throws Exception;
	public String upuser(PersonDto dto)throws Exception;
	public String uppass(PersonDto dto)throws Exception;

}

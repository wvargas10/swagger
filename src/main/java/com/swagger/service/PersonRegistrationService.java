package com.swagger.service;

import com.swagger.dto.PersonPayloadInput;
import com.swagger.dto.PersonPayloadOutput;

public interface PersonRegistrationService {
	public String registerPersonGreetGeneral();
	public String registerPersonGreetName(String name);
	public PersonPayloadOutput registPerson(PersonPayloadInput input);
}

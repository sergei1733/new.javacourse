package com.company.studentOrder.validator;

import com.company.studentOrder.domain.CityRegisterRequest;
import com.company.studentOrder.domain.CityRegisterResponse;
import com.company.studentOrder.domain.Person;
import com.company.studentOrder.exception.CityRegisterException;
import com.company.studentOrder.exception.TransportException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {

        CityRegisterRequest request = new CityRegisterRequest(person);
        Client client = ClientBuilder.newClient();
        client.target("http://localhost:8080/city-register-1.0/rest/check")
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(request, MediaType.APPLICATION_JSON));
        return null;
    }
}

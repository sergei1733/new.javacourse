package com.company.studentOrder.validator;

import com.company.config.Config;
import com.company.studentOrder.domain.CityRegisterRequest;
import com.company.studentOrder.domain.CityRegisterResponse;
import com.company.studentOrder.domain.Person;
import com.company.studentOrder.exception.CityRegisterException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException {

        try {
            CityRegisterRequest request = new CityRegisterRequest(person);
            Client client = ClientBuilder.newClient();
            CityRegisterResponse response = client.target(
                    Config.getProperties(Config.CR_URL))
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                    .readEntity(CityRegisterResponse.class);

            return response;
        } catch (Exception ex) {
            throw new CityRegisterException("1", ex.getMessage(), ex);
        }
    }
}

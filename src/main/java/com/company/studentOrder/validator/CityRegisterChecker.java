package com.company.studentOrder.validator;

import com.company.studentOrder.domain.CityRegisterResponse;
import com.company.studentOrder.domain.Person;
import com.company.studentOrder.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException;
}

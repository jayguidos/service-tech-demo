/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.dto.patient;

import com.strata.health.dto.DTO;
import com.strata.health.dto.DTOEntityKey;

public class PatientDTO
        implements DTO
{
    private String firstName;
    private String lastName;
    private DTOEntityKey key;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public DTOEntityKey getKey()
    {
        return key;
    }

    public void setKey(DTOEntityKey key)
    {
        this.key = key;
    }
}

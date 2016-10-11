/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.service.external.patient;

import com.strata.health.dto.DTOEntityKey;
import com.strata.health.dto.patient.PatientDTO;
import com.strata.health.jpa.JPAPatient;

public class PatientDTOMapper
{
    public static final String TYPE_KEY = "Patient";
    protected final int version;

    public PatientDTOMapper()
    {
        this(1);
    }

    protected PatientDTOMapper(int version)
    {
        this.version = version;
    }

    public PatientDTO toDTO(JPAPatient patient)
    {
        PatientDTO pDto = makeDTO();
        pDto.setKey(toKey(patient));
        pDto.setFirstName(patient.getFirstName());
        pDto.setLastName(patient.getLastName());
        return pDto;
    }

    public long getIdFromKey(DTOEntityKey patientKey)
    {
        assert TYPE_KEY.equals(patientKey.getTypeKey());
        return Long.valueOf(patientKey.getId());
    }

    public DTOEntityKey getKeyFromId(String id)
    {
        return toKey(Long.valueOf(id));
    }

    protected PatientDTO makeDTO()
    {
        return new PatientDTO();
    }

    private DTOEntityKey toKey(JPAPatient patient)
    {
        return toKey(patient.getId());
    }

    private DTOEntityKey toKey(long patientId)
    {
        return new DTOEntityKey(TYPE_KEY, version, Long.toString(patientId));
    }
}

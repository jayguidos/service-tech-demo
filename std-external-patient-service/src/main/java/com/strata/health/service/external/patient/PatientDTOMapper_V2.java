/*
* Created on 10/10/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.service.external.patient;

import com.strata.health.dto.patient.PatientDTO;
import com.strata.health.dto.patient.PatientDTO_V2;
import com.strata.health.jpa.JPAPatient;

public class PatientDTOMapper_V2
        extends PatientDTOMapper
{
    public PatientDTOMapper_V2()
    {
        super(2);
    }

    @Override
    public PatientDTO toDTO(JPAPatient patient)
    {
        PatientDTO_V2 pDto = (PatientDTO_V2) super.toDTO(patient);
        pDto.setMiddleName(patient.getMiddleName());
        return pDto;
    }

    @Override
    protected PatientDTO makeDTO()
    {
        return new PatientDTO_V2();
    }
}

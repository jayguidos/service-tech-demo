/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.service.external.patient;

import com.strata.health.dto.DTOEntityKey;
import com.strata.health.dto.patient.PatientDTO;
import com.strata.health.jpa.JPAPatient;
import com.strata.health.service.internal.patient.IntPatientSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ExtPatientSvc_V1
{
    protected int version = 1;
    @Autowired
    private IntPatientSvc patientSvc;
    private PatientDTOMapper dtoMapper;

    public ExtPatientSvc_V1(PatientDTOMapper dtoMapper)
    {
        this.dtoMapper = dtoMapper;
    }

    public DTOEntityKey makePatientKey(String id)
    {
        return dtoMapper.getKeyFromId(id);
    }

    public PatientDTO getPatient(DTOEntityKey patientKey)
    {
        JPAPatient patient = patientSvc.getPatient(dtoMapper.getIdFromKey(patientKey));
        return patient == null ? null : dtoMapper.toDTO(patient);
    }

    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
    }
}

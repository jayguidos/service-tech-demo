/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.service.internal.patient;

import java.util.List;
import java.util.stream.Collectors;


import com.strata.health.jpa.JPAPatient;
import com.strata.health.jpa.PatientRepository;
import static java.util.stream.StreamSupport.stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IntPatientSvc
{
    @Autowired
    private PatientRepository patientRepo;

    public List<JPAPatient> readyToRetire()
    {
        return stream(patientRepo.findAll().spliterator(), false)
                .filter(r -> r.getLastName().equals("Ahokas"))
                .collect(Collectors.toList());
    }

    public JPAPatient getPatient(long idFromKey)
    {
        return patientRepo.findOne(idFromKey);
    }
}

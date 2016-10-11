/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.rest.patient;


import com.strata.health.dto.patient.PatientDTO;
import com.strata.health.service.external.patient.ExtPatientSvc_V2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v2/patient"})
public class PatientController_V2
{
    public static final String JSON_CONTENT_TYPE_HEADER = "Content-type=application/json";

    @Autowired
    @Qualifier("V2")
    private ExtPatientSvc_V2 patientSvcV2;

    @RequestMapping(value = {"/{key}"}, method = GET, headers = {JSON_CONTENT_TYPE_HEADER})
    @Transactional
    public PatientDTO getPatientViaPathV2(@PathVariable("key") String key)
    {
        return patientSvcV2.getPatient(patientSvcV2.makePatientKey(key));
    }

}

/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.rest.patient;


import com.strata.health.dto.patient.PatientDTO;
import com.strata.health.service.external.patient.ExtPatientSvc_V1;
import com.strata.health.service.external.patient.ExtPatientSvc_V2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/patient", "/v1/patient"})
public class PatientController_V1
{
    public static final String JSON_CONTENT_TYPE_HEADER = "Content-type=application/json";

    @Autowired
    @Qualifier("V1")
    private ExtPatientSvc_V1 patientSvcV1;

    @RequestMapping(method = GET, headers = {JSON_CONTENT_TYPE_HEADER})
    @Transactional
    public
    PatientDTO getPatientViaParams(@RequestParam(value = "key") String key)
    {
        return patientSvcV1.getPatient(patientSvcV1.makePatientKey(key));
    }

    @RequestMapping(value = {"/{key}", "/v1/{key}"}, method = GET, headers = {JSON_CONTENT_TYPE_HEADER})
    @Transactional
    public
    PatientDTO getPatientViaPath(@PathVariable("key") String key)
    {
        return patientSvcV1.getPatient(patientSvcV1.makePatientKey(key));
    }

}

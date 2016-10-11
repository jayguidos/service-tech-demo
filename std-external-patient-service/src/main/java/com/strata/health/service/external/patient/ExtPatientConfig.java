/*
* Created on 10/10/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.service.external.patient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtPatientConfig
{

    @Bean
    @Qualifier("V1")
    public ExtPatientSvc_V1 makeV1Svc()
    {
        return new ExtPatientSvc_V1(new PatientDTOMapper());
    }

    @Bean
    @Qualifier("V2")
    public ExtPatientSvc_V2 makeV2Svc()
    {
        return new ExtPatientSvc_V2(new PatientDTOMapper_V2());
    }

}

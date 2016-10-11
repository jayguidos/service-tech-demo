/*
* Created on 10/10/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.service.internal.patient;

import java.util.List;


import com.strata.health.jpa.JPAPatient;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.jpa.hibernate.ddl-auto=none")
public class TestIntPatientSvc
{
    @Autowired
    public IntPatientSvc patientSvc;

    @Test
    public void testReadyToRetire()
    {
        List<JPAPatient> oldGuys = patientSvc.readyToRetire();
        assertThat("finds retire-able candidates", oldGuys.size(), is(1));
        assertThat("very tired", oldGuys.get(0).getLastName(), is("Ahokas"));
    }
}

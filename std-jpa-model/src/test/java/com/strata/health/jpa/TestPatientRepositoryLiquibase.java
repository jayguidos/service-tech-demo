/*
* Created on 10/10/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.jpa;

import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestPatientRepositoryLiquibase.class)
@DataJpaTest
public class TestPatientRepositoryLiquibase
{

    @Autowired
    private PatientRepository patientRepo;

    @Test
    public void testGetPatient()
    {
        JPAPatient john = patientRepo.findOne(1L);
        assertThat("got john", john, notNullValue(JPAPatient.class));
        assertThat("is McCarthy", john.getFirstName(), is("John"));
        assertThat("is McCarthy", john.getLastName(), is("McCarthy"));
    }

    @Test
    public void testSearchByLastName()
    {
        List<JPAPatient> results = patientRepo.findByLastName("McCarthy");
        assertThat("found a result", results.size(), is(1));
        assertThat("right result", results.get(0).getLastName(),is("McCarthy"));
    }
}

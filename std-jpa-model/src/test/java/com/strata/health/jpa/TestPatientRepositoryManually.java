/*
* Created on 10/10/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.jpa;

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
@SpringBootTest(classes = TestPatientRepositoryManually.class)
@DataJpaTest
@TestPropertySource( properties = { "liquibase.enabled=false", "spring.jpa.hibernate.ddl-auto=create" })
public class TestPatientRepositoryManually
{

    @Autowired
    private TestEntityManager em;

    @Autowired
    private PatientRepository patientRepo;

    @Before
    public void setUp()
    {
        em.persist(new JPAPatient("John", "Doe"));
        em.persist(new JPAPatient("John", "Dork"));
    }

    @Test
    public void testGetPatient()
    {
        JPAPatient doe = patientRepo.findOne(1L);
        assertThat("got Doe", doe, notNullValue(JPAPatient.class));
        assertThat("is Doe", doe.getFirstName(), is("John"));
        assertThat("is Doe", doe.getLastName(), is("Doe"));
    }
}

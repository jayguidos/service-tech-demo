/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.jpa;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface PatientRepository
        extends CrudRepository<JPAPatient,Long>
{
    List<JPAPatient> findByLastName(String lastName);
}

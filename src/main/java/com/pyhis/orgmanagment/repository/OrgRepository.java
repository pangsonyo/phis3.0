package com.pyhis.orgmanagment.repository;

import com.pyhis.orgmanagment.entity.Org;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface OrgRepository extends JpaRepository<Org,String> {
}

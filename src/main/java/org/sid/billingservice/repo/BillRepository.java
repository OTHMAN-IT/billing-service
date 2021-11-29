package org.sid.billingservice.repo;

import org.sid.billingservice.entitites.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestController
@CrossOrigin
public interface BillRepository extends JpaRepository<Bill, Long> {

}

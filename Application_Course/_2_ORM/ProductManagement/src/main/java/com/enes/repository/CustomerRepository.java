package com.enes.repository;

import com.enes.entity.Customer;
import com.enes.utility.MyRepositoryFactory;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class CustomerRepository extends MyRepositoryFactory<Customer, Long> {
    public CustomerRepository() {
        super(Customer.class);
    }

    public Optional<Customer> findCustomerByIdentity(String identity) {
        openSession();
        CriteriaQuery<Customer> criteriaQuery = getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root).where(getCriteriaBuilder().equal(root.get("identity"), identity));
        List<Customer> customers = getSession().createQuery(criteriaQuery).getResultList();
        closeSession();
        return Optional.ofNullable(customers.isEmpty() ? null :customers.get(0));
    }
}

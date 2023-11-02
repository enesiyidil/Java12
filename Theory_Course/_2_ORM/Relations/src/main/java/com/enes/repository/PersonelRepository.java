package com.enes.repository;

import com.enes.repository.entity.Personel;
import com.enes.utility.MyRepositoryFactory;

public class PersonelRepository extends MyRepositoryFactory<Personel, Long> {
    public PersonelRepository() {
        super(Personel.class);
    }
}

package com.enes.repository;

import com.enes.repository.entity.Sepet;
import com.enes.utility.MyRepositoryFactory;

public class SepetRepository extends MyRepositoryFactory<Sepet, Long> {
    public SepetRepository() {
        super(Sepet.class);
    }
}

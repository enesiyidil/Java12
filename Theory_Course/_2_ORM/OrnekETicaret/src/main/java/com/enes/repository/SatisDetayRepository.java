package com.enes.repository;

import com.enes.repository.entity.SatisDetay;
import com.enes.utility.MyRepositoryFactory;

public class SatisDetayRepository extends MyRepositoryFactory<SatisDetay, Long> {
    public SatisDetayRepository() {
        super(SatisDetay.class);
    }
}

package com.enes.repository;

import com.enes.repository.entity.Musteri;
import com.enes.utility.MyRepositoryFactory;

import java.util.List;

public class MusteriRepository extends MyRepositoryFactory<Musteri, Long> {
    public MusteriRepository() {
        super(Musteri.class);
    }
}

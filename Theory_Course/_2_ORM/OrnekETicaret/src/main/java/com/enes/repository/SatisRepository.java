package com.enes.repository;

import com.enes.repository.entity.Musteri;
import com.enes.repository.entity.Satis;
import com.enes.repository.entity.Urun;
import com.enes.utility.ICrud;
import com.enes.utility.MyRepositoryFactory;

import java.util.List;

public class SatisRepository extends MyRepositoryFactory<Satis, Long> {
    public SatisRepository() {
        super(Satis.class);
    }
}

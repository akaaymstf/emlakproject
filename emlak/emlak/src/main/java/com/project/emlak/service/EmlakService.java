package com.project.emlak.service;

import com.project.emlak.entity.Emlak;
import java.util.List;

public interface EmlakService {

    List<Emlak> findAll();

    Emlak findById(int theId);

    void save(Emlak theEmlak);

    void deleteById(int theId);

    public List<Emlak> findEmlakByCriteria(String adres, String fiyat, String boyut, String oda, String durum, String tur);

}

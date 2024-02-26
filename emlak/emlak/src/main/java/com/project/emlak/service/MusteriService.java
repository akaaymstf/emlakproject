package com.project.emlak.service;

import com.project.emlak.entity.Musteri;
import java.util.List;

public interface MusteriService {

    List<Musteri> findAll();

    Musteri findById(int theId);

    void save(Musteri theMusteri);

    void deleteById(int theId);
}

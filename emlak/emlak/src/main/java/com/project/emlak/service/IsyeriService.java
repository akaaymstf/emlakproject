package com.project.emlak.service;

import com.project.emlak.entity.Isyeri;
import java.util.List;

public interface IsyeriService {

    List<Isyeri> findAll();

    Isyeri findById(int theId);

    void save(Isyeri theIsyeri);

    void deleteById(int theId);
}

package com.project.emlak.service;

import com.project.emlak.dao.IsyeriRepository;
import com.project.emlak.entity.Isyeri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IsyeriServiceImpl  implements IsyeriService{

    private IsyeriRepository isyeriRepository;

    @Autowired
    public IsyeriServiceImpl(IsyeriRepository theIsyeriRepository) {
        isyeriRepository = theIsyeriRepository;
    }

    @Override
    public List<Isyeri> findAll() {
        return isyeriRepository.findAll();
    }

    @Override
    public Isyeri findById(int theId) {
        Optional<Isyeri> result = isyeriRepository.findById(theId);
        Isyeri theIsyeri = null;

        if (result.isPresent()) {
            theIsyeri = result.get();
        }
        else {
            throw new RuntimeException("İşyeri id bulunamadı - " + theId);
        }
        return theIsyeri;
    }

    @Override
    public void save(Isyeri theIsyeri) {
        isyeriRepository.save(theIsyeri);
    }

    @Override
    public void deleteById(int theId) {
        isyeriRepository.deleteById(theId);
    }
}

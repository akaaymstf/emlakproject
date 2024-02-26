package com.project.emlak.service;

import com.project.emlak.dao.MusteriRepository;
import com.project.emlak.entity.Musteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MusteriServiceImpl implements MusteriService{

    private MusteriRepository musteriRepository;

    @Autowired
    public MusteriServiceImpl(MusteriRepository theMusteriRepository) {
        musteriRepository = theMusteriRepository;
    }

    @Override
    public List<Musteri> findAll() {
        return musteriRepository.findAll();
    }

    @Override
    public Musteri findById(int theId) {
        Optional<Musteri> result = musteriRepository.findById(theId);
        Musteri theMusteri = null;

        if (result.isPresent()) {
            theMusteri = result.get();
        }
        else {
            throw new RuntimeException("Musteri id bulunamadı - " + theId);
        }
        return theMusteri;
    }

    @Override
    public void save(Musteri theMusteri) {
        musteriRepository.save(theMusteri);
    }

    @Override
    public void deleteById(int theId) {
        musteriRepository.deleteById(theId);
    }
}

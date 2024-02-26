package com.project.emlak.service;

import com.project.emlak.dao.EmlakRepository;
import com.project.emlak.entity.Emlak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmlakServiceImpl implements EmlakService {

    private EmlakRepository emlakRepository;

    @Autowired
    public EmlakServiceImpl(EmlakRepository theEmlakRepository) {
        emlakRepository = theEmlakRepository;
    }

    @Override
    public List<Emlak> findAll() {
        return emlakRepository.findAll();
    }

    @Override
    public Emlak findById(int theId) {
        Optional<Emlak> result = emlakRepository.findById(theId);
        Emlak theEmlak = null;

        if (result.isPresent()) {
            theEmlak = result.get();
        }
        else {
            throw new RuntimeException("Emlak id bulunamadı - " + theId);
        }
        return theEmlak;
    }

    @Override
    public void save(Emlak theEmlak) {
        emlakRepository.save(theEmlak);
    }

    @Override
    public void deleteById(int theId) {
        emlakRepository.deleteById(theId);
    }

    public List<Emlak> findEmlakByCriteria(String adres, String fiyat, String boyut, String oda, String durum, String tur) {
        if (!adres.isEmpty() && !fiyat.isEmpty() && !boyut.isEmpty() && !oda.isEmpty() && !durum.isEmpty() && !tur.isEmpty()) {
            // Tüm alanlar dolu ise
            return emlakRepository.findByAdresAndFiyatAndBoyutAndOdaAndDurumAndTur(adres, fiyat, boyut, oda, durum, tur);
        } else {
            // Herhangi bir alan boş ise
            return emlakRepository.findByCriteria(adres, fiyat, boyut, oda, durum, tur);
        }
    }
}

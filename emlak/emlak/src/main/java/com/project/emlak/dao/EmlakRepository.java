package com.project.emlak.dao;

import com.project.emlak.entity.Emlak;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.criteria.Predicate;

public interface EmlakRepository extends JpaRepository<Emlak, Integer> {


    List<Emlak> findByAdresAndFiyatAndBoyutAndOdaAndDurumAndTur(String adres, String fiyat, String boyut, String oda, String durum, String tur);

    List<Emlak> findAll(Specification<Emlak> specification);

    default List<Emlak> findByCriteria(String adres, String fiyat, String boyut, String oda, String durum, String tur) {
        return findAll((root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            // Her bir parametreyi kontrol et ve dolu olanları ekleyerek Predicate'i oluştur
            if (Objects.nonNull(adres) && !adres.isEmpty()) {
                predicate = cb.and(predicate, cb.equal(root.get("adres"), adres));
            }
            if (Objects.nonNull(fiyat) && !fiyat.isEmpty()) {
                predicate = cb.and(predicate, cb.equal(root.get("fiyat"), fiyat));
            }
            if (Objects.nonNull(boyut) && !boyut.isEmpty()) {
                predicate = cb.and(predicate, cb.equal(root.get("boyut"), boyut));
            }
            if (Objects.nonNull(oda) && !oda.isEmpty()) {
                predicate = cb.and(predicate, cb.equal(root.get("oda"), oda));
            }
            if (Objects.nonNull(durum) && !durum.isEmpty()) {
                predicate = cb.and(predicate, cb.equal(root.get("durum"), durum));
            }
            if (Objects.nonNull(tur) && !tur.isEmpty()) {
                predicate = cb.and(predicate, cb.equal(root.get("tur"), tur));
            }
            return predicate;
        });
    }
}

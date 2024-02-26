package com.project.emlak.entity;

import jakarta.persistence.*;

@Entity
@Table(name="isyeri")
public class Isyeri {

    @Id
    @SequenceGenerator(
            name = "isyeri_sequence",
            sequenceName = "isyeri_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "isyeri_sequence"
    )
    @Column(name="id")
    private int isId;

    @Column(name="ad")
    private String isAd;

    @Column(name="tel")
    private String isTel;

    @OneToOne(mappedBy = "isyeri", cascade = CascadeType.ALL)
    private Emlak emlak;

    public Isyeri() {

    }

    public Isyeri(String isAd, String isTel) {
        this.isAd = isAd;
        this.isTel = isTel;
    }

    public int getIsId() {
        return isId;
    }

    public void setIsId(int isId) {
        this.isId = isId;
    }

    public String getIsAd() {
        return isAd;
    }

    public void setIsAd(String isAd) {
        this.isAd = isAd;
    }

    public String getIsTel() {
        return isTel;
    }

    public void setIsTel(String isTel) {
        this.isTel = isTel;
    }

    @Override
    public String toString() {
        return "Isyeri{" +
                "isId=" + isId +
                ", isAd='" + isAd + '\'' +
                ", isTel='" + isTel + '\'' +
                '}';
    }
}

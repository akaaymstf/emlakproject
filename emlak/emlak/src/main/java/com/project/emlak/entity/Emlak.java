package com.project.emlak.entity;

import jakarta.persistence.*;

@Entity
@Table(name="emlak")
public class Emlak {

    @Id
    @SequenceGenerator(
            name = "emlak_sequence",
            sequenceName = "emlak_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emlak_sequence"
    )
    @Column(name="id")
    private int id;

    @Column(name="adres")
    private String adres;

    @Column(name="fiyat")
    private String fiyat;

    @Column(name="boyut")
    private String boyut;

    @Column(name="oda")
    private String oda;

    @Column(name="durum")
    private String durum;

    @Column(name="tur")
    private String tur;

    @Column(name="sondurum")
    private String sonDurum;

    @OneToOne
    @JoinColumn(name = "isyerid", referencedColumnName = "id")
    private Isyeri isyeri;

    @OneToOne
    @JoinColumn(name = "musterid", referencedColumnName = "id")
    private Musteri musteri;

    public Emlak() {
    }

    public Emlak(String adres, String fiyat, String boyut, String oda, String durum, String tur, String sonDurum) {
        this.adres = adres;
        this.fiyat = fiyat;
        this.boyut = boyut;
        this.oda = oda;
        this.durum = durum;
        this.tur = tur;
        this.sonDurum = sonDurum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public String getOda() {
        return oda;
    }

    public void setOda(String oda) {
        this.oda = oda;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getSonDurum() {
        return sonDurum;
    }

    public void setSonDurum(String sonDurum) {
        this.sonDurum = sonDurum;
    }

    public Isyeri getIsyeri() {
        return isyeri;
    }

    public void setIsyeri(Isyeri isyeri) {
        this.isyeri = isyeri;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    @Override
    public String toString() {
        return "Emlak{" +
                "id=" + id +
                ", adres='" + adres + '\'' +
                ", fiyat='" + fiyat + '\'' +
                ", boyut='" + boyut + '\'' +
                ", oda='" + oda + '\'' +
                ", durum='" + durum + '\'' +
                ", tur='" + tur + '\'' +
                ", sonDurum='" + sonDurum + '\'' +
                ", isyeri=" + isyeri +
                ", musteri=" + musteri +
                '}';
    }

}

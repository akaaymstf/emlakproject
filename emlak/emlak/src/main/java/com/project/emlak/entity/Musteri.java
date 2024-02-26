package com.project.emlak.entity;

import jakarta.persistence.*;

@Entity
@Table(name="musteri")
public class Musteri {

    @Id
    @SequenceGenerator(
            name = "musteri_sequence",
            sequenceName = "musteri_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "musteri_sequence"
    )
    @Column(name="id")
    private int mId;

    @Column(name="ad")
    private String mAd;

    @Column(name="soyad")
    private String mSoyad;

    @Column(name="ceptel")
    private String mCeptel;

    @OneToOne(mappedBy = "musteri", cascade = CascadeType.ALL)
    private Emlak emlak;

    public Musteri() {

    }

    public Musteri(String mAd, String mSoyad, String mCeptel) {
        this.mAd = mAd;
        this.mSoyad = mSoyad;
        this.mCeptel = mCeptel;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmAd() {
        return mAd;
    }

    public void setmAd(String mAd) {
        this.mAd = mAd;
    }

    public String getmSoyad() {
        return mSoyad;
    }

    public void setmSoyad(String mSoyad) {
        this.mSoyad = mSoyad;
    }

    public String getmCeptel() {
        return mCeptel;
    }

    public void setmCeptel(String mCeptel) {
        this.mCeptel = mCeptel;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "mId=" + mId +
                ", mAd='" + mAd + '\'' +
                ", mSoyad='" + mSoyad + '\'' +
                ", mCeptel='" + mCeptel + '\'' +
                '}';
    }
}

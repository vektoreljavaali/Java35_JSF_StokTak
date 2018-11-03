/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author vektorel
 */
@Table
@Entity
public class tbllog implements Serializable {
    @Id
    @SequenceGenerator(name = "sq_1",
                    sequenceName = "sq_1",
                    initialValue = 1,
                    allocationSize = 1
                    )
    @GeneratedValue(generator = "sq_1")
    private Long id;
    
    private String methodadi;
    private String hataicerigi;
    private String kullaniciadi;
    
    @Column
    @CreationTimestamp
    private LocalDateTime tarihsaat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodadi() {
        return methodadi;
    }

    public void setMethodadi(String methodadi) {
        this.methodadi = methodadi;
    }

    public String getHataicerigi() {
        return hataicerigi;
    }

    public void setHataicerigi(String hataicerigi) {
        this.hataicerigi = hataicerigi;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public LocalDateTime getTarihsaat() {
        return tarihsaat;
    }

    public void setTarihsaat(LocalDateTime tarihsaat) {
        this.tarihsaat = tarihsaat;
    }
    
    
}

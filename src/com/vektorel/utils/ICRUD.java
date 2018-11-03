/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.utils;

import java.util.List;

/**
 *
 * @author vektorel
 */
public interface ICRUD<T> {
    
    public void kaydet(T t);
    
    public void duzenle(T t);
    
    public void sil(T t);
    
    public List<T> listele(T t);
    
    public List<T> bul(T t);
    
    public T ara(Long id, T t);
    
}

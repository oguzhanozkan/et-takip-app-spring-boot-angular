package com.ettakip.EtTakip.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage<T> {
    private int number;//su an kacıncı sayfa
    private int size;// kayıtlar kacarlı olacak
    private Sort sort;
    private int totalPages;//toplam kac sayfa olustu
    private Long totalElements;//toplamda kac kayıt var
    private List<T> content;//icerik

    public void setStat(Page page, List<T> list){
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }

}

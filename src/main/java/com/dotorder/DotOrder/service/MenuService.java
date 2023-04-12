package com.dotorder.DotOrder.service;

import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Store;
import com.dotorder.DotOrder.dto.MenuDto;
import com.dotorder.DotOrder.dto.StoreDto;
import com.dotorder.DotOrder.repository.MenuRepository;
import com.dotorder.DotOrder.repository.StoreRepository;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@NoArgsConstructor
@Service
public class MenuService {
    @Autowired
    StoreRepository storeRepsitory;
    @Autowired
    MenuRepository menuRepository;
    @Transactional
    public int saveStore(StoreDto storeDto){
        Store store = storeDto.toEntity();
        storeRepsitory.save(store);
        return store.getIdx();
    }
    @Transactional
    public Store findById(int idx){
        Store entity = storeRepsitory.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 가게가 없습니다. id="+idx));
        return entity;
    }
    @Transactional
    public Menu saveMenu(MenuDto menuDto, Store store)
    {
        menuDto.setStore(store);
        Menu menu = menuDto.toEntity();
        menuRepository.save(menu);
        return menu;
    }
}

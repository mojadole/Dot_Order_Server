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
import java.util.Optional;

@NoArgsConstructor
@Service
public class MenuService {
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    MenuRepository menuRepository;
    @Transactional
    public int saveStore(StoreDto storeDto){
        Store store = storeDto.toEntity();
        storeRepository.save(store);
        return store.getIdx();
    }
    @Transactional
    public Store findById(int idx){
        Store entity = storeRepository.findById(idx).orElseThrow(()-> new IllegalArgumentException("해당 가게가 없습니다. id="+idx));
        return entity;
    }

    @Transactional
    public Menu findByName(String name){
        Menu entity = menuRepository.findByName(name);
        return entity;
    }

    @Transactional
    public Menu saveMenu(MenuDto menuDto, Store store)
    {
        //Store store= storeDto.toEntity();
        StoreDto storeDto = StoreDto.fromEntity(store);
        menuDto.setStoreDto(storeDto);
        Menu menu = menuDto.toEntity(store.getIdx(), storeRepository);
        menuRepository.save(menu);
        return menu;
    }
}

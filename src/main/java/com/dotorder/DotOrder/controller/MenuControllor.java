package com.dotorder.DotOrder.controller;

import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Store;
import com.dotorder.DotOrder.dto.MenuDto;
import com.dotorder.DotOrder.dto.StoreDto;
import com.dotorder.DotOrder.repository.StoreRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.dotorder.DotOrder.service.MenuService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Tag(name = "menu", description = "메뉴")
@RestController
@RequiredArgsConstructor
@RequestMapping("/{idx}")
public class MenuControllor {
    private final StoreRepository storeRepository;


    private final MenuService menuService;

    @PostMapping("/store")
    @Operation(summary = "{idx}/store", description = "가게 추가")
    public int save(@RequestBody StoreDto storeDto){
        return menuService.saveStore(storeDto);
    }

    @PostMapping("/menu")
    @Operation(summary = "{idx}/menu", description = "메뉴 작성")
    @Parameters({@Parameter(name = "name", description = "메뉴", example = "참치김밥"),
            @Parameter(name = "price", description = "가격", example = "2500"),
            @Parameter(name = "category", description = "카테고리", example = "RICE")})

    public Menu saveMenu(@PathVariable int idx, @RequestBody MenuDto menuDto){
        Store store = menuService.findById(idx);
        Menu menu;
        menu = menuService.saveMenu(menuDto, store);
        return menu;
    }
}

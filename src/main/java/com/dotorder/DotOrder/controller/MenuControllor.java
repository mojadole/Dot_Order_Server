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
@RequestMapping("/store")
public class MenuControllor {
    private final StoreRepository storeRepository;


    private final MenuService menuService;

    @PostMapping("/save")
    @Operation(summary = "/store/save", description = "가게 추가(백에서 DB에 추가 예정) test용")
    public int save(@RequestBody StoreDto storeDto){
        return menuService.saveStore(storeDto);
    }

    @PostMapping("{store_idx}/menu")
    @Operation(summary = "/store/{store_idx}/menu", description = "메뉴 작성 추가(백에서 DB에 추가 예정) test용")
    @Parameters({@Parameter(name = "name", description = "메뉴", example = "참치김밥"),
            @Parameter(name = "price", description = "가격", example = "2500")})

    public Menu saveMenu(@PathVariable int store_idx, @RequestBody MenuDto menuDto){
        Store store = menuService.findById(store_idx);
        Menu menu;
        menu = menuService.saveMenu(menuDto, store);
        return menu;
    }
    @GetMapping("/gps")
    @Operation(summary = "store/gps", description = "gps로 스토어 이름 찾기")
    public String returnStore(@RequestParam String gps){
        return "김밥천국";
    }
}

package com.dotorder.DotOrder.controller;


import com.dotorder.DotOrder.domain.Store;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.domain.Menu;

import com.dotorder.DotOrder.repository.MenuRepository;
import com.dotorder.DotOrder.repository.StoreRepository;
import com.dotorder.DotOrder.repository.UsersRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Tag(name = "setup", description = "처음 정보 입력")
@RequestMapping("/setup")
@RestController
public class SetupController {

    private final UsersRepository usersRepository;
    private final StoreRepository storeRepository;
    private final MenuRepository menuRepository;

    @Autowired
    public SetupController(UsersRepository usersRepository, StoreRepository storeRepository, MenuRepository menuRepository){
        this.usersRepository = usersRepository;
        this.storeRepository = storeRepository;
        this.menuRepository = menuRepository;
    }

    @GetMapping("/")
    public String setup() {
        // Define initial users
        Users user1 = new Users("guest", "111", "guest");
        Users user2 = new Users("owner", "111","owner");
        usersRepository.save(user1);
        usersRepository.save(user2);

        // Define initial stores
        Store store1 = new Store("김밥천국", "(38.4233, 127.342)");
        storeRepository.save(store1);

        // Define initial menus
        Menu menu1 = new Menu(store1,"야채김밥", 3000);
        Menu menu2 = new Menu(store1,"치즈김밥", 3000);
        Menu menu3 = new Menu(store1,"소고기김밥", 3500);
        Menu menu4 = new Menu(store1,"매콤오징어김밥", 3500);
        Menu menu5 = new Menu(store1,"매콤떙초김밥", 3500);
        Menu menu6 = new Menu(store1,"참치마요김밥", 3500);
        Menu menu7 = new Menu(store1,"참치와사비김밥", 3500);
        Menu menu8 = new Menu(store1,"새우날치알김밥", 3500);
        Menu menu9 = new Menu(store1,"어린이김밥", 3000);
        Menu menu10 = new Menu(store1,"된장찌개", 6000);
        Menu menu11 = new Menu(store1,"돼지김치찌개", 7000);
        Menu menu12 = new Menu(store1,"순두부찌개", 7000);
        Menu menu13 = new Menu(store1,"참치김치찌개", 7000);
        Menu menu14 = new Menu(store1,"고등어김치찌개", 7000);
        Menu menu15 = new Menu(store1,"꽁치김치찌개", 7000);
        Menu menu16 = new Menu(store1,"육개장", 7000);
        Menu menu17 = new Menu(store1,"뚝배기불고기", 9000);
        Menu menu18 = new Menu(store1,"김치볶음밥", 7000);
        Menu menu19 = new Menu(store1,"카레덮밥", 7000);
        Menu menu20 = new Menu(store1,"제육덮밥", 8000);
        Menu menu21 = new Menu(store1,"참치볶음밥", 7000);
        Menu menu22 = new Menu(store1,"야채비빔밥", 8000);
        Menu menu23 = new Menu(store1,"돌솥비빔밥", 8000);
        Menu menu24 = new Menu(store1,"햄야채볶음밥", 8000);
        Menu menu25 = new Menu(store1,"새우볶음밥", 8000);
        Menu menu26 = new Menu(store1,"새우날치알볶음밥", 8000);
        Menu menu27 = new Menu(store1,"오므라이스", 8000);
        Menu menu28 = new Menu(store1,"라면", 3500);
        Menu menu29 = new Menu(store1,"콩나물라면", 4000);
        Menu menu30 = new Menu(store1,"떡라면", 4000);
        Menu menu31 = new Menu(store1,"치즈라면", 4000);
        Menu menu32 = new Menu(store1,"만두라면", 4000);
        Menu menu33 = new Menu(store1,"국물떡볶이", 5000);
        Menu menu34 = new Menu(store1,"국물라볶이", 5000);
        Menu menu35 = new Menu(store1,"부산오뎅", 4000);
        Menu menu36 = new Menu(store1,"부산생생우동", 4000);
        Menu menu37 = new Menu(store1,"고기만두", 3000);
        Menu menu38 = new Menu(store1,"김치만두", 3000);
        Menu menu39 = new Menu(store1,"물만두", 3000);
        Menu menu40 = new Menu(store1,"만두국", 7000);
        Menu menu41 = new Menu(store1,"떡만두국", 7000);
        Menu menu42 = new Menu(store1,"후레쉬쫄면", 8000);
        Menu menu43 = new Menu(store1,"등심돈까스", 10000);
        Menu menu44 = new Menu(store1,"치즈돈까스", 9000);
        Menu menu45 = new Menu(store1,"수제왕돈까스", 9000);

        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);
        menuRepository.save(menu4);
        menuRepository.save(menu5);
        menuRepository.save(menu6);
        menuRepository.save(menu7);
        menuRepository.save(menu8);
        menuRepository.save(menu9);
        menuRepository.save(menu10);
        menuRepository.save(menu11);
        menuRepository.save(menu12);
        menuRepository.save(menu13);
        menuRepository.save(menu14);
        menuRepository.save(menu15);
        menuRepository.save(menu16);
        menuRepository.save(menu17);
        menuRepository.save(menu18);
        menuRepository.save(menu19);
        menuRepository.save(menu20);
        menuRepository.save(menu21);
        menuRepository.save(menu22);
        menuRepository.save(menu23);
        menuRepository.save(menu24);
        menuRepository.save(menu25);
        menuRepository.save(menu26);
        menuRepository.save(menu27);
        menuRepository.save(menu28);
        menuRepository.save(menu29);
        menuRepository.save(menu30);
        menuRepository.save(menu30);
        menuRepository.save(menu31);
        menuRepository.save(menu32);
        menuRepository.save(menu33);
        menuRepository.save(menu34);
        menuRepository.save(menu35);
        menuRepository.save(menu36);
        menuRepository.save(menu37);
        menuRepository.save(menu38);
        menuRepository.save(menu39);
        menuRepository.save(menu40);
        menuRepository.save(menu41);
        menuRepository.save(menu42);
        menuRepository.save(menu43);
        menuRepository.save(menu44);
        menuRepository.save(menu45);

        return "Initial setup completed";
    }

}

package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Store;
import com.dotorder.DotOrder.repository.StoreRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MenuDto {
    private StoreDto storeDto;

    @Schema(description = "메뉴 이름", example = "참치김밥")
    private String name;
    @Schema(description = "가격", example = "2500")
    private int price;

    @Builder
    public MenuDto(StoreDto storeDto, String name, int price) {
        this.storeDto = storeDto;
        this.name = name;
        this.price = price;
    }

    public Menu toEntity(int idx, StoreRepository storeRepository){
        Optional<Store> storeOptional = storeRepository.findById(idx);
        if (storeOptional.isPresent()){
            Store store = storeOptional.get();

            return Menu.builder()
                    .store(store)
                    .name(name)
                    .price(price)
                    .build();
        }
        else{
            return null;
        }

    }

    //public void setStore(Store store) {this.store = store;}
    public void setStoreDto(StoreDto storeDto) {
        this.storeDto = storeDto;
    }


}

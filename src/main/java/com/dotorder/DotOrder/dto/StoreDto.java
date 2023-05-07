package com.dotorder.DotOrder.dto;
import com.dotorder.DotOrder.domain.Store;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StoreDto {
    @Schema(description = "가게 이름", example = "김밥 천국")
    private String name;
    @Schema(description = "좌표", example = "(37.234234, 123.2342)")
    private String gps;


    @Builder
    public StoreDto(String name, String gps) {
        this.name = name;
        this.gps = gps;
    }

    public StoreDto(Store store) {
        this.name = store.getName();
        this.gps = store.getGps();
    }


    public Store toEntity(){
        return Store.builder()
                .name(name)
                .gps(gps)
                .build();
    }
    public static StoreDto fromEntity(Store store) {
        return StoreDto.builder()
                .name(store.getName())
                .gps(store.getGps())
                .build();
    }
}


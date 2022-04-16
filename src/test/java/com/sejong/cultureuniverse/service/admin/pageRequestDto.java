package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class pageRequestDto {

    @Test
    public void testSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .type("c")
            .keyword("100")
            .build();
    }

}

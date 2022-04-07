package com.sejong.cultureuniverse.feign;

import com.sejong.cultureuniverse.dto.PerformanceDetailsFeignDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "my-client", url = "localhost:9090")
public interface MyFeignClient {

    @GetMapping(value = "/api/performances/{endIndex}", produces = "application/json")
    List<PerformanceDetailsFeignDTO> getDTO(@PathVariable("endIndex") Integer endIndex);
}

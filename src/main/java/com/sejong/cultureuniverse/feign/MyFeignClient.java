package com.sejong.cultureuniverse.feign;

import com.sejong.cultureuniverse.dto.PerformanceDetailsFeignDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "my-client", url = "localhost:9090")
public interface MyFeignClient {


    @GetMapping(value = "performances/api/{endIndex}", produces = "application/json")
    List<PerformanceDetailsFeignDto> getDTO(@PathVariable("endIndex") Integer endIndex);
}

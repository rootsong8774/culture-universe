package com.sejong.cultureuniverse.restController.performances;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsFeignDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.feign.MyFeignClient;
import com.sejong.cultureuniverse.service.performances.PerformanceFeignService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class FeignController {

    private final MyFeignClient feignClient;
    private final PerformanceFeignService service;

    @GetMapping("/feign/performances/{endIndex}")
    public void savePerformanceDetailsAPItoDB(@PathVariable("endIndex") Integer endIndex) {
        List<PerformanceDetailsFeignDTO> dtoList = feignClient.getDTO(endIndex).stream()
            .filter(i -> i.getAge().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")&& i.getFileUrlMi()!=null).collect(Collectors.toList());
        for (PerformanceDetailsFeignDTO dto : dtoList) {
            PerformanceDetails tempEntity = service.dtoToEntity(dto);
            service.register(tempEntity);
        }

    }

    @GetMapping("/api/performances/{endIndex}")
    public JsonNode readJsonFromUrl(@PathVariable("endIndex") Integer endIndex) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(
            "http://openapi.seoul.go.kr:8088/637857735673676836366e5a6f6b42/json/SJWPerform/1/"+endIndex,
            String.class);
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(entity.getBody());
        return jsonNode.get("SJWPerform").get("row");
    }
}

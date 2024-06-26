package com.example.econom_main.Product.services;

import com.example.econom_main.Product.dtos.CostDto;
import com.example.econom_main.Product.entities.product_cost.Cost;
import com.example.econom_main.Product.mappers.CostMapper;
import com.example.econom_main.Product.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CostService {
    private final ProductRepository productRepository;
    private final CostMapper costMapper;

    public Cost findCostById(Long id, String lon, String lat) throws IOException {
        String url_str = "http://127.0.0.1:8000/api/v1/sbermarket/items/nearby-prices/?lon="+ lon +"&lat=" + lat + "&item_name=";
        String productId = productRepository.findById(id).get().getLink();
        int lastIndexSlash = productId.lastIndexOf('/');
        String getStr = productId.substring(lastIndexSlash + 1);
        int firstIndexTire = getStr.indexOf('-');
        url_str += getStr.substring(firstIndexTire + 1);
        URL url = new URL(url_str);
        ObjectMapper objectMapper = new ObjectMapper();
        CostDto costDto = objectMapper.readValue(url, CostDto.class);
        return costMapper.toCost(id, costDto);
    }
}

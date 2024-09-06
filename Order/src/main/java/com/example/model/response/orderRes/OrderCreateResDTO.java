package com.example.model.response.orderRes;

import com.example.model.response.customerRes.CustomerResDTO;
import com.example.model.response.productRes.ProductResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderCreateResDTO {
    private Long id;
    private CustomerResDTO customerResponse;
    private List<ProductResDTO> productResponses;
}

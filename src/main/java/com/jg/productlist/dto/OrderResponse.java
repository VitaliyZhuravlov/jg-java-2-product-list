package com.jg.productlist.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponse {

    private String username;
    private String productName;

    public OrderResponse(String username, String productName) {
        this.username = username;
        this.productName = productName;

    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "username='" + username + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
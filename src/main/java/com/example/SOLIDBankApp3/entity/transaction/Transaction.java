package com.example.SOLIDBankApp3.entity.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    private String transaction;

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction='" + transaction + '\'' +
                '}';
    }
}
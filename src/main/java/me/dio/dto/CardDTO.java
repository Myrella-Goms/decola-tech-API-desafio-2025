package me.dio.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CardDTO {
    private Long id;
    private String number;
    private BigDecimal limit;
    private BigDecimal currentBill;
    private List<PurchasesDTO> purchases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getCurrentBill() {
        return currentBill;
    }

    public void setCurrentBill(BigDecimal currentBill) {
        this.currentBill = currentBill;
    }

    public List<PurchasesDTO> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchasesDTO> purchases) {
        this.purchases = purchases;
    }
}

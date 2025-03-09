package me.dio.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CardDTO {
    private Long id;
    private String number;
    private BigDecimal limit;
    private BigDecimal currentBill;
    private LocalDate dueDate;
    private Date bestPurchaseDay;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Date getBestPurchaseDay() {
        return bestPurchaseDay;
    }

    public void setBestPurchaseDay(Date bestPurchaseDay) {
        this.bestPurchaseDay = bestPurchaseDay;
    }

    public List<PurchasesDTO> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchasesDTO> purchases) {
        this.purchases = purchases;
    }
}

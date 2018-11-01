package com.dlizarra.starter.purchase;

import java.util.List;
import java.util.Map;

public interface PurchaseService {

    void createPurchase(PurchaseDto purchase);

    void updatePurchase(Integer id, PurchaseDto purchase);

    void deletePurchase(Integer id);

    PurchaseDto getPurchase(Integer id);

    List<PurchaseDto> getPurchases();

    Integer getSum();

    Map<String, Integer> getDetailedSum();
}

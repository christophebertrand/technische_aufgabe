package com.dlizarra.starter.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/purchases")
    public List<PurchaseDto> findAll() {
        return purchaseService.getPurchases();
    }

    @GetMapping("/purchases/sum")
    public Integer getSum() {
        return purchaseService.getSum();
    }

    @PostMapping("/purchases")
    public void create(@RequestBody PurchaseDto newPurchase) {
        purchaseService.createPurchase(newPurchase);
    }

    @DeleteMapping("/purchases/{id}")
    void deletePurchase(@PathVariable Integer id) {
        purchaseService.deletePurchase(id);
    }

    @PutMapping("/purchases/{id}")
    void updatePurchase(@PathVariable Integer id, @RequestBody PurchaseDto purchase) {
        purchaseService.updatePurchase(id, purchase);
    }
}

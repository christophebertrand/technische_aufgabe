package com.dlizarra.starter.purchase;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private OrikaBeanMapper mapper;

    @Override
    public void createPurchase(PurchaseDto newPurchase) {
        Purchase purchase = mapper.map(newPurchase, Purchase.class);
        purchaseRepository.save(purchase);
    }

    @Override
    public void updatePurchase(Integer id, PurchaseDto purchaseDto) {
        //TODO error handling
        Purchase purchase = purchaseRepository.getOne(id);
        purchase.setProduct(purchaseDto.getProduct());
        purchase.setDate(purchaseDto.getDate());
        purchase.setUser(purchaseDto.getUser());
        purchaseRepository.save(purchase);
    }

    @Override
    public void deletePurchase(Integer id) {
        purchaseRepository.delete(id);
    }

    //TODO
    @Override
    public PurchaseDto getPurchase(Integer id) {
        return null;
    }

    @Override
    public List<PurchaseDto> getPurchases() {
        final List<Purchase> purchases = purchaseRepository.findAll(new Sort("id"));
        final List<PurchaseDto> purchaseDto = new ArrayList<PurchaseDto>();
        purchases.forEach(x -> purchaseDto.add(mapper.map(x, PurchaseDto.class)));
        return purchaseDto;
    }

    @Override
    public Integer getSum() {
        final List<Purchase> purchases = purchaseRepository.findAll();
        int total = 0;
        for (Purchase p : purchases) {
            total += p.getPrice();
        }
        return total;
    }
}

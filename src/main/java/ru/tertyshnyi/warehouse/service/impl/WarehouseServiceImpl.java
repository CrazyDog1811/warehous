package ru.tertyshnyi.warehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tertyshnyi.warehouse.model.Warehouse;
import ru.tertyshnyi.warehouse.repo.WarehouseRepo;
import ru.tertyshnyi.warehouse.service.WarehouseService;
import ru.tertyshnyi.warehouse.service.myException.MyException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final String BOY = "boy";
    private final String GIRL = "girl";

    final
    WarehouseRepo warehouseRepo;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }

    @Override
    public void add(Warehouse warehouse) {
        if (warehouse.getId() != null) {
            throw new MyException("error");
        } else {
            warehouse.setId(warehouse.getModel());
            warehouseRepo.save(warehouse);
        }
    }

    @Override
    public void deleteModel(String model) {

    }

    @Override
    public Warehouse getShoesByModel(String model) {
        return warehouseRepo.findById(model).orElse(null);
    }

    @Override
    public List<Warehouse> getAllShoes() {
        return warehouseRepo.findAll();
    }

    @Override
    public List<Warehouse> getBoysShoes() {
        List<Warehouse> allShoes = warehouseRepo.findAll();
        List<Warehouse> boysShoes = new ArrayList<>();
        for (Warehouse warehouse: allShoes) {
            if (warehouse.getSex().equals(BOY)) {
                boysShoes.add(warehouse);
            }
        }
        return boysShoes;
    }

    @Override
    public List<Warehouse> getGirlsShoes() {
        List<Warehouse> girlShoes = new ArrayList<>();
        getAllShoes().forEach((warehouse -> {
            if (warehouse.getSex().equals(GIRL)) {
                girlShoes.add(warehouse);
            }
        }));
        return girlShoes;
    }

    @Override
    public String getAllSizesByModel(String model) {
        return null;
    }

    @Override
    public void deleteSizeOfModel(String id) {

    }

    @Override
    public List<Warehouse> GetBySeason(String season) {
        List<Warehouse> seasonShoes = new ArrayList<>();
        getAllShoes().forEach(warehouse -> {
            if (warehouse.getSeason() == season) {
                seasonShoes.add(warehouse);
            }
        });
        return seasonShoes;
    }
}

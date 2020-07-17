package ru.tertyshnyi.warehouse.service;

import ru.tertyshnyi.warehouse.model.Warehouse;

import java.util.List;

public interface WarehouseService {
    public void add(Warehouse warehouse);
    public void deleteModel(String id);
    public Warehouse getShoesByModel(String id);
    public List<Warehouse> getAllShoes();
    public List<Warehouse> getBoysShoes();
    public List<Warehouse> getGirlsShoes();
    public String getAllSizesByModel(String id);
    public void deleteSizeOfModel(String id);
    public List<Warehouse> GetBySeason(String season);
}

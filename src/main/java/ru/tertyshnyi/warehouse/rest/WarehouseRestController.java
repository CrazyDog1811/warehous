package ru.tertyshnyi.warehouse.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tertyshnyi.warehouse.model.Warehouse;
import ru.tertyshnyi.warehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/api/v5/warehouse")
public class WarehouseRestController {

    final
    WarehouseService warehouseService;

    @Autowired
    public WarehouseRestController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public void addShoes(@RequestBody Warehouse warehouse) {
        warehouseService.add(warehouse);
    }

    @GetMapping("/all")
    @CrossOrigin
    @ResponseBody
    public List<Warehouse> getAllShoes() {
        return warehouseService.getAllShoes();
    }

    @GetMapping("/boys")
    @CrossOrigin
    @ResponseBody
    public List<Warehouse> getBoysShoes() {
        return warehouseService.getBoysShoes();
    }

    @GetMapping("/girls")
    @CrossOrigin
    @ResponseBody
    public List<Warehouse> getGirlsShoes() {
        return warehouseService.getGirlsShoes();
    }

    @GetMapping("/{model}")
    @CrossOrigin
    @ResponseBody
    public Warehouse getShoesByModel(@PathVariable("model") String model) {
        return warehouseService.getShoesByModel(model);
    }

    @GetMapping("/{season}")
    @CrossOrigin
    @ResponseBody
    public List<Warehouse> getShoesBySeason(@PathVariable("season") String season) {
        return warehouseService.GetBySeason(season);
    }
}

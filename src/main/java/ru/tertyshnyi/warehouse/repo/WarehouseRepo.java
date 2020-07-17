package ru.tertyshnyi.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tertyshnyi.warehouse.model.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, String> {
}

package ru.tertyshnyi.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "model")
    private String model;

    @Column(name = "sex")
    private String sex;

    @Column(name = "season")
    private String season;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private String size;

      
}

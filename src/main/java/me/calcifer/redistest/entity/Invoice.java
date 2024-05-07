package me.calcifer.redistest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {

    private static final long serialVersionUID = -4439114469417994311L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private BigDecimal amount;
}

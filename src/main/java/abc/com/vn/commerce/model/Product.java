package abc.com.vn.commerce.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;

    @Column
    private String product_name;

    @Column
    private double product_price;

    @Column
    private String product_color;

    @Column
    private String product_size;

    @Column
    private String product_description;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;




}

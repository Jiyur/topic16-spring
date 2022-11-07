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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String productName;

    @Column
    private double productPrice;


    @Column
    private String productImage;



    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;




}

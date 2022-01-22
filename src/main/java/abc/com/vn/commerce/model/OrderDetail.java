package abc.com.vn.commerce.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "order_detail")
public class OrderDetail implements Serializable {
    @Id
    @Column(name="order_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    private int quantity;
    private int price;
}

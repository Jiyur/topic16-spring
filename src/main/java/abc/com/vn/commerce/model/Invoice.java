package abc.com.vn.commerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Invoice implements Serializable {
    @Id
    @Column(name = "invoice_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    private Date invoice_date;


}

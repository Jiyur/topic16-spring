package abc.com.vn.commerce.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payment implements Serializable {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(targetEntity = Invoice.class)
    @JoinColumn(name = "invoice_fk",referencedColumnName = "invoice_number")
    private Invoice invoice;

    private Date payment_date;

    private int payment_amount;


}

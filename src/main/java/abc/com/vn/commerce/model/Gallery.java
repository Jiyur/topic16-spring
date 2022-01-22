package abc.com.vn.commerce.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gallery")
public class Gallery implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Id
    @Column(name = "gallery_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "image_url")
    @Type(type="text")
    private String img_url;

}

package abc.com.vn.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

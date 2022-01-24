package abc.com.vn.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Catalog implements Serializable {
    @Id
    @Column(name = "catalog_id")

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int catalog_id;

    @Type(type="text")
    private String catalog_name;



}

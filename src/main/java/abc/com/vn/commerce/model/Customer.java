package abc.com.vn.commerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email",name = "email_unique"))
public class Customer {
    @Id
    @Column(name = "customer_id" ,updatable = false,nullable = false)
    @GeneratedValue(
            generator = "UUID"
    )
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column
    private String gender;

    @Column
    private String fullName;

    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private String address_line;

    @Column
    private String role;



}

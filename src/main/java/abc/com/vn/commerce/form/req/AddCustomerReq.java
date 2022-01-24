package abc.com.vn.commerce.form.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCustomerReq {
    private String fullName;
    private String gender;
    private String phone;
    private String address_line;
    private String email;
}

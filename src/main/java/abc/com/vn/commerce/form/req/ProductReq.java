package abc.com.vn.commerce.form.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {
    private String productName;
    private double productPrice;
    private String productImage;
    private String catalogName;
}

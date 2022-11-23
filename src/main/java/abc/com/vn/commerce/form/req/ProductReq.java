package abc.com.vn.commerce.form.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {
    private String productName;
    private double productPrice;
    private MultipartFile productImage;
    private String catalogName;
}

package abc.com.vn.commerce.controller.admin_site;

import abc.com.vn.commerce.form.req.CustomerReq;
import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/admin/customer/")
public class CustomerManager {
    @Autowired
    CustomerService customerDAO;

    @GetMapping(value = "")
    public String customer(Model model){
        model.addAttribute("listCustomer",customerDAO.listAllCustomer());
        CustomerReq customerAdd=new CustomerReq();
        model.addAttribute("customerAdd",customerAdd);
        CustomerReq customerUpdate=new CustomerReq();
        model.addAttribute("customerUpdate",customerUpdate);
        return "admin/customers";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
        customerDAO.delete(id);
        return "redirect:/admin/customer/";
    }
    @PostMapping(value = "addCustomer")
    public String addCustomer(Model model, //
                              @ModelAttribute("customerAdd") CustomerReq customerAdd){
        String email=customerAdd.getEmail();
        String gender=customerAdd.getGender();
        String fullName=customerAdd.getFullName();
        String address_line=customerAdd.getAddress_line();
        String phone=customerAdd.getPhone();
        if(email.length()>0 && gender.length()>0 && fullName.length()>0){
            Customer customer=new Customer();
            customer.setEmail(email);
            customer.setGender(gender);
            customer.setFullName(fullName);
            customer.setPhone(phone);
            customer.setAddress_line(address_line);
            try{
                customerDAO.saveCustomer(customer);

            }
            catch(Exception e) {
                if(e.toString().contains("email_unique")){
                    model.addAttribute("errorMessage","This email has been taken, please try another one !");
                }
                else{
                    model.addAttribute("errorMessage",e.getMessage());
                }
                return "redirect:/admin/customer/";

            }
        }

        return "redirect:/admin/customer/";


    }
    @PostMapping(value = "update")
    public String updateCustomer(@ModelAttribute("customerUpdate") CustomerReq customerUpdate){
        String email=customerUpdate.getEmail();
        System.out.println(customerUpdate.getFullName()+customerUpdate.getEmail());
        String gender=customerUpdate.getGender();
        String fullName=customerUpdate.getFullName();
        String address_line=customerUpdate.getAddress_line();
        String phone=customerUpdate.getPhone();
        try{
            Customer customer=new Customer();
            customer.setAddress_line(address_line);
            customer.setPhone(phone);
            customer.setGender(gender);
            customer.setFullName(fullName);
            customer.setEmail(email);
            System.out.println(address_line+email);
            customerDAO.update(customer);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/customer/";

    }

}

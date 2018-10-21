package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    public CustomerDTO getCustomer(@PathVariable("id") String id){
        return customerService.getCustomer(id);
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public CustomerDTO getCustomerByQueryParam(@RequestParam("id") String id){
//        return customerService.getCustomer(id);
//    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    public boolean deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

    @GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getAllCustomerCout() {
        return customerService.getAllCustomerCount();
    }

}

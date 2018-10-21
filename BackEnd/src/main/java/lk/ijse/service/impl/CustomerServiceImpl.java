package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS, // danata transaction1k thiyanawanam eka athulema weda karagena yanna
        readOnly = true) // only read / spead1 wedi wenna pluwn
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();;

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for ( Customer customer: customers ) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // aluthen transaction1k aarambha kranna)
    public boolean deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // aluthen transaction1k aarambha kranna)
    public boolean addCustomer(CustomerDTO customerDTO) {
        customerRepository.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
        return true;
    }

    @Override
    public int getAllCustomerCount() {
        return (int) customerRepository.count();
    }
}

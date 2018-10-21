package lk.ijse.dto;

import java.util.Date;
import java.util.List;

public class OrdersDTO {

    int id;
    Date date;
    CustomerDTO customerDTO;
    List<OrderDetailDTO> orderDetailDTOS;

    public OrdersDTO() {
    }

    public OrdersDTO(int id, Date date, CustomerDTO customerDTO) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
    }

    public OrdersDTO(int id, Date date, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOS) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
        this.orderDetailDTOS = orderDetailDTOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
        this.orderDetailDTOS = orderDetailDTOS;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "id=" + id +
                ", date=" + date +
                ", customerDTO=" + customerDTO +
                ", orderDetailDTOS=" + orderDetailDTOS +
                '}';
    }
}

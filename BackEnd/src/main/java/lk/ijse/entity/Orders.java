package lk.ijse.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    Customer customer;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails;

    public Orders() {
    }

    public Orders(int id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public Orders(int id, Date date, Customer customer, List<OrderDetail> orderDetails) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.orderDetails = orderDetails;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

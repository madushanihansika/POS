package lk.ijse.entity;

import javax.persistence.*;

@Entity
public class OrderDetail{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int qty;
    double unitprice;
    String itemCode;
    @ManyToOne(cascade = CascadeType.ALL)
    Orders orders;

    public OrderDetail() {
    }

    public OrderDetail(int id, int qty, double unitprice, String itemCode) {
        this.id = id;
        this.qty = qty;
        this.unitprice = unitprice;
        this.itemCode = itemCode;
    }

    public OrderDetail(int id, int qty, double unitprice, String itemCode, Orders orders) {
        this.id = id;
        this.qty = qty;
        this.unitprice = unitprice;
        this.itemCode = itemCode;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                ", itemCode='" + itemCode + '\'' +
                ", orders=" + orders +
                '}';
    }
}


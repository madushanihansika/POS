package lk.ijse.dto;

public class OrderDetailDTO {

    int id;
    int qty;
    double unitprice;
    String itemCode;
    OrdersDTO ordersDTO;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int id, int qty, double unitprice, String itemCode) {
        this.id = id;
        this.qty = qty;
        this.unitprice = unitprice;
        this.itemCode = itemCode;
    }

    public OrderDetailDTO(int id, int qty, double unitprice, String itemCode, OrdersDTO ordersDTO) {
        this.id = id;
        this.qty = qty;
        this.unitprice = unitprice;
        this.itemCode = itemCode;
        this.ordersDTO = ordersDTO;
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

    public OrdersDTO getOrdersDTO() {
        return ordersDTO;
    }

    public void setOrdersDTO(OrdersDTO ordersDTO) {
        this.ordersDTO = ordersDTO;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "id=" + id +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                ", itemCode='" + itemCode + '\'' +
                ", ordersDTO=" + ordersDTO +
                '}';
    }
}

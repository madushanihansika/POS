package lk.ijse.service;

import lk.ijse.dto.OrdersDTO;

import java.util.ArrayList;

public interface OrderService {

    public ArrayList<OrdersDTO> getAllOrders();

    public OrdersDTO getOrder(int id);

    public boolean deleteOrder(int id);

    public boolean addOrder(OrdersDTO ordersDTO);

    public int getAllOrdersCount();

}

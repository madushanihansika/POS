package lk.ijse.service;

import lk.ijse.dto.OrderDetailDTO;

import java.util.ArrayList;

public interface OrderDetailService {

    public ArrayList<OrderDetailDTO> getAllOrderDetails();

    public OrderDetailDTO getOrderDetail(int id);

    public boolean deleteOrderDetail(int id);

    public boolean addOrderDetail(OrderDetailDTO orderDetailDTO);

}

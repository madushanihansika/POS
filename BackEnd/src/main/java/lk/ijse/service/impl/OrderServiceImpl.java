package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.dto.OrderDetailDTO;
import lk.ijse.dto.OrdersDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.ItemRepository;
import lk.ijse.repository.OrderRepository;
import lk.ijse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ArrayList<OrdersDTO> getAllOrders() {
        List<Orders> ordersList = orderRepository.findAll();

        ArrayList<OrdersDTO> ordersDTOS = new ArrayList<>();
        for (Orders orders: ordersList) {
            List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
            for (OrderDetail orderDetail: orders.getOrderDetails()) {
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO(
                        orderDetail.getId(),
                        orderDetail.getQty(),
                        orderDetail.getUnitprice(),
                        orderDetail.getItemCode());
                orderDetailDTOS.add(orderDetailDTO);
            }
            OrdersDTO ordersDTO = new OrdersDTO(
                    orders.getId(),
                    orders.getDate(),
                    new CustomerDTO(
                            orders.getCustomer().getId(),
                            orders.getCustomer().getName(),
                            orders.getCustomer().getAddress()),
//                    null,
                    orderDetailDTOS);
            ordersDTOS.add(ordersDTO);
        }
        return ordersDTOS;
    }

    @Override
    public OrdersDTO getOrder(int id) {
        Orders orders = orderRepository.findById(id).get();
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetail orderDetail: orders.getOrderDetails()) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(
                    orderDetail.getId(),
                    orderDetail.getQty(),
                    orderDetail.getUnitprice(),
                    orderDetail.getItemCode());
            orderDetailDTOS.add(orderDetailDTO);
        }
        return new OrdersDTO(orders.getId(), orders.getDate(),
                new CustomerDTO(orders.getCustomer().getId(), orders.getCustomer().getName(), orders.getCustomer().getAddress()),
//                null,
                orderDetailDTOS);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteOrder(int id) {
        orderRepository.deleteById(id);

        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(OrdersDTO ordersDTO) {
        Orders orders = new Orders(ordersDTO.getId(), ordersDTO.getDate(), customerRepository.findById(ordersDTO.getCustomerDTO().getId()).get());

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO:ordersDTO.getOrderDetailDTOS()) {
            OrderDetail orderDetail = new OrderDetail(
                    orderDetailDTO.getId(),
                    orderDetailDTO.getQty(),
                    orderDetailDTO.getUnitprice(),
                    orderDetailDTO.getItemCode(),
                    orders);
            orderDetails.add(orderDetail);
        }

        orders.setOrderDetails(orderDetails);

        orderRepository.save(orders);

        return true;
    }

    @Override
    public int getAllOrdersCount() {
        return (int) orderRepository.count();
    }

}

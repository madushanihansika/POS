package lk.ijse.service.impl;

import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Item;
import lk.ijse.repository.ItemRepository;
import lk.ijse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();

        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item: items) {
            ItemDTO itemDTO = new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
            itemDTOS.add(itemDTO);
        }

        return itemDTOS;
    }

    @Override
    public ItemDTO getItem(String id) {
        Item item = itemRepository.findById(id).get();
        return new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteItem(String id) {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addItem(ItemDTO itemDTO) {
        itemRepository.save(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand()));
        return true;
    }

    @Override
    public int getAllItemCount() {
        return (int) itemRepository.count();
    }

}

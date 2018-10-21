package lk.ijse.service;

import lk.ijse.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {

    public ArrayList<ItemDTO> getAllItems();

    public ItemDTO getItem(String id);

    public boolean deleteItem(String id);

    public boolean addItem(ItemDTO itemDTO);

    public int getAllItemCount();

}

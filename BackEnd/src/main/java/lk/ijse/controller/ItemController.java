package lk.ijse.controller;

import lk.ijse.dto.ItemDTO;
import lk.ijse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    public ItemDTO getItem(@PathVariable("id") String id){
        return itemService.getItem(id);
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ItemDTO getItemByQueryParam(@RequestParam("id") String id){
//        return itemService.getItem(id);
//    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    public boolean deleteItem(@PathVariable("id") String id){
        return itemService.deleteItem(id);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteItemByQuery(@RequestParam("id") String id){
        return itemService.deleteItem(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveItem(@RequestBody ItemDTO itemDTO){
        return itemService.addItem(itemDTO);
    }

    @GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getAllItemCout() {
        return itemService.getAllItemCount();
    }

}

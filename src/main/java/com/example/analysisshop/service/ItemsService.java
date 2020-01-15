package com.example.analysisshop.service;

import com.example.analysisshop.entity.Items;
import com.example.analysisshop.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "itemsService")
public class ItemsService {

    private final ItemsMapper itemsMapper;

    @Autowired
    public ItemsService(ItemsMapper itemsMapper) {
        this.itemsMapper = itemsMapper;
    }


    public List<Items> getAll() {
        return itemsMapper.selectAll();
    }
}

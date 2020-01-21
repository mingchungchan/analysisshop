package com.example.analysisshop.service;

import com.example.analysisshop.dto.ItemsDto;
import com.example.analysisshop.entity.Items;
import com.example.analysisshop.mapper.ItemsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public void insert(Items items) {
        itemsMapper.insert(items);
    }

    public void update(Items items) {
        itemsMapper.updateByPrimaryKey(items);
    }


    public PageInfo<Items> selectPage(ItemsDto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<Items> itemss = itemsMapper.selectAll();
        PageInfo<Items> page = new PageInfo<>(itemss);
        return page;
    }


}

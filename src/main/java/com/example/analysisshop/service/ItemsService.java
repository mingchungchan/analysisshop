package com.example.analysisshop.service;

import com.example.analysisshop.dto.ItemsCreateDto;
import com.example.analysisshop.dto.ItemsDto;
import com.example.analysisshop.entity.Items;
import com.example.analysisshop.mapper.ItemsMapper;
import com.github.pagehelper.Page;
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


    /**
     * 分页查找商品
     * @param dto 查找参数
     * @return 结果
     */
    public PageInfo<Items> findByPage(ItemsDto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Page<Items> p = (Page<Items>) itemsMapper.findByPage(dto);
        //对page进行封装
        PageInfo<Items> pageInfo = new PageInfo<>(p);
        return pageInfo;
    }

    /**
     * 增加商品
     */
    public int save(ItemsCreateDto dto) {
        Items items = dto.toEntity(Items.class);
        return itemsMapper.insert(items);
    }
}

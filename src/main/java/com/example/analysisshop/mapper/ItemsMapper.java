package com.example.analysisshop.mapper;

import com.example.analysisshop.dto.ItemsDto;
import com.example.analysisshop.entity.Items;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface ItemsMapper extends Mapper<Items> {

    List<Items> findByPage(ItemsDto dto);


}

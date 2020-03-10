package com.example.analysisshop.service;

import com.example.analysisshop.dto.ItemsCreateDto;
import com.example.analysisshop.dto.ItemsDto;
import com.example.analysisshop.entity.Items;
import com.example.analysisshop.entity.Recommend;
import com.example.analysisshop.mapper.ItemsMapper;
import com.example.analysisshop.mapper.RecommendMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service(value = "itemsService")
public class ItemsService {

    private final ItemsMapper itemsMapper;
    private final RecommendMapper recommendMapper;

    @Autowired
    public ItemsService(ItemsMapper itemsMapper, RecommendMapper recommendMapper) {
        this.itemsMapper = itemsMapper;
        this.recommendMapper = recommendMapper;
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

    /**
     * 获取推荐列表8个
     */
    public List<Items> getRecommend(String uid) {
        Recommend recommend = new Recommend();
        recommend.setUser_id(uid);
        Recommend result = recommendMapper.selectOne(recommend);
        //为空，则无推荐列表
        if (result == null) {
            return null;
        }
        List<Integer> itemid = new ArrayList<>();
        String rec = result.getItem_info();
        String[] r1=rec.split(",");
        for (String s : r1) {
            String b = s.substring(0, s.indexOf(':'));
            itemid.add(Integer.valueOf(b));
        }
        //获取商品列表
        Example example = new Example(Items.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", itemid);
        //只获取前8个
        RowBounds rowBounds = new RowBounds(0,8);
        //照着喜欢程度排序
        List<Items> items=itemsMapper.selectByExampleAndRowBounds(example, rowBounds);
        List<Items> sort = new ArrayList<>();
        itemid.forEach(e->{
            for (Items item : items) {
                if (e.equals(item.getId())) {
                    sort.add(item);
                }
            }
        });
        return sort;
    }
}

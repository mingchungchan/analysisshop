package com.example.analysisshop.service;

import com.example.analysisshop.entity.Recommend;
import com.example.analysisshop.mapper.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendService {

    private final RecommendMapper recommendMapper;

    @Autowired
    public RecommendService(RecommendMapper recommendMapper) {
        this.recommendMapper = recommendMapper;
    }


    public Recommend getRecommend(String uid) {
        return recommendMapper.selectByPrimaryKey(uid);
    }
}

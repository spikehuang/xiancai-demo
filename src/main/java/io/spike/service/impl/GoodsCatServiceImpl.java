package io.spike.service.impl;

import io.spike.domain.GoodsCat;
import io.spike.mapper.GoodsCatMapper;
import io.spike.service.GoodsCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCatServiceImpl implements GoodsCatService {

    @Autowired
    private GoodsCatMapper goodsCatMapper;

    @Override
    public List<GoodsCat> listGoodsCats() {
        return goodsCatMapper.listGoodsCats();
    }
}

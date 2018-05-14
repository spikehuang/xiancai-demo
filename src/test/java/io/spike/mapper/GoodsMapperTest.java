package io.spike.mapper;

import io.spike.domain.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsMapperTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void listGoods() throws Exception {
        List<Goods> goods = goodsMapper.listGoods();
        logger.debug("listGoods={}", goods);
    }

}
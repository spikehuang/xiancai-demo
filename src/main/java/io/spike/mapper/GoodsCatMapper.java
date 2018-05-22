package io.spike.mapper;

import io.spike.domain.GoodsCat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsCatMapper {

    List<GoodsCat> listGoodsCats();
}

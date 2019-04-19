package com.bupt.qingzaoreading.dao;

import com.bupt.qingzaoreading.po.Playing;
import com.bupt.qingzaoreading.util.MyMapper;

import java.util.List;

public interface PlayingMapper extends MyMapper<Playing> {
    List<Playing> getCarousel();
}
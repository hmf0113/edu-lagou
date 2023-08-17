package com.lagou.eduadboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lagou.eduadboot.entity.PromotionAd;
import com.lagou.eduadboot.mapper.AdDao;
import com.lagou.eduadboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HP实现类
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;
    @Override
    public List<PromotionAd> getAdsBySpaceId(Integer id) {
        QueryWrapper<PromotionAd> qw = new QueryWrapper<>();
        qw.eq("space_id",id);

        return adDao.selectList(qw);
    }
}

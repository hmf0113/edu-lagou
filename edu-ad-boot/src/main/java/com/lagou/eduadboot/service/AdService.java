package com.lagou.eduadboot.service;

import com.lagou.eduadboot.entity.PromotionAd;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author HP服务层
 */
public interface AdService {
    public List<PromotionAd> getAdsBySpaceId(Integer id);
}

package com.lagou.eduadboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lagou.eduadboot.entity.PromotionAd;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HP广告数据交互层
 */
@Component
public interface AdDao extends BaseMapper<PromotionAd> {
    /**
     * 根据id查找广告位
     * @param id
     * @return
     */
    //List<PromotionAd> getAdsBySpaceId(@Param("space_id")Integer id);
}

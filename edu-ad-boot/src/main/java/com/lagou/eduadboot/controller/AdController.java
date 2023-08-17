package com.lagou.eduadboot.controller;

import com.lagou.eduadboot.entity.PromotionAd;
import com.lagou.eduadboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HP广告业务层
 */
@RestController
@RequestMapping("ad")
@CrossOrigin//解决跨域
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping("getAdsBySpaceId/{spaceid}")
    public List<PromotionAd> getAdsBySpaceId(@PathVariable("spaceid") Integer id){
        return adService.getAdsBySpaceId(id);
    }
}

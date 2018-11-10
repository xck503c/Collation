package com.family.service;

import com.family.redis.CommonRAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdGoodsService {
    @Autowired
    private CommonRAO commonRAO;

    public String test(){
        String result = commonRAO.setStr("name", "xck");
        System.out.println(result);
        System.out.println(commonRAO.getStr("name"));
        return commonRAO.getStr("name");
    }
}

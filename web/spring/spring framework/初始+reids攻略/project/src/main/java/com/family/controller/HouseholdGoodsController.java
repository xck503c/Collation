package com.family.controller;

import com.family.service.HouseholdGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HouseholdGoodsController {

    @Autowired
    private HouseholdGoodsService householdGoodsService;

    /**
     * 显示所有家庭物品的分类
     * @param model
     * @return
     */
    @RequestMapping("/houseHoldGoods.do")
    public String houseHoldGoodsList(ModelMap model){
        List<String> list = new ArrayList<String>();
        list.add("零食");
        list.add("茶叶");
        list.add("生活用品");
//        list.add(householdGoodsService.test());
        model.addAttribute("list", list);

        return "jsp/houseHoldList";
    }
}

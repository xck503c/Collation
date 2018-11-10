package com.family.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/applicationContext.xml"})
public class CommonRAOTest {

    @Autowired
    private CommonRAO commonRAO;

    @Test
    public void strTest(){
        String result = commonRAO.setStr("name", "xck");
        Assert.assertEquals(result, "OK");
    }
}

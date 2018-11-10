package com.family.redis;

import com.family.redis.adapter.RedisDcAdapter;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

//具有将数据库操作抛出的原生异常翻译转化为spring的持久层异常的功能
@Repository
public class CommonRAO {
    @Resource(name="redis")
    private RedisDcAdapter redisDcAdapter;

    /**
     * 获取和键入String类型
     * @return
     */
    public String getStr(String key){
        String value = "";
        Jedis jedis = null;
        try {
            jedis = redisDcAdapter.getJedis();
            long start = System.currentTimeMillis();
            value = jedis.get(key);
            long end = System.currentTimeMillis();
            if(end - start > 2000){

            }
        } finally {
            redisDcAdapter.returnJedis(jedis);
        }
        return value;
    }

    public String setStr(String key, String value){
        String result = "";
        Jedis jedis = null;
        try {
            jedis = redisDcAdapter.getJedis();
            long start = System.currentTimeMillis();
            result = jedis.set(key, value);
            long end = System.currentTimeMillis();
            if(end - start > 2000){

            }
        } finally {
            redisDcAdapter.returnJedis(jedis);
        }
        return result;
    }
}

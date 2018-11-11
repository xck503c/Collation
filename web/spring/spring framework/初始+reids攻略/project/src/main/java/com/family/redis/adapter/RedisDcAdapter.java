package com.family.redis.adapter;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * manager and init Redis's connector and config
 */
public class RedisDcAdapter {
    private JedisPool singlePool = null;
    private String redisServerIp = "";
    private int redisServerPort = 6379;
    private int maxTotal = 50; //资源池中最大连接数 默认值8 建议值
    private int maxIdle = 10; //资源池允许最大空闲的连接数 默认值8 建议值
    private int maxWaitMillis = 10000; //当资源池连接用尽后，调用者的最大等待时间(单位为毫秒)
    //向资源池借用连接时是否做连接有效性检测(ping)，无效连接会被移除
    // 默认值 false 业务量很大时候建议设置为false(多一次ping的开销)。
    private boolean testOnBorrow = true;
    private String poolType = ""; //reids模式 sentinel-哨兵 single-单机

    /**
     * 该方法对应配置文件初始方法;
     * 初始化redis连接池，若是多个redis连接池，需要synchronized同步;
     */
    public void initPool(){
        if("single".equals(poolType)){
            initSingleJedisPool();
        }
    }

    /**
     * 单机模式的初始化
     */
    public void initSingleJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        config.setTestOnBorrow(testOnBorrow);

        singlePool = new JedisPool(config, redisServerIp, redisServerPort, maxWaitMillis);
    }

    /**
     * 获取Jedis实例的入口
     * @return
     */
    public Jedis getJedis(){
        if("single".equals(poolType)){
            if(singlePool == null){
                initSingleJedisPool();
            }
        }
        return singlePool.getResource();
    }

    /**
     * 回收jedis连接
     * @param jedis
     */
    public void returnJedis(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }

    public JedisPool getSinglePool() {
        if(singlePool == null){
            initSingleJedisPool();
        }
        return singlePool;
    }

    public void setSinglePool(JedisPool singlePool) {
        this.singlePool = singlePool;
    }

    public String getRedisServerIp() {
        return redisServerIp;
    }

    public void setRedisServerIp(String redisServerIp) {
        this.redisServerIp = redisServerIp;
    }

    public int getRedisServerPort() {
        return redisServerPort;
    }

    public void setRedisServerPort(int redisServerPort) {
        this.redisServerPort = redisServerPort;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public String getPoolType() {
        return poolType;
    }

    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }
}

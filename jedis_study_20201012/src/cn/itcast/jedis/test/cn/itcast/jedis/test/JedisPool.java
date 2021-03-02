package cn.itcast.jedis.test.cn.itcast.jedis.test;

import org.junit.Test;

public class JedisPool {
    @Test
    public void test1() {
        //还可以设置一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTal(50);//最大活动对象
        config.setMaxIdle(10);//最大保持Idle状态的对象数


        //1.创建jedis 连接池对象
        JedisPool jedisPool = new JedisPool();
        JedisPool jedisPool1 = new JedisPool(config, "localhost", 6379);//也可以加载配置
        //2.获取链接
        Jedis jedis = jedisPool.getResource();
        //3.操作
        jedis.set("username", "zhangsan");
        //4.关闭操作==>其实是归还到连接池之中
        jedis.close();
    }
}

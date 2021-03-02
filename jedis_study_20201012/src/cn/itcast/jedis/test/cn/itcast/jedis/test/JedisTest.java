package cn.itcast.jedis.test.cn.itcast.jedis.test;


import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    /*  快速入门*/
    @Test
    public void test1() {
        //1.获取链接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "zhangsan");
        //3.关闭操作
        jedis.close();
    }

    /*操作字符串*/
    @Test
    public void test2() {
        //1.获取链接
        Jedis jedis = new Jedis();//空参默认为("localhost" ,6379)
        //2.操作
        jedis.set("username", "zhangsan");//存
        String username = jedis.get("username");//获取
        System.out.print(username);
        /*可以用作激活码*/
        jedis.setex("activecode", 20, "hhh");//讲activecode-hhh以键值对存储，并且在20秒之后自动删除
        //3.关闭操作
        jedis.close();
    }

    /*操作哈希*/
    @Test
    public void test3() {
        //1.获取链接
        Jedis jedis = new Jedis();//空参默认为("localhost" ,6379)
        //2.操作
        jedis.hset("user", "name", "zhangsan");//存
        jedis.hset("user", "age", "13");//存
        String username = jedis.hget("user", "name");//获取值
        Map<String, String> user = jedis.hgetAll("user");//获取所有值
        /*打印值*/
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.print(key + ": " + value);
        }
        //3.关闭操作
        jedis.close();
    }

    /*操作列表*/
    @Test
    public void test4() {
        //1.获取链接
        Jedis jedis = new Jedis();//空参默认为("localhost" ,6379)
        //2.操作
        jedis.lpush("mylist", "a", "b");//存并且可以一次多存
        jedis.rpush("user", "c");//存
        List<String> mylist = jedis.lrange("mylist", 0, -1);//获取全部值
        String element1 = jedis.lpop();
        String element2 = jedis.rpop();
        //3.关闭操作
        jedis.close();
    }

    /*操作set*/
    @Test
    public void test5() {
        //1.获取链接
        Jedis jedis = new Jedis();//空参默认为("localhost" ,6379)
        //2.操作
        jedis.sadd("myset", "a", "c++");//存且可以存多个
        Set<String> myset = jedis.smember("mylist");//获取全部值
        System.out.print(myset);
        //3.关闭操作
        jedis.close();
    }

    /*操作sortedset*/
    @Test
    public void test5() {
        //1.获取链接
        Jedis jedis = new Jedis();//空参默认为("localhost" ,6379)
        //2.操作
        jedis.zadd("mysortedset", "100", "c++");//存
        jedis.zadd("mysortedset", "50", "c");//存
        jedis.zadd("mysortedset", "10", "java");//存
        Set<String> mysortedset = jedis.zrange("mylist", 0, -1);//获取全部值
        System.out.print(mysortedset);
        //3.关闭操作
        jedis.close();
    }

}

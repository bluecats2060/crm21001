package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2
{
    public static void main( String[] args )
    {
        JedisPool pool=null;

           pool=RedisUtils.open("127.0.0.1",6379);
           Jedis jedis=pool.getResource();
           jedis.flushAll();
           //hash
           jedis.hset("website","baidu","www.baidu.com");
           jedis.hset("website","taobao","www.taobao.com");
           String taobao=jedis.hget("website","taobao");
            System.out.println(taobao);

            //set
            Map<String,String> map=new HashMap<>();
            map.put("id","001");
            map.put("name","tom");
            map.put("age","22");
            jedis.hmset("student",map);
            List<String> slist=jedis.hmget("student","id","name","age");
            for(String str:slist){
                System.out.println(str);
            }


    }
}

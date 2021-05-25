package com.bjpowernode;

import redis.clients.jedis.Jedis;

public class App 
{
    public static void main( String[] args )
    {

        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.flushAll(); //清空reids中数据
        jedis.set("username","tom");
        String name=jedis.get("username");
        System.out.println(name);

    }
}

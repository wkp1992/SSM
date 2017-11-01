package com.etoak.modules.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisServiceImpl implements JedisService{
	
	@Autowired
	private JedisPool jedisPool;
	
	private Jedis getResource(){
		return jedisPool.getResource();
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = getResource();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}
	
	

}

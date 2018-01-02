package com.jing.config.cache.redis;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName: RedisCachConfig
 * @Description: 缓存管理（注解用）
 * @author: Jinlong He
 * @date: 2016年12月26日 上午9:24:31
 */
//@Configuration
//@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);
	
	@Value("${spring.redis.expire:1800}")
	private int expire;
		
	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	/**
	 * 
	* @Title: keyGenerator 
	* @Description: key键生成策略
	* @throws
	 */
	@Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getSimpleName()+":");
                sb.append(method.getName()+":");
                for (Object obj : params) {
                	sb.append(obj.toString()+" ");
                }
                logger.debug("cache key:"+sb.toString());
                return sb.toString();
            }
        };
    }
	
	/**
	 * 
	* @Title: cacheManager 
	* @Description: redis管理缓存
	* @param redisTemplate
	* @return  CacheManager    返回类型 
	* @throws
	 */
	@Bean
	public CacheManager cacheManager(JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(factory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
		RedisCacheManager mgr = new RedisCacheManager(template);
		// 设置缓存过期时间
		mgr.setDefaultExpiration(expire);// 秒
		logger.debug("redis设置缓存过期时间:"+expire);
		return mgr;
	}

	/**
	 * 
	* @Title: redisTemplate 
	* @Description: RedisTemplate配置 
	* @param factory
	* @return  RedisTemplate<Object,Object>    返回类型 
	* @throws
	 */
	@Bean(name="redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        logger.debug("设置redis缓存模板");
		return template;
	}
	
	
	/**
	 * 
	* @Title: ehCacheCacheManager 
	* @Description: ehcache管理
	* @param bean
	* @return  EhCacheCacheManager    返回类型 
	* @throws
	 */
//	@Bean
//    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
//       return new EhCacheCacheManager(bean.getObject());
//    }
	
	
	/**
	 * 
	* @Title: ehCacheManagerFactoryBean 
	* @Description: ehCache类
	* @return  EhCacheManagerFactoryBean    返回类型 
	* @throws
	 */
//	@Bean
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
//     EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
//      cacheManagerFactoryBean.setConfigLocation (new ClassPathResource("ehcache.xml"));
//      cacheManagerFactoryBean.setShared(true);
//      return cacheManagerFactoryBean;
//    }
	
}
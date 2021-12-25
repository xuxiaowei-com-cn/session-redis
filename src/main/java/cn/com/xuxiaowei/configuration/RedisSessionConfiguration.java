package cn.com.xuxiaowei.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 开启 Redis Session 缓存
 * <p>
 * Redis 开启声明缓存支持
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
@EnableCaching
@EnableRedisHttpSession
public class RedisSessionConfiguration {


}

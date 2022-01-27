package cn.com.xuxiaowei.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Cookie 配置
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class CookieSerializerConfiguration {

    /**
     * 在主域中储存Cookie，子域中共享Cookie
     */
    @Bean
    public CookieSerializer cookieSerializer() {

        // 默认 Cookie 序列化
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();

        // Cookie名字，默认为 SESSION
        defaultCookieSerializer.setCookieName("SESSION");

        // 域，这允许跨子域共享cookie，默认设置是使用当前域。
        defaultCookieSerializer.setDomainName("xuxiaowei.com.cn");

        // Session Cookie 是否使用 Base64
        defaultCookieSerializer.setUseBase64Encoding(false);

        // Cookie 过期时间
        defaultCookieSerializer.setCookieMaxAge(60 * 10);

        // Cookie的路径。
        defaultCookieSerializer.setCookiePath("/");

        return defaultCookieSerializer;
    }

}

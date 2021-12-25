package cn.com.xuxiaowei.service.impl;

import cn.com.xuxiaowei.entity.User;
import cn.com.xuxiaowei.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户 接口 实现类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 返回 用户
     */
    @Cacheable(value = "user", key = "#username")
    @Override
    public User getByUsername(String username) {

        log.info("模拟查询数据库中的用户：{}", username);

        User user = new User();
        user.setUsername(username);
        user.setSex("男");
        user.setBirthday(LocalDate.now());
        user.setCreateDateTime(LocalDateTime.now());

        log.info("模拟查询结果：{}", user);

        return user;
    }

    /**
     * 根据用户名删除用户
     *
     * @param username 用户名
     * @return 返回 删除结果
     */
    @Override
    @CacheEvict(value = "user", key = "#username")
    public boolean removeByUsername(String username) {

        log.info("模拟删除数据库中的用户：{}", username);

        // 仅模拟而已，每次都返回成功
        return true;
    }

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 返回 保存结果
     */
    @Override
    @CachePut(value = "user", key = "#user.username")
    public User save(User user) {

        // 用于证明Redis是把返回值放入Redis中
        user.setUpdateDateTime(LocalDateTime.now());

        log.info("模拟保存数据库中的用户：{}", user);

        return user;
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 返回 保存结果
     */
    @Override
    @CachePut(value = "user", key = "#user.username")
    public User updateByUsername(User user) {

        log.info("模拟修改数据库中的用户：{}", user);

        user.setUpdateDateTime(LocalDateTime.now());

        log.info("模拟修改结果：{}", user);

        return user;
    }

}

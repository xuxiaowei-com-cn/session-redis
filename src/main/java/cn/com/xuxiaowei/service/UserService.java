package cn.com.xuxiaowei.service;

import cn.com.xuxiaowei.entity.User;

/**
 * 用户 接口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 返回 用户
     */
    User getByUsername(String username);

    /**
     * 根据用户名删除用户
     *
     * @param username 用户名
     * @return 返回 删除结果
     */
    boolean removeByUsername(String username);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 返回 保存结果
     */
    User save(User user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 返回 保存结果
     */
    User updateByUsername(User user);

}

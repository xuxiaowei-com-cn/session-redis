package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import cn.com.xuxiaowei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据用户名查询用户
     *
     * @param request  请求
     * @param response 响应
     * @param username 用户名
     * @return 返回 数据
     */
    @RequestMapping("/getByUsername")
    public Map<String, Object> getByUsername(HttpServletRequest request, HttpServletResponse response, String username) {
        Map<String, Object> map = new HashMap<>(4);

        User user = userService.getByUsername(username);

        map.put("getByUsername", user);

        return map;
    }

    /**
     * 根据用户名删除用户
     *
     * @param request  请求
     * @param response 响应
     * @param username 用户名
     * @return 返回 数据
     */
    @RequestMapping("/removeByUsername")
    public Map<String, Object> removeByUsername(HttpServletRequest request, HttpServletResponse response, String username) {
        Map<String, Object> map = new HashMap<>(4);

        boolean removeByUsername = userService.removeByUsername(username);

        map.put("removeByUsername", removeByUsername);

        return map;
    }

    /**
     * 保存用户
     *
     * @param request  请求
     * @param response 响应
     * @param username 用户名
     * @return 返回 数据
     */
    @RequestMapping("/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response, String username) {
        Map<String, Object> map = new HashMap<>(4);

        User user = new User();
        user.setUsername(username);
        user.setSex("男");
        user.setBirthday(LocalDate.now());

        User save = userService.save(user);

        map.put("save", save);

        return map;
    }

    /**
     * 修改用户
     *
     * @param request  请求
     * @param response 响应
     * @param username 用户名
     * @param sex      性别
     * @return 返回 数据
     */
    @RequestMapping("/updateByUsername")
    public Map<String, Object> updateByUsername(HttpServletRequest request, HttpServletResponse response,
                                                String username, String sex) {
        Map<String, Object> map = new HashMap<>(4);

        User user = new User();
        user.setUsername(username);
        user.setSex(sex);
        user.setBirthday(LocalDate.now());

        User save = userService.updateByUsername(user);

        map.put("updateByUsername", save);

        return map;
    }

}

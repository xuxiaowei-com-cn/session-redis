package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 主页
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@RestController
public class IndexRestController {

    /**
     * 主页
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 数据
     */
    @RequestMapping
    public Map<String, Object> index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(4);

        HttpSession session = request.getSession();
        String id = session.getId();

        map.put("sessionId", id);

        User user = new User();
        user.setCreateDateTime(LocalDateTime.now());

        session.setAttribute("user", user);

        return map;
    }

}

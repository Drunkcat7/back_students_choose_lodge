package com.back_students_choose_lodge.my_interceptor;

import com.alibaba.fastjson.JSONObject;
import com.back_students_choose_lodge.tools.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * 用户拦截器
 */
@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的Role注解
        Role role = method.getAnnotation(Role.class);
        // 如果注解为null, 说明不需要拦截, 直接放过
        if (role == null || role.roles().length == 0) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        //首选判断token是否有效
        if (!JwtUtil.checkToken(request)) {
            res.put("status", 500);
            res.put("msg", "token有误");
            response.getWriter().append(res.toString());
            return false;
        }
        //解密
        CurrentUserInfo userInfo = JwtUtil.getUserIdByJwtToken(request);
        assert userInfo != null;
        request.setAttribute("currentUserInfo", userInfo);
        //如果有管理员admin ，就验证等级
        String[] roles = role.roles();
        for (String s : roles) {
            if (s.equals("admin")) {
                if (userInfo.getLevel() != 1) {
                    res.put("status", 203);
                    res.put("msg", "权限不足");
                    response.getWriter().append(res.toString());
                    return false;
                }
            }
            return true;
        }
        return true;
    }

}


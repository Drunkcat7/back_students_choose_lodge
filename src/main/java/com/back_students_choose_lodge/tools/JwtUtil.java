package com.back_students_choose_lodge.tools;

import com.alibaba.druid.util.StringUtils;
import com.back_students_choose_lodge.my_interceptor.CurrentUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {
    //    token 时效 12小时
    public static final long EXPIRE = 1000 * 60 * 60 * 12;
    //    签名哈希的密钥，对于不同的加密算法来说含义不同
    public static final String APP_SECRET = "hss200923usersToken";

    /**
     * 根据用户id和用户名生成token
     *
     * @param uid   用户id
     * @param user 用户名称
     * @return JWT规则生成的token
     */
    public static String getJwtToken(Integer uid, String user, Integer level) {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("account")
                .setIssuedAt(new Date())//token 保留时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//token失效时间
                .claim("uid", uid)
                .claim("user", user)
                .claim("level", level)
                // HS256算法实际上就是MD5加盐值，此时APP_SECRET就代表盐值
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken token字符串
     * @return 如果token 有效返回true，否则返回false
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token 是否存在与有效
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            // 从http请求头中获取token字符串
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token 获取用户username
     *
     * @param request Http 请求对象
     * @return 解析token后获得的用户id
     */
    public static CurrentUserInfo getUserIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        CurrentUserInfo currentUser = new CurrentUserInfo();
        currentUser.setUid((Integer) claims.get("uid"));
        currentUser.setUser((String) claims.get("user"));
        currentUser.setLevel((Integer) claims.get("level"));
        return currentUser;
    }
}

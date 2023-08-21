package com.lagou.authorityboot.tool;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.lagou.authorityboot.entity.User;


public class JwtUtil {

    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    /**
     * //secret秘钥：自定义
     */
    private static final String TOKEN_SECRET = "laosunshigedashuaige666";

    /**
     * 生成签名，15分钟过期
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createToken(User user) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    /**
                     *  // 第一部分
                     */
                    .withHeader(header)
                    /**
                     * // 第二部分
                     */
                    .withClaim("nickname", user.getName())
                    .withClaim("userid", user.getId())
                    .withClaim("password", user.getPassword())
                    .withClaim("portrait", user.getPortrait())
                    /**
                     *  //设置过期时间
                     */
                    .withExpiresAt(date)
                    //第三部分
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static int isVerify(String token) {
        try {
            //使用HMAC256加密算法，生成签名
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            // 解析token
            verifier.verify(token);
            // 校验通过
            return 0;
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            System.out.println("令牌过期");
            // 令牌过期
            return 1;
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            System.out.println("令牌格式错误！或为空令牌！");
            // 校验失败,token令牌就是错误的
            return 2;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            System.out.println("校验失败,token令牌就是错误的");
            // 校验失败,token令牌就是错误的
            return 3;
        }
    }
    /**
     *从token解析出 用户编号 信息
     * @param token
     * @return
     */
    public static int parseTokenUserid(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("userid").asInt();
    }

    /**
     *从token解析出 昵称 信息
     * @param token
     * @return
     */
    public static String parseTokenNickname(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("nickname").asString();
    }

    /**
     *从token解析出 头像 信息
     * @param token
     * @return
     */
    public static String parseTokenPortrait(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("portrait").asString();
    }

    /**
     *从token解析出 密码 信息
     * @param token
     * @return
     */
    public static String parseTokenPassword(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("password").asString();
    }

}
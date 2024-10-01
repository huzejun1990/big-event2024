package com.dream.controller;

import com.dream.pojo.Result;
import com.dream.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: huzejun
 * @Date: 2024/9/30 17:43
 */

@RestController
@RequestMapping("/article")
public class ArticleController {
/*    @GetMapping("/list")    //Authorization  Authorization
    public Result<String> list(@RequestHeader(name = "Authorization") String token, HttpServletResponse response) {
//        public Result<String> list(@RequestHeader(name = "Authorization") String token, HttpServletResponse response) {
        //验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return Result.success("所有的文章数据...");
        } catch (Exception e) {
            //http响应状态码为401
            response.setStatus(401);
            return Result.error("未登陆");
        }
    }*/

    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {

      /*  try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            return Result.success("所有文章数据...");
        } catch (Exception e) {
            response.setStatus(401);
            return Result.error("未登陆");
        }*/

        return Result.success("所有文章数据...");
    }
}

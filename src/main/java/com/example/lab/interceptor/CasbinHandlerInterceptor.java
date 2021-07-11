package com.example.lab.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.lab.exception.BadException;
import com.example.lab.exception.ForbiddenException;
import com.example.lab.exception.InternalServerErrorException;
import com.example.lab.grpc.CasbinClient;
import io.grpc.examples.proto.EnforceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CasbinHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    CasbinClient casbinClient;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("Enter CasbinFilter....");
        // 1.模拟校验token获取用户信息
        String account = httpServletRequest.getHeader("account");
        if(account == null || account.equals("")){
            throw new BadException("账户【account】不能为空");
        }
        String originUri =httpServletRequest.getRequestURI();
        int uriLength = originUri.length();
        String uri = originUri.substring(1, uriLength);
        String[] paths = uri.split("/");
        if(paths.length != 2){
            throw new BadException("uri格式需为【/service/action】");
        }

        // 2.调用casbin进行鉴权
        // a.构建casbin-server请求参数,从request进行获取
        String sub = account;
        String service = paths[0];
        String act = paths[0]+":"+paths[1].replace(" ","");
        String resourceType = "vod";//以后通过act查询获取
        String obj = "acrn:smc:" + service + ":*:"+ resourceType + ":" + act.replace(" ","");
        System.out.println("obj -> " + obj);
        // b.向发起casbin-server请求

        List<String> params = new ArrayList<>();
        params.add(sub);
        params.add(obj);
        params.add(act);
        String policy = JSON.toJSONString(params);

        EnforceRequest enforceRequest = EnforceRequest.newBuilder()
                .addAllParams(params)
                .build();
        boolean result = true;
        try{
            //result = casbinClient.enforce(enforceRequest);
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalServerErrorException("权限校验服务未响应,"+e.getMessage());
        }

        // c.处理casbin鉴权结果
        if(!result){
            throw new ForbiddenException("账户【" + account + "】没有【" + originUri + "】权限");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}

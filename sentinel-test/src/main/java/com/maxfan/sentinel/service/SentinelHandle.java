package com.maxfan.sentinel.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.maxfan.sentinel.config.Result;

import java.util.HashMap;
import java.util.Map;

public class SentinelHandle {

    public static final int CODE_LIMIT = -100;

    public static final int CODE_FUSE = -200;

    public static Result getBlockHandle(String name, BlockException exception) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        Result result = new Result();
        System.out.println("已经限流或者熔断");
        result.setCode(CODE_LIMIT).setMsg("测试方法不可用:  handleBlock").setData(data);
        return result;
    }

    public static Result secretFallback(String name, Throwable throwable) {
        System.out.println("抓到异常");
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        Result result = new Result();
        result.setCode(CODE_FUSE).setMsg("get限流接口发生异常:  handleFallback(" + throwable.getMessage() + ")").setData(data);
        return result;
    }

}

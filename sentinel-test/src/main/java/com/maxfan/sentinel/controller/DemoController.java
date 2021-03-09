/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.maxfan.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.maxfan.sentinel.config.Result;
import com.maxfan.sentinel.service.SentinelHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Zhao
 */
@RestController
public class DemoController {
    @SentinelResource(value = "testGetRule", blockHandlerClass = SentinelHandle.class, blockHandler = "getBlockHandle",
            fallbackClass = SentinelHandle.class, fallback = "secretFallback")
    //如果返回结果是xml则使用下面的方式指定是json，或者排除jar包内转xml的包
//    @GetMapping(value="/ge",produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    @GetMapping("/ge")
    public Result test(String name){
//        boolean resultCall=redisMgmtService.checkCallByAppkey(name);
//        if(!resultCall){
//            return Result.ofFail(500,"当日调用量已达上限!");
//        }
        System.out.println("进来了");
        throw new RuntimeException("ddd");
//        return Result.ofSuccessMsg(name+"写入成功");
    }


}

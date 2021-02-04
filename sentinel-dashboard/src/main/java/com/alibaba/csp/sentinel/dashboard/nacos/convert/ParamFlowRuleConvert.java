package com.alibaba.csp.sentinel.dashboard.nacos.convert;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class ParamFlowRuleConvert implements Converter<List<ParamFlowRuleEntity>, String> {

    @Override
    public String convert(List<ParamFlowRuleEntity> paramFlowRuleEntities) {
        if (paramFlowRuleEntities == null) {
            return null;
        }
        List<ParamFlowRule> rules = new ArrayList<>();
        for (ParamFlowRuleEntity entity : paramFlowRuleEntities) {
            rules.add(entity.getRule());
        }
        return JSON.toJSONString(rules, true);
    }
}

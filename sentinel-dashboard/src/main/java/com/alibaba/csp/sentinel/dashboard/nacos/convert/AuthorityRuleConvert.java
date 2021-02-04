package com.alibaba.csp.sentinel.dashboard.nacos.convert;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class AuthorityRuleConvert implements Converter<List<AuthorityRuleEntity>, String> {

    @Override
    public String convert(List<AuthorityRuleEntity> authorityRuleEntities) {
        if (authorityRuleEntities == null) {
            return null;
        }
        List<AuthorityRule> rules = new ArrayList<>();
        for (AuthorityRuleEntity entity : authorityRuleEntities) {
            AuthorityRule rule = new AuthorityRule();
            rule.setResource(entity.getResource());
            rule.setLimitApp(entity.getLimitApp());
            rule.setStrategy(entity.getStrategy());
            rules.add(rule);
        }
        return JSON.toJSONString(rules, true);
    }
}

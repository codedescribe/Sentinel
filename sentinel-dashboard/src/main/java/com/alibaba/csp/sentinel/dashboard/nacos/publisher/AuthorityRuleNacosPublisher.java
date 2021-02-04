package com.alibaba.csp.sentinel.dashboard.nacos.publisher;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.nacos.convert.AuthorityRuleConvert;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("authorityRuleNacosPublisher")
public class AuthorityRuleNacosPublisher implements DynamicRulePublisher<List<AuthorityRuleEntity>> {

    @Autowired
    private ConfigService configService;
    @Autowired
    private AuthorityRuleConvert convert;

    @Override
    public void publish(String app, List<AuthorityRuleEntity> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        boolean success = configService.publishConfig(app + NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX,
                NacosConfigUtil.GROUP_ID, convert.convert(rules));
        if (!success) {
            throw new RuntimeException("publish to nacos fail");
        }
    }


}

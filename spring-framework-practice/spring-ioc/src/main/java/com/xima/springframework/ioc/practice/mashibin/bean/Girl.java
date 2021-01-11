package com.xima.springframework.ioc.practice.mashibin.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl implements IPerson {

    @Autowired
    private Boy boy;

    @Override
    public String buy() {
        System.out.println("女孩买了一件漂亮的衣服");
        return "衣服";
    }
}
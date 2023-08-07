package com.example.demotest.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        //this.strictInsertFill(metaObject,"create_time",LocalDateTime.class,LocalDateTime.now());
        //this.strictInsertFill(metaObject,"update_time",LocalDateTime.class,LocalDateTime.now());
        System.out.println("我进来了");
        System.out.println(LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}

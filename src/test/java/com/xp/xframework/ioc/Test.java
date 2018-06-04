package com.xp.xframework.ioc;

import com.xp.xframework.ioc.core.JsonApplicationContext;
import com.xp.xframework.ioc.entity.Robot;

public class Test {

    public static void main(String[] args) throws Exception {

        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");

        aiRobot.show();

    }

}

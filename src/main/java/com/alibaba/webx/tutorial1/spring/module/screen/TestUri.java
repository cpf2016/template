package com.alibaba.webx.tutorial1.spring.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;

public class TestUri {
    public void execute(Context context, Navigator nav) throws Exception {
    	nav.redirectTo("alibabaSite");
    }
}

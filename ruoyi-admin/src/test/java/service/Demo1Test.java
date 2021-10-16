package service;

import com.ruoyi.system.service.Demo1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author oweson
 * @date 2021/10/16 10:11
 */


public class Demo1Test extends  App{

    @Autowired
    Demo1 demo1;

    @Test
    public void test1(){
        demo1.say();
    }
}

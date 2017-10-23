package cn.ssm.test;

import cn.ssm.util.DesUtil;
import org.junit.jupiter.api.Test;

public class demo1 {
    private String key = "12345678";


    @Test
    public void teet11(){
        DesUtil d = new DesUtil();
        d.setKey("12345678");
        d.setEncString("hahahahahahah");
        String mm = d.getStrMi();
        System.out.println(mm);
        d.setDesString(mm);
        System.out.println(d.getStrM());
    }
}

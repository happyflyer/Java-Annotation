package org.example.java_annotation.action;

import org.junit.Test;

public class FilterTest {
    @Test
    public void test() {
        Filter1 f1 = new Filter1();
        f1.setId(10);

        Filter1 f2 = new Filter1();
        f2.setUsername("lucy,andy,tom");
        f2.setAge(18);

        Filter1 f3 = new Filter1();
        f3.setEmail("liu@sina.com,zh@163.com,77777@qq.com");

        FilterUtil filterUtil = new FilterUtil();
        String sql1 = filterUtil.query(f1);
        String sql2 = filterUtil.query(f2);
        String sql3 = filterUtil.query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

        Filter2 filter2 = new Filter2();
        filter2.setAmount(10);
        filter2.setName("技术部");
        System.out.println(filterUtil.query(filter2));
    }
}

package cn.com.frantest.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy implements InvocationHandler {

    private final Object target;

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理前.....");
        Object result = method.invoke(target, args);
        System.out.println("代理后......");
        return result;
    }
}

package cn.com.frantest.test;

public class Test {

    public static void main(String[] args) {
        SmsService service = (SmsService) ProxyFactory.getProxy((SmsService) msg -> {

            System.out.println("执行中......" + msg);
            return "null";
        });

        service.send("test");
    }
}

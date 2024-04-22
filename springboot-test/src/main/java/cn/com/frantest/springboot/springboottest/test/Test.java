package cn.com.frantest.springboot.springboottest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;
        int desc = 0;

        int all = 0;

        Map<String, Integer> map = new HashMap<>();

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case

            all ++;

            if (all == 1) {
                count = Integer.valueOf(in.next());
            }
            if (all == 2) {
                desc = Integer.valueOf(in.next());
            }

            if (all > 2) {

                String tmp1 = in.next();
                System.out.println(tmp1);
                String[] tmp = tmp1.split("\t");
                System.out.println(tmp[0]);
                System.out.println(tmp[1]);
                map.put(tmp[0], Integer.valueOf(tmp[1]));
            }

            if (all - count == 2) {

                System.out.println(map);

            }

        }
    }
}

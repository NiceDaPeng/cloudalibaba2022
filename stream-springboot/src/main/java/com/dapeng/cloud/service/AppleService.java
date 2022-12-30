package com.dapeng.cloud.service;

import com.dapeng.cloud.entity.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author diaopengwei
 * @date 2022/12/30
 * @apiNote
 */
public class AppleService {

    private static List<Apple> apples = new ArrayList<>();

    static {
        apples.add(new Apple(1,"red",500,"湖南"));
        apples.add(new Apple(1,"red",500,"湖南"));
        apples.add(new Apple(2,"green",500,"湖北"));
        apples.add(new Apple(2,"green",500,"湖北"));
        apples.add(new Apple(2,"green",500,"湖北"));
        apples.add(new Apple(3,"blue",500,"河南"));
        apples.add(new Apple(3,"blue",500,"河南"));
        apples.add(new Apple(3,"blue",500,"河南"));
        apples.add(new Apple(4,"yellow",500,"河北"));
        apples.add(new Apple(4,"yellow",500,"河北"));
        apples.add(new Apple(4,"yellow",500,"河北"));
    }

    //找出红色的苹果
    public static void testOne(){
        //选出红色的苹果 //选出红色和产地是湖南的苹果
        List<Apple> red = apples.stream().filter(apple -> apple.getColor().equals("red"))
                .filter(apple -> apple.getOrigin().equals("湖南")).collect(Collectors.toList());
    }

    //求出每个颜色的平均重量
    public static void testTwo(){
    //    1，基于颜色分组,然后求出每个颜色的平均重量
        apples.stream().collect(Collectors.groupingBy(apple -> apple.getColor(),   //基于颜色分组
                                Collectors.averagingInt(value -> value.getWeight())))  //统计平均重量
                .forEach((s, aDouble) -> System.out.println(s+":"+aDouble));
    }

    public static void testThree(){
        //new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        System.out.println("hello world ");
        //    }
        //}).start();

        new Thread(() -> System.out.println("hello world ")).start();
    }


}

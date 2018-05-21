package com.xz.fld.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class IDUtils {

    private static final int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};

    public static String createImageName(String typeName) {
        return typeName + "_" + System.currentTimeMillis() + new Random().nextInt(10);
    }

    public static String createUserId() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return DateUtils.dateToString(new Date(), DateUtils.patter_str_yyyymmddhhmmss) + (random.nextInt(100000) + 100000);
    }

    public static String createOrderId() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return DateUtils.dateToString(new Date(), DateUtils.patter_str_yyyymmddhhmmss) + (random.nextInt(100000) + 100000);
    }

    public static String createWithdrawId() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return DateUtils.dateToString(new Date(), DateUtils.patter_str_yyyymmddhhmmss) + (random.nextInt(100000) + 100000);
    }


    public static String createCode() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String code = "";
        for (int i = 0; i < 4; i++) {
            code += random.nextInt(nums.length);
        }

        return code;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(IDUtils.createImageName("banner"));
//        }

        ThreadLocalRandom random = ThreadLocalRandom.current();


        Set<String> set = new HashSet<>(10000);

//        for (int i = 0; i < 10000; i++) {
//            String id = DateUtils.dateToString(new Date(), DateUtils.patter_str_yyyymmddhhmmss) + (random.nextInt(100000) + 100000);
//            System.out.println(id);
//            set.add(id);
//        }

        for (int i = 0; i < 100; i++) {
            System.out.println(createCode());
        }

//        System.out.println(set.size());

    }
}

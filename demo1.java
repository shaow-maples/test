package cn.itcast;
            /*1.买牌
              2.洗牌
              3.发牌
              4.看牌*/

import java.util.*;



public class demo1 {
    public static void main(String[] args) {
//      1.买牌
//      1.1定义一个双列集合.键表示牌的编号，值表示具体的牌。编号越小，牌就越小
        Map<Integer, String> pokers = new HashMap<>();
//      1.2定义一个单列集合，用来存储所有牌的编号
        List<Integer> list = new ArrayList<>();
//      1.3具体的买牌动作
//        普通牌，52
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
//        造普通牌
        int num = 0;
        for (String number : numbers) {  //外循环：循环所有点数
            for (String color : colors) { //内循环：循环所有花色
                String poker = number + color;
//                将牌的编号，具体的牌放到双列集合中
                pokers.put(num, poker);
//                将牌的编号放在单列集合中
                list.add(num);
//                每添加一张牌，编号要自增1
                num++;

            }
        }
//        大小王
//            添加小王
        pokers.put(num, "小王");
        list.add(num++);
//            添加大王
        pokers.put(num, "大王");
        list.add(num);
        System.out.println("所有的牌：" + pokers);
        System.out.println("牌的编号" + list);
//      2.洗牌
        Collections.shuffle(list);
        System.out.println("洗好后的牌的编号为：" + list);
//      3.发牌
//      3.1定义四个集合，表示三个玩家和底牌
        List<Integer> lubenwei = new ArrayList<>();
        List<Integer> doushen = new ArrayList<>();
        List<Integer> duguai = new ArrayList<>();
        List<Integer> dipai = new ArrayList<>();

//      3.2具体的发牌，将索引和3取模，确定牌发给谁
        for (int i = 0; i < list.size(); i++) {
            Integer pokerNum = list.get(i);
//            System.out.println(pokerNum);
            if (i >= list.size() - 3) {
                dipai.add(pokerNum);
            } else if (i % 3 == 0) {
                lubenwei.add(pokerNum);
            } else if (i % 3 == 1) {
                doushen.add(pokerNum);
            } else if (i % 3 == 2) {
                duguai.add(pokerNum);
            }
//      3.3查看玩家，底牌的编号
//            System.out.println("lubenwei:" + lubenwei);
//            System.out.println("doushen:" + doushen);
//            System.out.println("duguai:" + duguai);
//            System.out.println("dipai:" + dipai);
        }
        System.out.println("lubenwei: " + printPoker(lubenwei, pokers));
        System.out.println("zhaoliying: " + printPoker(doushen, pokers));
        System.out.println("xiaohei: " + printPoker(duguai, pokers));
        System.out.println("dipai: " + printPoker(dipai, pokers));
    }
//      4.看牌
        /*定义一个方法，用来看牌
          方法名： printPoker
          参数列表：List<Integer>,Map<Integer,String>
          返回值：String*/
        public static String printPoker(List<Integer> nums,Map<Integer,String> pokers){
            Collections.sort(nums);
            StringBuilder sb = new StringBuilder();
            for (Integer num : nums) {
                String poker = pokers.get(num);
                sb.append(poker + " ");


            }
            String str = sb.toString();
            return str.trim();
        }








    }


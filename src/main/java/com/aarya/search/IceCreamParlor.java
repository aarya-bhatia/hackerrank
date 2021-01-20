package com.aarya.search;

import java.util.*;

public class IceCreamParlor {

    private static class CostToIdTable {
        private HashMap<Integer, String> map = new HashMap<>();
        private int index = 1;

        public void addFlavor(int cost) {
            String idList = (map.containsKey(cost) ? map.get(cost) + " " : "") + index;
            map.put(cost, idList);
            index++;
        }

        int getFirstId(String idList) {
            return Integer.parseInt(idList.split(" ")[0]);
        }

        int getLastId(String idList) {
            return Integer.parseInt(idList.split(" ")[1]);
        }

        public void solve(int total) {
            for (Map.Entry<Integer, String> item : map.entrySet()) {
                String idList = item.getValue();

                int itemId = getFirstId(idList);
                int itemCost = item.getKey();

                int otherCost = total - itemCost;

                if (!map.containsKey(otherCost)) {
                    continue;
                }

                int otherId;

                if (otherCost == itemCost) {
                    otherId = getLastId(idList);
                } else {
                    otherId = getFirstId(map.get(otherCost));
                }

                System.out.println(Math.min(itemId, otherId) + " " + Math.max(itemId, otherId));
                break;
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                CostToIdTable table = new CostToIdTable();
                int money = sc.nextInt();
                int numItems = sc.nextInt();

                for (int j = 0; j < numItems; j++) {
                    int itemCost = sc.nextInt();
                    table.addFlavor(itemCost);
                }

                table.solve(money);
            }
        }
    }
}

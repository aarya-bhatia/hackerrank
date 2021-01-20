package com.aarya.hashmaps;

import java.util.*;

public class FrequencyQueries {

	private class FrequencyCounter<T> {
		HashMap<T, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> rev = new HashMap<>();

		public void add(T e) {
			if(map.containsKey(e)) {
				int val = map.get(e);
				map.put(e, val + 1);
				update(val, val+1);
			}
			else {
				map.put(e, 1);
				update(0, 1);
			}
		}

		public void update(int countOld, int countNew) {
			if(rev.containsKey(countOld)) {
				rev.put(countOld, rev.get(countOld) - 1);
			}
			if(countNew <= 0) {
				return;
			}
			if(rev.containsKey(countNew)) {
				rev.put(countNew, rev.get(countNew) + 1);
			}
			else {
				rev.put(countNew, 1);
			}
		}

		public void remove(T e) {
			if(map.containsKey(e)) {
				int val = map.get(e);
				if(val == 0) {
					return;
				}
				map.put(e, val - 1);
				update(val, val - 1);
			}
		}

		public int hasElementWithFrequency(int f) {
			return rev.containsKey(f) ? 1 : 0;
		}

		public void showMap() {
			System.out.println(map);
		}

		public void showRev() {
			System.out.println(rev);
		}
	}

	public static void main(String args[]) {
		FrequencyQueries s = new FrequencyQueries();
		FrequencyCounter<Integer> counter = s.new FrequencyCounter<>();
		try(Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt();
			for(int i = 0; i < q; i++) {
				int queryType = sc.nextInt();
				int queryData = sc.nextInt();

				switch(queryType) {
					case 1: counter.add(queryData);
						break;
					case 2: counter.remove(queryData);
						break;
					case 3: System.out.println(counter.hasElementWithFrequency(queryData));
						break;
					default: break;
				}

				counter.showMap();
				counter.showRev();
			}
		}
	}

}


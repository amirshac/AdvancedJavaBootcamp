package multithreading.exercise4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Runner {

	private static final int DELAY = 1;
	private static final int LIST1_START = 0;
	private static final int LIST1_END = 999;
	private static final int LIST2_START = 1000;
	private static final int LIST2_END = 1999;

	static List<Integer> list1 = new ArrayList<Integer>();
	static List<Integer> list2 = new ArrayList<Integer>();

	public static void populateLists() {
		for (int i = LIST1_START; i <= LIST1_END; i++) {
			list1.add(i);
		}

		for (int i = LIST2_START; i <= LIST2_END; i++) {
			list2.add(i);
		}
	}

	public static void main(String[] args) {
		Thread thread1;
		Thread thread2;

		populateLists();
		thread1 = new Thread(new FindNegativeThread(), "find negative thread");
		thread2 = new Thread(new FindCommonThread(), "find common thread");
	}

	public static class FindNegativeThread extends Thread {
		@Override
		public void run() {

			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i) < 0) {
					System.out.println("negative found at index " + i);
					return;
				}

				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					return;
				}
			}

			System.out.println("no negative found");
		}
	}

	public static class FindCommonThread extends Thread {
		@Override
		public void run() {

			for (int i = 0; i < list1.size(); i++) {
				if (list2.contains(list1.get(i))) {
					System.out.println("found common at index " + i);
					return;
				}

				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					return;
				}
			}

			System.out.println("no common found");
		}
	}

}

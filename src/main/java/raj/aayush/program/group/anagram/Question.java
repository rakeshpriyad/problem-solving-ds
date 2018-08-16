package raj.aayush.program.group.anagram;

import java.util.Arrays;

import raj.aayush.system.design.lib.AssortedMethods;

public class Question {
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		System.out.println(AssortedMethods.stringArrayToString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println(AssortedMethods.stringArrayToString(array));
	}
}

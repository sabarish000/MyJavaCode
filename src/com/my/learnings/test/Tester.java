package com.my.learnings.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Tester {
	public static void main(String[] args) {
		StringJoiner sj= new StringJoiner(",");
		sj.add("ABC").add("XYZ").add("DEF");
		//System.out.println(sj);

		int x = Stream.of(23,25,12,7,3,56,865).min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(x);

		ArrayList<String> phonetics = new ArrayList<String>();

		System.out.println("List"+ phonetics);
	}
}

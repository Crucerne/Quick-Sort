package com.crucerne.www.quicksort;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {

	/*
	 * The method takes a list collection of integers as argument and sorts the
	 * list via quicksort. The algorithm involves partitioning the original list
	 * into smaller parts until only a single element is in each partition. The
	 * partitioning process takes the first element of the list as the pivot and
	 * partitions the remaining elements into 2 partitions, 1 for elements'
	 * value less than the pivot and 1 for elements' value greater than the
	 * pivot. Once the list is partitioned, the two partitions each call the
	 * same method recursively, making them sorted. The lower, pivot, and higher
	 * partitions are finally merged together into a list collection to return.
	 */
	public static List<Integer> quicksort(List<Integer> numbers) {
		// Returns the argument if the size is less than 2. Partitioning no
		// longer required.
		if (numbers.size() < 2) {
			return numbers;
		}

		// Choosing the first element in the list as the pivot.
		Integer pivot = numbers.get(0);

		// Creating two list collections to partition the numbers lesser and
		// greater than the pivot.
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();

		// Screening the remaining numbers in the list to determine which values
		// goes into
		// the lower and higher partitions.
		for (int i = 1; i < numbers.size(); i++) {
			// Current value is less than the pivot, thus adding it to the lower
			// partition.
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			}
			// Current value is greater than the pivot, thus adding it to the
			// higher partition.
			else {
				higher.add(numbers.get(i));
			}
		}

		// Instantiate a sorted list to return and begin the merging process by
		// recursively obtaining the lower sorted partition.
		List<Integer> sorted = quicksort(lower);

		// Add the pivot back into the sorted list.
		sorted.add(pivot);
		// Add the remaining sorted higher partition to the sorted list.
		sorted.addAll(quicksort(higher));

		return sorted;
	}

}

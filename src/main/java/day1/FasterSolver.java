package day1;

import java.util.HashSet;
import java.util.Set;

public class FasterSolver implements Day1Solver {

	@Override
	public boolean canSumUpTo(int[] a, int sum) {

		if (a.length < 2) {
			return false;
		}

		Set<Integer> lower = new HashSet<Integer>(a.length/2);
		Set<Integer> bigger = new HashSet<Integer>(a.length/2);
		Set<Integer> dupes = new HashSet<Integer>();
		// first pass
		for (int j = 1; j < a.length; j++) {
			if (dupes.contains(a[j])) {
				continue;
			}
			
			
			if (a[0] + a[j] == sum) {
				return true;
			} else if (a[0] + a[j] > sum) {
				if (lower.contains(a[j])) {
					dupes.add(a[j]);
				} else {
					lower.add(a[j]);
				}
			} else {
				if (bigger.contains(a[j])) {
					dupes.add(a[j]);
				} else {
					bigger.add(a[j]);
				}
			}
		}

		if (sum % 2 == 0) {
			for (int i : dupes) {
				if (i + i == sum) {
					return true;
				}
			}
		}

		for (int i : lower) {
			for (int j : bigger) {
				if (i + j == sum) {
					return true;
				}
			}
		}

		return false;
	}

}

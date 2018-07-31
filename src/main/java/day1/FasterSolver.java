package day1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FasterSolver implements Day1Solver {

	@Override
	public boolean canSumUpTo(int[] a, int sum) {

		if (a.length < 2) {
			return false;
		}

		Set<Integer> possible = Arrays.stream(a).boxed().collect(Collectors.toSet());
		
		for (int i = 0; i < a.length; i++) {
			if (possible.contains(sum - a[i])) {
				return true;
			}
		}
		return false;
	}

}

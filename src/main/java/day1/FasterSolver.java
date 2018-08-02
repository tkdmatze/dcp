package day1;

public class FasterSolver implements Day1Solver {

	@Override
	public boolean canSumUpTo(int[] a, int sum) {

		if (a.length < 2) {
			return false;
		}

		boolean[] missing = new boolean[sum];

		// first pass
		int half = sum / 2;
		boolean even = (sum % 2 == 0);
		boolean firstHalfFound = false;
		for (int j = 0; j < a.length; j++) {
			if (a[j] > sum || a[j] < 1) {
				continue;
			}
			if (even && a[j] == half) {
				if (!firstHalfFound) {
					firstHalfFound = true;
				} else {
					return true;
				}
				continue;
			}

			if (missing[a[j]]) {
				return true;
			}
			missing[sum - a[j]] = true;

		}

		for (int j = 0; j < a.length; j++) {
			if (a[j] > sum || a[j] < 1) {
				continue;
			}
			if (missing[a[j]]) {
				return true;
			}
		}

		return false;
	}

}

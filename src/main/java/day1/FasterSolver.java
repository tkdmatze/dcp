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
		for (int anA : a) {
			if (anA > sum || anA < 1) {
				continue;
			}
			if (even && anA == half) {
				if (!firstHalfFound) {
					firstHalfFound = true;
				} else {
					return true;
				}
				continue;
			}

			if (missing[anA]) {
				return true;
			}
			missing[sum - anA] = true;

		}

		for (int anA : a) {
			if (anA > sum || anA < 1) {
				continue;
			}
			if (missing[anA]) {
				return true;
			}
		}

		return false;
	}

}

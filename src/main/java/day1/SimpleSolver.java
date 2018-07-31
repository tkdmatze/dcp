package day1;

public class SimpleSolver implements Day1Solver {

	@Override
	public boolean canSumUpTo(int[] a, int sum) {

		if (a.length < 2) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == sum) {
					return true;
				}
			}
		}

		return false;
	}

}

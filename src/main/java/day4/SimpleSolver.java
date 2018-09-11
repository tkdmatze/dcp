package day4;

import java.util.Arrays;

public class SimpleSolver implements Day4Solver {

	@Override
	public int solve(int[] in) {
		int result = 1;
		Arrays.sort(in); // magic ;)
		for (int anIn : in) {
			if (anIn > 0) {
				if (anIn == result) {
					result++;
				} else {
					return result;
				}
			}

		}
		return result;
	}

}

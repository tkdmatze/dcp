package day2;

public class SimpleSolverWithoutDivision implements Day2Solver {

	@Override
	public int[] solve(int[] in) {
		int[] result = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			result[i] = 1;
			for (int j = 0; j < in.length; j++) {
				if (i != j) {
					result[i] *= in[j];
				}
			}
		}
		return result;
	}

}

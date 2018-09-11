package day2;

public class SimpleSolver implements Day2Solver {

	@Override
	public int[] solve(int[] in) {
		int prod = 1;
		for (int anIn : in) {
			prod *= anIn;
		}
		int[] result = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			result[i] = prod / in[i];
		}
		return result;
	}
}

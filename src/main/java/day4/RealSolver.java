package day4;

public class RealSolver implements Day4Solver {

    @Override
    public int solve(int[] in) {
        int result = 1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == result) {
                result++;
            } else if (in[i] > result) {
                for (int j = i + 1; j < in.length; j++) {
                    if (in[j] < in[i]) {
                        int tmp = in[i];
                        in[i] = in[j];
                        in[j] = tmp;
                        if (i > 0) {
                            i--;
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }


}

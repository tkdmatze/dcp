package day4;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Day4SolverTest {
    private static final Day4Solver solver1 = new SimpleSolver();
    private static final Day4Solver solver2 = new RealSolver();
    @Parameters(name = "{index}: solve({0}) ) {1} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{ //
                // first solver
                {new int[]{3, 4, -1, 1}, 2}, // given example
                {new int[]{1, 2, 0}, 3}, // given example2
                {new int[]{1, 2, 4, 8, 16}, 3},
                {new int[]{16, 8, 4, 2, 1}, 3},
                {new int[]{2, 4, -1, 1}, 3} // given example

        });
    }

    private final int[] in;

    private final int expected;

    public Day4SolverTest(int[] input, int expected) {
        this.in = input;
        this.expected = expected;

    }

    @Test
    public void Simple() {
        Assert.assertEquals(expected, solver1.solve(Arrays.copyOf(in, in.length)));

    }

    @Test
    public void Real() {
        Assert.assertEquals(expected, solver2.solve(Arrays.copyOf(in, in.length)));

    }

}

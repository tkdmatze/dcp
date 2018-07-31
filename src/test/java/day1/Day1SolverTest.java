package day1;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Day1SolverTest {

	static int[] veryLongArray = new int[Integer.MAX_VALUE / 8];
	static Day1Solver solver1 = new SimpleSolver();
	static Day1Solver solver2 = new FasterSolver();

	static {
		for (int i = 0; i < veryLongArray.length - 1; i++) {
			veryLongArray[i] = 1;
		}
		veryLongArray[veryLongArray.length - 1] = 2;
	}

	@Parameters(name = "{index}: canSumUpTo({0},{1}) ) {2} with solver {3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				// first solver
				{ new int[] { 10, 15, 3, 7 }, 17, true, solver1 }, // given example
				{ new int[] {}, 17, false, solver1 }, // empty array
				{ new int[] { 17 }, 17, false, solver1 }, // size-1-array
				{ new int[] { 1, 2, 3, 4 }, 8, false, solver1 }, // does not sum up
				{ veryLongArray, 3, true, solver1 }, // verrrry long array
				// second solver
				{ new int[] { 10, 15, 3, 7 }, 17, true, solver2 }, // given example
				{ new int[] {}, 17, false, solver2 }, // empty array
				{ new int[] { 17 }, 17, false, solver2 }, // size-1-array
				{ new int[] { 1, 2, 3, 4 }, 8, false, solver2 }, // does not sum up
				{ veryLongArray, 3, true, solver2 }, // verrrry long array

		});
	}

	private int[] in;

	private int sum;
	private boolean result;
	private Day1Solver solver;

	public Day1SolverTest(int[] input, int expected, boolean result, Day1Solver solver) {
		this.in = input;
		this.sum = expected;
		this.result = result;
		this.solver = solver;
	}

	@Test
	public void Simple() {

		Assert.assertEquals(result, solver.canSumUpTo(in, sum));

	}

}

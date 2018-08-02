package day2;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Day2SolverTest {
	static Day2Solver solver1 = new SimpleSolver();

	@Parameters(name = "{index}: canSumUpTo({0},{1}) ) {2} with solver {3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				// first solver
				{ new int[] {1, 2, 3, 4, 5 },  new int[] {120, 60, 40, 30, 24 },  solver1 }, // given example
				{ new int[] {3, 2, 1}, new int[] {2, 3, 6}, solver1 }, // given example2
		

		});
	}

	private int[] in;

	private int[] expected;

	private Day2Solver solver;

	public  Day2SolverTest(int[] input, int[] expected, Day2Solver solver) {
		this.in = input;
		this.expected = expected;
		
		this.solver = solver;
	}

	@Test
	public void Simple() {

		Assert.assertArrayEquals(expected, solver.solve(in));

	}

}

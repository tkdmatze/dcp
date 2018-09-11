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
	private static final Day2Solver solver1 = new SimpleSolver();
	private static final Day2Solver solver2 = new SimpleSolverWithoutDivision();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				// first solver
				{ new int[] { 1, 2, 3, 4, 5 }, new int[] { 120, 60, 40, 30, 24 } }, // given example
				{ new int[] { 3, 2, 1 }, new int[] { 2, 3, 6 } }, // given example2
				{ new int[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23 }, new int[] { 223092870, 111546435, 74364290, 44618574,
						31870410, 20281170, 17160990, 13123110, 11741730, 9699690 } }, // primes

		});
	}

	private final int[] in;

	private final int[] expected;

	public Day2SolverTest(int[] input, int[] expected) {
		this.in = input;
		this.expected = expected;

	}

	@Test
	public void Simple() {

		Assert.assertArrayEquals(expected, solver1.solve(in));

	}

	@Test
	public void SimpleWithoutDivision() {

		Assert.assertArrayEquals(expected, solver2.solve(in));

	}

}

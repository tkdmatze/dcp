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
	// this is the not hardest thing, done in the first move, but to watch overhead by optimisation
	static int[] veryLongArray = new int[Short.MAX_VALUE * 1024];
	// solution are the last 2 entries which are equal (dupes)
	static int[] interChangeingArrayManyDupes = new int[Short.MAX_VALUE * 2];
	// solution are the last 2 entries which are not equal
	static int[] interChangeingArrayManyDupesNoDupeAtEnd = new int[Short.MAX_VALUE *2];
	static Day1Solver solver1 = new SimpleSolver();
	static Day1Solver solver2 = new FasterSolver();

	static {
		for (int i = 0; i < veryLongArray.length - 1; i++) {
			veryLongArray[i] = 1;
		}
		veryLongArray[veryLongArray.length - 1] = 2;

		for (int i = 0; i < interChangeingArrayManyDupes.length / 2 - 1; i++) {
			interChangeingArrayManyDupes[i * 2] = 3;
			interChangeingArrayManyDupes[i * 2 + 1] = 6;
		}
		interChangeingArrayManyDupes[interChangeingArrayManyDupes.length - 2] = 4;
		interChangeingArrayManyDupes[interChangeingArrayManyDupes.length - 1] = 4;
		
		for (int i = 0; i < interChangeingArrayManyDupesNoDupeAtEnd.length / 2 - 1; i++) {
			interChangeingArrayManyDupesNoDupeAtEnd[i * 2] = 3;
			interChangeingArrayManyDupesNoDupeAtEnd[i * 2 + 1] = 11;
		}
		interChangeingArrayManyDupesNoDupeAtEnd[interChangeingArrayManyDupesNoDupeAtEnd.length - 2] = 2;
		interChangeingArrayManyDupesNoDupeAtEnd[interChangeingArrayManyDupesNoDupeAtEnd.length - 1] = 8;
	}

	@Parameters(name = "{index}: canSumUpTo({0},{1}) ) {2} with solver {3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				// first solver
				{ new int[] { 10, 15, 3, 7 }, 17, true, solver1 }, // given example
				{ new int[] {}, 17, false, solver1 }, // empty array
				{ new int[] { 17 }, 17, false, solver1 }, // size-1-array
				{ new int[] { 1, 2, 3, 4 }, 8, false, solver1 }, // does not sum up
				{ interChangeingArrayManyDupes, 8, true, solver1 }, // verrrry long array 1.101s
				{ interChangeingArrayManyDupesNoDupeAtEnd, 10, true, solver1 }, // verrrry long array 1.093s
				{ veryLongArray, 3, true, solver1 }, // verrrry long array 0.021s
				// second solver
				{ new int[] { 10, 15, 3, 7 }, 17, true, solver2 }, // given example
				{ new int[] {}, 17, false, solver2 }, // empty array
				{ new int[] { 17 }, 17, false, solver2 }, // size-1-array
				{ new int[] { 1, 2, 3, 4 }, 8, false, solver2 }, // does not sum up
				{ interChangeingArrayManyDupes, 8, true, solver2 }, // verrrry long array 0.005s
				{ interChangeingArrayManyDupesNoDupeAtEnd, 10, true, solver2 }, // verrrry long array 0.003s
				{ veryLongArray, 3, true, solver2 }, // verrrry long array 0.284 .. slower then simple because of many inits

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

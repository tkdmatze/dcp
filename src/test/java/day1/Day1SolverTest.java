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

    private static final Day1Solver solver1 = new SimpleSolver();
    private static final Day1Solver solver2 = new FasterSolver();

    // this is the not hardest thing, done in the first move, but to watch overhead
    // by optimisation
    private static final int[] veryLongArray = new int[Short.MAX_VALUE * 1024];
    // solution are the last 2 entries which are equal (dupes)
    private static final int[] interChangeingArrayManyDupes = new int[Short.MAX_VALUE * 2];
    // solution are the last 2 entries which are not equal
    private static final int[] interChangeingArrayManyDupesNoDupeAtEnd = new int[Short.MAX_VALUE * 2];
    private static final int[] impossibleAboveHalf = new int[Short.MAX_VALUE * 2];

    private static final int realLifeExampleLength = Short.MAX_VALUE * 2048;
    private static final int[] realLifeExample1 = new int[realLifeExampleLength];
    private static final int[] realLifeExample2 = new int[realLifeExampleLength];
    private static final int[] realLifeExample3 = new int[realLifeExampleLength];
    private static final int[] realLifeExample4 = new int[realLifeExampleLength];
    private static int example1Sum = 0;
    private static int example2Sum = 0;
    private static int example3Sum = 0;
    private static int example4Sum = 0;

    // prepare data
    static {
        Arrays.setAll(veryLongArray, i -> 1);
        veryLongArray[veryLongArray.length - 1] = 2;

        Arrays.setAll(impossibleAboveHalf, i -> 6);

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
        for (int i = 0; i < realLifeExampleLength; i++) {
            realLifeExample1[i] = (int) (Math.random() * realLifeExampleLength);
            realLifeExample2[i] = (int) (Math.random() * realLifeExampleLength);
            realLifeExample3[i] = (int) (Math.random() * realLifeExampleLength);
            realLifeExample4[i] = (int) (Math.random() * realLifeExampleLength);
        }
        example1Sum = realLifeExample1[(int) (Math.random() * realLifeExampleLength)]
                + realLifeExample1[(int) (Math.random() * realLifeExampleLength)];
        example2Sum = realLifeExample2[(int) (Math.random() * realLifeExampleLength)]
                + realLifeExample2[(int) (Math.random() * realLifeExampleLength)];
        example3Sum = realLifeExample3[(int) (Math.random() * realLifeExampleLength)]
                + realLifeExample3[(int) (Math.random() * realLifeExampleLength)];
        example4Sum = realLifeExample4[(int) (Math.random() * realLifeExampleLength)]
                + realLifeExample4[(int) (Math.random() * realLifeExampleLength)];

    }

    @Parameters(name = "{index}: canSumUpTo({1}) ) {2} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{ //

                {new int[]{10, 15, 3, 7}, 17, true}, // given example
                {new int[]{}, 17, false}, // empty array
                {new int[]{17}, 17, false}, // size-1-array

                {new int[]{1, 2, 3, 4}, 8, false}, // does not sum up

                {interChangeingArrayManyDupes, 8, true}, //
                {interChangeingArrayManyDupesNoDupeAtEnd, 10, true}, //
                {veryLongArray, 3, true}, //
                {impossibleAboveHalf, 8, false}, //
                {realLifeExample1, example1Sum, true}, //
                {realLifeExample2, example2Sum, true}, //
                {realLifeExample3, example3Sum, true}, //
                {realLifeExample4, example4Sum, true}, //

        });
    }

    private int[] in;

    private int sum;
    private boolean result;

    public Day1SolverTest(int[] input, int expected, boolean result) {
        this.in = input;
        this.sum = expected;
        this.result = result;

    }

    @Test
    public void testSolver1() {
        Assert.assertEquals(result, solver1.canSumUpTo(in, sum));

    }

    @Test
    public void testSolver2() {
        Assert.assertEquals(result, solver2.canSumUpTo(in, sum));
    }

}

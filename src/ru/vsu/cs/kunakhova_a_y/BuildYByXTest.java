package ru.vsu.cs.kunakhova_a_y;

import org.junit.Assert;
import org.junit.Test;

public class BuildYByXTest {

        BuildYByX buildYByX = new BuildYByX();

        @Test
        public void testBuildY1() throws Exception {
            int input = 12393289;

            int expectedResult = 98239321;

            int factualResult = buildYByX.buildY(input);
            int factualResultStandard = buildYByX.buildYStandard(input);
            int factualResultRecurse = buildYByX.buildYByXRecursive(input);

            Assert.assertEquals(expectedResult, factualResult);
            Assert.assertEquals(expectedResult, factualResultStandard);
            Assert.assertEquals(expectedResult, factualResultRecurse);
        }

        @Test
        public void testBuildY2() throws Exception {
            int input = 121211212;

            int expectedResult = 212112121;

            int factualResult = buildYByX.buildY(input);
            int factualResultStandard = buildYByX.buildYStandard(input);
            int factualResultRecurse = buildYByX.buildYByXRecursive(input);

            Assert.assertEquals(expectedResult, factualResult);
            Assert.assertEquals(expectedResult, factualResultStandard);
            Assert.assertEquals(expectedResult, factualResultRecurse);
        }
        @Test
        public void testBuildY3() throws Exception {
            int input = 123045;

            int expectedResult = 540321;

            int factualResult = buildYByX.buildY(input);
            int factualResultStandard = buildYByX.buildYStandard(input);
            int factualResultRecurse = buildYByX.buildYByXRecursive(input);

            Assert.assertEquals(expectedResult, factualResult);
            Assert.assertEquals(expectedResult, factualResultStandard);
            Assert.assertEquals(expectedResult, factualResultRecurse);
        }
    }


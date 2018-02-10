/*
 * Copyright (c) 2018 SilkSource.
 */
package io.silksource.silk.test;

import static org.junit.Assert.assertEquals;

import static io.silksource.silk.unittest.FullyQualifiedNameBuilder.someFullyQualifiedName;

import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

import io.silksource.silk.code.api.FullyQualifiedName;
import io.silksource.silk.test.ct.InMemoryTestImpactMap;
import io.silksource.silk.test.ct.TestImpactMap;


public class WhenAnalyzingTheImpactOfTests {

  private final TestImpactMap testImpactMap = new InMemoryTestImpactMap();

  @Test
  public void shouldRegisterWhichTestsTouchAGivenSource() {
    FullyQualifiedName testName1 = someFullyQualifiedName();
    FullyQualifiedName testName2 = someFullyQualifiedName();
    FullyQualifiedName sourceName1 = someFullyQualifiedName();
    FullyQualifiedName sourceName2 = someFullyQualifiedName();
    FullyQualifiedName sourceName3 = someFullyQualifiedName();

    testImpactMap.testTouches(testName1, Arrays.asList(sourceName1, sourceName2));
    testImpactMap.testTouches(testName2, Arrays.asList(sourceName1));

    assertIsTouchedBy(sourceName1, testName1, testName2);
    assertIsTouchedBy(sourceName2, testName1);
    assertIsTouchedBy(sourceName3);
  }

  private void assertIsTouchedBy(FullyQualifiedName sourceName, FullyQualifiedName... testNames) {
    assertEquals("Tests touching " + sourceName, new TreeSet<>(Arrays.asList(testNames)),
        testImpactMap.testsTouching(sourceName));
  }

  @Test
  public void shouldRemovePreviouslyRegisteredTouches() {
    FullyQualifiedName testName = someFullyQualifiedName();
    FullyQualifiedName sourceName1 = someFullyQualifiedName();
    FullyQualifiedName sourceName2 = someFullyQualifiedName();

    testImpactMap.testTouches(testName, Arrays.asList(sourceName1, sourceName2));
    testImpactMap.testTouches(testName, Arrays.asList(sourceName1));

    assertIsTouchedBy(sourceName1, testName);
    assertIsTouchedBy(sourceName2);
  }

}
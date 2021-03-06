/*
 * Copyright (c) 2018 SilkSource.
 */
package io.silksource.silk.testing.runner;

import java.util.Set;

import io.silksource.silk.coding.api.Method;
import io.silksource.silk.coding.api.Project;


public interface TestRunner {

  Set<Method> findTestMethodsIn(Project project);

  void runTest(Method testMethod, TestListener listener);

}

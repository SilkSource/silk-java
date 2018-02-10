/*
 * Copyright (c) 2018 SilkSource.
 */
package io.silksource.silk.code.file;

import io.silksource.silk.code.api.Member;
import io.silksource.silk.code.api.Type;


public class DefaultMember implements Member {

  private final Type ownerType;
  private final String name;

  public DefaultMember(Type ownerType, String name) {
    this.ownerType = ownerType;
    this.name = name;
  }

  @Override
  public Type getOwningType() {
    return ownerType;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format("%s.%s", ownerType, name);
  }

}

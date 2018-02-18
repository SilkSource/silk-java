/*
 * Copyright (c) 2018 SilkSource.
 */
package io.silksource.silk.coding.event;

import io.silksource.silk.coding.api.Type;


public class TypeChangedEvent extends TypeBasedEvent {

  public TypeChangedEvent(Type type) {
    super(type);
  }

}

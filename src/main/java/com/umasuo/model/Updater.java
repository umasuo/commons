package com.umasuo.model;

/**
 * Updater.
 */
public interface Updater<E, A> {

  /**
   * update action handler.
   *
   * @param entity entity
   * @param action action
   */
  void handle(E entity, A action);
}

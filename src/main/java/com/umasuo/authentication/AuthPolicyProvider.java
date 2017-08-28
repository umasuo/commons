package com.umasuo.authentication;

import org.springframework.util.Assert;

/**
 * This provider provide an tool to check the authentication of the token.
 * default policy provider.
 */
public interface AuthPolicyProvider {

  /**
   * check the authentication of the token
   *
   * @param token token input.
   */
  default void checkToken(String token) {
    Assert.notNull(token);

    // TODO: 17/8/28 check token
  }

}

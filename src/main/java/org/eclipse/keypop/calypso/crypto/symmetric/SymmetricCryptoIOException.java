/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.symmetric;

/**
 * Indicates that an IO error occurred when processing a command.
 *
 * @since 0.1.0
 */
public final class SymmetricCryptoIOException extends Exception {

  /**
   * @param message The message to identify the exception context.
   * @since 0.1.0
   */
  public SymmetricCryptoIOException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 0.1.0
   */
  public SymmetricCryptoIOException(String message, Throwable cause) {
    super(message, cause);
  }
}

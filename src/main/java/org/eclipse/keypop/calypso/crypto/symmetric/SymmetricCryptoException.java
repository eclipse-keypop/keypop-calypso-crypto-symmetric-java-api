/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.crypto.symmetric;

/**
 * Indicates that an error occurred when processing a command.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-symmetric-uml-api/0.1.2-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoSymmetric_v0.1.2-SNAPSHOT.html#type_SymmetricCryptoException">SymmetricCryptoException</a>
 * for the normative contract.
 *
 * @since 0.1.0
 */
public final class SymmetricCryptoException extends Exception {

  /**
   * @param message The message to identify the exception context.
   * @since 0.1.0
   */
  public SymmetricCryptoException(String message) {
    super(message);
  }

  /**
   * Encapsulates a lower level exception.
   *
   * @param message Message to identify the exception context.
   * @param cause The cause.
   * @since 0.1.0
   */
  public SymmetricCryptoException(String message, Throwable cause) {
    super(message, cause);
  }
}

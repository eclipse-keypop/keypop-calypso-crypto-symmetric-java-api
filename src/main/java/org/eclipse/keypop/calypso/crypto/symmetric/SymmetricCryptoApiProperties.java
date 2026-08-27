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
 * Immutable properties of the Symmetric Crypto API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-calypso-crypto-symmetric-uml-api/0.1.2-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-CalypsoCryptoSymmetric_v0.1.2-SNAPSHOT.html#type_SymmetricCryptoApiProperties">SymmetricCryptoApiProperties</a>
 * for the normative contract.
 *
 * @since 0.1.0
 */
public final class SymmetricCryptoApiProperties {

  /**
   * Version of the API implemented by this binding, as a "MAJOR.MINOR" dotted decimal: {@value}
   *
   * @since 0.1.0
   */
  public static final String VERSION = "0.1";

  /** Private constructor */
  private SymmetricCryptoApiProperties() {}
}

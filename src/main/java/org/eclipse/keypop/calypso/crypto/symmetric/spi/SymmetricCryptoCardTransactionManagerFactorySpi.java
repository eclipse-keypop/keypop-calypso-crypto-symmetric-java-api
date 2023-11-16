/* ******************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.eclipse.keypop.calypso.crypto.symmetric.spi;

import java.util.List;
import org.eclipse.keypop.calypso.crypto.symmetric.SymmetricCryptoException;
import org.eclipse.keypop.calypso.crypto.symmetric.SymmetricCryptoIOException;

/**
 * Factory of {@link SymmetricCryptoCardTransactionManagerSpi}.
 *
 * @since 0.1.0
 */
public interface SymmetricCryptoCardTransactionManagerFactorySpi {

  /**
   * Indicates if the "extended" mode is supported.
   *
   * @return True if the "extended" mode is supported, false otherwise.
   * @since 0.1.0
   */
  boolean isExtendedModeSupported();

  /**
   * Returns the max length supported of the card APDU.
   *
   * @return A positive value.
   * @since 0.1.0
   */
  int getMaxCardApduLengthSupported();

  /**
   * Retrieves and stores the terminal challenge in the SAM image for later use.
   *
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void preInitTerminalSessionContext() throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Returns a new instance of {@link SymmetricCryptoCardTransactionManagerSpi}.
   *
   * @param cardKeyDiversifier The card key diversifier to use for the coming cryptographic
   *     computations.
   * @param useExtendedMode Request the use of the extended mode if supported by the crypto service.
   * @param transactionAuditData The reference of the list where the transaction audit data are
   *     recorded.
   * @return A new instance of {@link SymmetricCryptoCardTransactionManagerSpi}.
   * @throws IllegalStateException If the extended mode is not supported.
   * @since 0.1.0
   */
  SymmetricCryptoCardTransactionManagerSpi createCardTransactionManager(
      byte[] cardKeyDiversifier, boolean useExtendedMode, List<byte[]> transactionAuditData);
}

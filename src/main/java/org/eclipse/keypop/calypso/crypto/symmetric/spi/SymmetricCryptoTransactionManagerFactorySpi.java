/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * This file is part of Eclipse Keypop.
 *
 * Eclipse Keypop is free software: you can redistribute it and/or modify
 * it under the terms of the MIT License. A copy of the License is located at
 *
 * http://opensource.org/licenses/MIT
 ************************************************************************************** */
package org.eclipse.keypop.calypso.crypto.symmetric.spi;

import java.util.List;

/**
 * Factory of {@link SymmetricCryptoTransactionManagerSpi}.
 *
 * @since 0.1.0
 */
public interface SymmetricCryptoTransactionManagerFactorySpi {

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
   * Returns a new instance of {@link SymmetricCryptoTransactionManagerSpi}.
   *
   * @param cardKeyDiversifier The card key diversifier to use for the coming cryptographic
   *     computations.
   * @param useExtendedMode Request the use of the extended mode if supported by the crypto service.
   * @param transactionAuditData The reference of the list where the transaction audit data are
   *     recorded.
   * @return A new instance of {@link SymmetricCryptoTransactionManagerSpi}.
   * @throws IllegalStateException If the extended mode is not supported.
   * @since 0.1.0
   */
  SymmetricCryptoTransactionManagerSpi createTransactionManager(
      byte[] cardKeyDiversifier, boolean useExtendedMode, List<byte[]> transactionAuditData);
}

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
import org.eclipse.keypop.calypso.crypto.symmetric.SvCommandSecurityDataApi;
import org.eclipse.keypop.calypso.crypto.symmetric.SymmetricCryptoException;
import org.eclipse.keypop.calypso.crypto.symmetric.SymmetricCryptoIOException;

/**
 * Calypso card symmetric key cryptography service.
 *
 * <p>It defines the API needed by a terminal to perform the cryptographic operations required by a
 * Calypso card when using symmetric keys.
 *
 * <p>An instance of this interface can be obtained via the method {@link
 * SymmetricCryptoTransactionManagerFactorySpi#createTransactionManager(byte[], boolean, List)}.
 *
 * @since 0.1.0
 */
public interface SymmetricCryptoTransactionManagerSpi {

  /**
   * Retrieves and stores the terminal challenge in the SAM image for later use.
   *
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void preInitTerminalSecureSessionContext()
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Initializes the crypto service context for operating a Secure Session with a card and gets the
   * terminal challenge.
   *
   * @return The terminal challenge.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] initTerminalSecureSessionContext()
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Stores the data needed to initialize the session MAC computation for a Secure Session.
   *
   * @param openSecureSessionDataOut The data out from the card Open Secure Session command.
   * @param kif The card KIF.
   * @param kvc The card KVC.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void initTerminalSessionMac(byte[] openSecureSessionDataOut, byte kif, byte kvc)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Updates the digest computation with data sent or received from the card.
   *
   * <p>Returns encrypted/decrypted data when the encryption is active.
   *
   * @param cardApdu A byte array containing either the input or output data of a card command APDU.
   * @return null if the encryption is not activate, either the ciphered or deciphered command data
   *     if the encryption is active.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] updateTerminalSessionMac(byte[] cardApdu)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Finalizes the digest computation and returns the terminal part of the session MAC.
   *
   * @return A byte array containing the terminal session MAC.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] finalizeTerminalSessionMac() throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Generates the terminal part of the session MAC used for an early mutual authentication.
   *
   * @return A byte array containing the terminal session MAC.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] generateTerminalSessionMac() throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Activates the encryption/decryption of the data sent/received during the secure session.
   *
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void activateEncryption() throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Deactivates the encryption/decryption of the data sent/received during the secure session.
   *
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void deactivateEncryption() throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Verifies the card part of the session MAC finalizing the mutual authentication process.
   *
   * @param cardSessionMac A byte array containing the card session MAC.
   * @return true if the card session MAC is validated.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  boolean isCardSessionMacValid(byte[] cardSessionMac)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Computes the needed data to operate SV card commands.
   *
   * @param data The data involved in the preparation of an SV Reload/Debit/Undebit command.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void computeSvCommandSecurityData(SvCommandSecurityDataApi data)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Verifies the SV card MAC.
   *
   * @param cardSvMac A byte array containing the card SV MAC.
   * @return true if the card SV MAC is validated.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  boolean isCardSvMacValid(byte[] cardSvMac)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Computes a block of encrypted data to be sent to the card for an enciphered PIN presentation.
   *
   * <p>Note: the {@code kif} and {@code kvc} parameters are ignored when PIN verification is
   * performed within a Secure Session.
   *
   * @param cardChallenge A byte array containing the card challenge.
   * @param pin A byte array containing the 4-byte PIN value.
   * @param kif The PIN encryption key KIF.
   * @param kvc The PIN encryption key KVC.
   * @return A byte array containing the encrypted data block to sent to the card.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] cipherPinForPresentation(byte[] cardChallenge, byte[] pin, Byte kif, Byte kvc)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Computes a block of encrypted data to be sent to the card for a PIN modification.
   *
   * <p>Note: the {@code kif} and {@code kvc} parameters are ignored when PIN modification is
   * performed within a Secure Session.
   *
   * @param cardChallenge A byte array containing the card challenge.
   * @param currentPin A byte array containing the 4-byte current PIN value.
   * @param newPin A byte array containing the 4-byte new PIN value.
   * @param kif The PIN encryption key KIF.
   * @param kvc The PIN encryption key KVC.
   * @return A byte array containing the encrypted data block to sent to the card.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] cipherPinForModification(
      byte[] cardChallenge, byte[] currentPin, byte[] newPin, Byte kif, Byte kvc)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Generates an encrypted key data block for loading a key into a card.
   *
   * @param cardChallenge A byte array containing the card challenge.
   * @param issuerKeyKif The issuer key KIF.
   * @param issuerKeyKvc The issuer key KVC.
   * @param targetKeyKif The target key KIF.
   * @param targetKeyKvc The target key KVC.
   * @return A byte array containing the encrypted data block to sent to the card.
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  byte[] generateCipheredCardKey(
      byte[] cardChallenge,
      byte issuerKeyKif,
      byte issuerKeyKvc,
      byte targetKeyKif,
      byte targetKeyKvc)
      throws SymmetricCryptoException, SymmetricCryptoIOException;

  /**
   * Synchronizes data of the associated card transaction crypto extension if needed.
   *
   * @throws SymmetricCryptoException If an internal error occurred.
   * @throws SymmetricCryptoIOException If an IO error occurred when processing a command.
   * @since 0.1.0
   */
  void synchronize() throws SymmetricCryptoException, SymmetricCryptoIOException;
}

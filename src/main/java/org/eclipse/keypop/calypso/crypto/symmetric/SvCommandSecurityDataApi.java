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
package org.eclipse.keypop.calypso.crypto.symmetric;

/**
 * Contains the input/output data of the SV command operations (LOAD / DEBIT / UNDEBIT).
 *
 * @since 0.1.0
 */
public interface SvCommandSecurityDataApi {

  /**
   * Returns the "SV Get" ingoing command data.
   *
   * @return A not empty byte array containing the "SV Get" apdu request data.
   * @since 0.1.0
   */
  byte[] getSvGetRequest();

  /**
   * Returns the "SV Get" outgoing command data.
   *
   * @return A not empty byte array containing the "SV Get" apdu response data.
   * @since 0.1.0
   */
  byte[] getSvGetResponse();

  /**
   * Returns the "SV Load/Debit/Undebit" ingoing partial command data.
   *
   * @return A not empty byte array containing the "SV Load/Debit/Undebit" apdu request data.
   * @since 0.1.0
   */
  byte[] getSvCommandPartialRequest();

  /**
   * Sets the serial number to be placed in the "SV Load/Debit/Undebit" command request.
   *
   * @param serialNumber The serial number to be used.
   * @return The current instance.
   * @since 0.1.0
   */
  SvCommandSecurityDataApi setSerialNumber(byte[] serialNumber);

  /**
   * Sets the transaction number to be placed in the "SV Load/Debit/Undebit" command request.
   *
   * @param transactionNumber The transaction number to be used.
   * @return The current instance.
   * @since 0.1.0
   */
  SvCommandSecurityDataApi setTransactionNumber(byte[] transactionNumber);

  /**
   * Sets the terminal challenge to be placed in the SV Load/Debit/Undebit command request.
   *
   * @param terminalChallenge The terminal challenge to be used.
   * @return The current instance.
   * @since 0.1.0
   */
  SvCommandSecurityDataApi setTerminalChallenge(byte[] terminalChallenge);

  /**
   * Sets the terminal SV MAC to be placed in the "SV Load/Debit/Undebit" command request.
   *
   * @param terminalSvMac The terminal SV MAC to be used.
   * @return The current instance.
   * @since 0.1.0
   */
  SvCommandSecurityDataApi setTerminalSvMac(byte[] terminalSvMac);
}

/*
 * Copyright 2016 UnboundID Corp.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */

package com.unboundid.scim2.extension.messages.contactvalidation;

import com.unboundid.scim2.common.BaseScimResource;
import com.unboundid.scim2.common.annotations.Attribute;
import com.unboundid.scim2.common.annotations.Schema;
import com.unboundid.scim2.common.types.AttributeDefinition;

import java.util.Calendar;

/**
 * The request for validating an email address.
 */
@Schema(description = "Email Validation Request",
    id = "urn:unboundid:scim:api:messages:2.0:EmailValidationRequest",
    name = "EmailValidationRequest")
public class EmailValidationRequest extends BaseScimResource
{
  @Attribute(description = "The attribute path containing the email address.",
      mutability = AttributeDefinition.Mutability.IMMUTABLE,
      isRequired = true,
      returned = AttributeDefinition.Returned.ALWAYS)
  private String attributePath;

  @Attribute(description = "The subject of the email message when sending " +
      "the verification code.",
      mutability = AttributeDefinition.Mutability.IMMUTABLE,
      isRequired = true,
      returned = AttributeDefinition.Returned.NEVER)
  private String messageSubject;

  @Attribute(description = "The body of the email message when sending " +
      "the verification code.",
      mutability = AttributeDefinition.Mutability.IMMUTABLE,
      returned = AttributeDefinition.Returned.NEVER)
  private String messageText;

  @Attribute(description = "The attribute path containing the email address.",
      mutability = AttributeDefinition.Mutability.WRITE_ONLY,
      returned = AttributeDefinition.Returned.NEVER)
  private String verifyCode;

  @Attribute(description = "The current email address.",
      mutability = AttributeDefinition.Mutability.READ_ONLY,
      returned = AttributeDefinition.Returned.ALWAYS)
  private String attributeValue;

  @Attribute(description = "Whether the current email address was " +
      "successfully validated.",
      mutability = AttributeDefinition.Mutability.READ_ONLY,
      returned = AttributeDefinition.Returned.ALWAYS)
  private Boolean validated;

  @Attribute(description = "The last time the current email address was " +
      "successfully validated.",
      mutability = AttributeDefinition.Mutability.READ_ONLY,
      returned = AttributeDefinition.Returned.ALWAYS)
  private Calendar validatedAt;

  @Attribute(description = "Whether a verification code was sent and is " +
      "pending validation.",
      mutability = AttributeDefinition.Mutability.READ_ONLY,
      returned = AttributeDefinition.Returned.ALWAYS)
  private Boolean codeSent;

  private EmailValidationRequest()
  {
    // For Jackson
  }

  /**
   * Create a new EmailValidationRequest.
   *
   * @param attributePath The attribute path containing the email address to
   *                      verify.
   */
  public EmailValidationRequest(final String attributePath)
  {
    this.attributePath = attributePath;
  }

  /**
    * Retrieve the attribute path.
    * @return  The attribute path.
    */
   public String getAttributePath()
   {
     return attributePath;
   }



   /**
    * Set the attribute path.
    * @param attributePath  The attribute path.
    */
   public void setAttributePath(final String attributePath)
   {
     this.attributePath = attributePath;
   }



   /**
    * Retrieve the attribute value.
    * @return  The attribute value.
    */
   public String getAttributeValue()
   {
     return attributeValue;
   }



   /**
    * Set the attribute value.
    * @param attributeValue  The attribute value.
    */
   public void setAttributeValue(final String attributeValue)
   {
     this.attributeValue = attributeValue;
   }



   /**
    * Indicates whether the attribute value is validated.
    * @return  {@code true} iff the attribute value is validated.
    */
   public Boolean getValidated()
   {
     return validated;
   }



   /**
    * Specify whether the attribute value is validated.
    * @param validated  {@code true} iff the attribute value is validated.
    */
   public void setValidated(final Boolean validated)
   {
     this.validated = validated;
   }



   /**
    * Retrieve the time at which the attribute value was validated.
    * @return  The time at which the attribute value was validated.
    */
   public Calendar getValidatedAt()
   {
     return validatedAt;
   }



   /**
    * Set the time at which the attribute value was validated.
    * @param validatedAt  The time at which the attribute value was validated.
    */
   public void setValidatedAt(final Calendar validatedAt)
   {
     this.validatedAt = validatedAt;
   }



   /**
    * Indicates whether a verification code has been sent.
    * Only applicable in an intermediate response to update preferences.
    * @return  {@code true} iff a verification code has been sent.
    */
   public Boolean getCodeSent()
   {
     return codeSent;
   }



   /**
    * Specify whether a verification code has been sent.
    * Only applicable in an intermediate response to update preferences.
    * @param codeSent  {@code true} iff a verification code has been sent.
    */
   public void setCodeSent(final Boolean codeSent)
   {
     this.codeSent = codeSent;
   }


  /**
   * Retrieve the message subject.
   * @return  The message subject.
   */
  public String getMessageSubject()
  {
    return messageSubject;
  }



  /**
   * Specify the message subject.
   * @param messageSubject  The message subject.
   */
  public void setMessageSubject(final String messageSubject)
  {
    this.messageSubject = messageSubject;
  }



  /**
   * Retrieve the message text.
   * @return  The message text.
   */
  public String getMessageText()
  {
    return messageText;
  }



  /**
   * Specify the message text.
   * @param messageText  The message text.
   */
  public void setMessageText(final String messageText)
  {
    this.messageText = messageText;
  }



  /**
   * Retrieve the code to be verified against the delivered code.
   * @return  The code to be verified against the delivered code.
   */
  public String getVerifyCode()
  {
    return verifyCode;
  }



  /**
   * Specify the code to be verified against the delivered code.
   * @param verifyCode  The code to be verified against the delivered code.
   */
  public void setVerifyCode(final String verifyCode)
  {
    this.verifyCode = verifyCode;
  }
}
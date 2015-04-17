/*
 * Copyright 2015 UnboundID Corp.
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

package com.unboundid.scim2.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unboundid.scim2.model.GenericScimResourceObject;
import com.unboundid.scim2.schema.SchemaUtils;

import java.io.IOException;

/**
 * Deserializer for the GenericScimObject.
 */
public class GenericScimObjectDeserializer
    extends JsonDeserializer<GenericScimResourceObject>
{
  /**
   * {@inheritDoc}
   */
  @Override
  public GenericScimResourceObject deserialize(final JsonParser jp,
      final DeserializationContext ctxt) throws IOException
  {
    ObjectMapper objectMapper = SchemaUtils.createSCIMCompatibleMapper();
    ObjectNode objectNode = objectMapper.readValue(jp, ObjectNode.class);
    return new GenericScimResourceObject(objectNode);
  }
}
/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package org.apache.plc4x.java.s7.netty.model.payloads;

import org.apache.plc4x.java.s7.netty.model.payloads.items.VarPayloadItem;
import org.apache.plc4x.java.s7.netty.model.types.ParameterType;

import java.util.List;

/**
 * Used for writes to S7 as part of a Valid {@link org.apache.plc4x.java.s7.netty.model.messages.S7RequestMessage} together
 * with a suitable {@link org.apache.plc4x.java.s7.netty.model.params.VarParameter} Object.
 * Contains the values to write as {@link VarPayloadItem}s.
 */
public class VarPayload implements S7Payload {

    private final ParameterType parameterType;

    private final List<VarPayloadItem> payloadItems;

    public VarPayload(ParameterType parameterType, List<VarPayloadItem> payloadItems) {
        this.parameterType = parameterType;
        this.payloadItems = payloadItems;
    }

    @Override
    public ParameterType getType() {
        return parameterType;
    }

    public List<VarPayloadItem> getItems() {
        return payloadItems;
    }

    public void mergePayload(VarPayload otherPayload) {
        payloadItems.addAll(otherPayload.getItems());
    }

}

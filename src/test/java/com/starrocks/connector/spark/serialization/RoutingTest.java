// Modifications Copyright 2021 StarRocks Limited.
//
// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.starrocks.connector.spark.serialization;

import com.starrocks.connector.spark.exception.IllegalArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoutingTest {

    @Test
    public void testRouting() {
        Routing r1 = new Routing("10.11.12.13:1234");
        Assertions.assertEquals("10.11.12.13", r1.getHost());
        Assertions.assertEquals(1234, r1.getPort());

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Routing("10.11.12.13:wxyz"));
        Assertions.assertTrue(exception.getMessage().startsWith("argument "));

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Routing("10.11.12.13"));
        Assertions.assertTrue(exception.getMessage().startsWith("argument "));
    }
}

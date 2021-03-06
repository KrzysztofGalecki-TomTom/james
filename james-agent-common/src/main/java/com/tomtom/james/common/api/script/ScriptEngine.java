/*
 * Copyright 2017 TomTom International B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tomtom.james.common.api.script;

import com.tomtom.james.common.api.Closeable;
import com.tomtom.james.common.api.informationpoint.InformationPoint;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ScriptEngine extends Closeable {

    Object invokePrepareContext(InformationPoint informationPoint,
                                Method origin,
                                List<RuntimeInformationPointParameter> parameters,
                                Object instance,
                                Thread currentThread,
                                String contextKey);

    void invokeSuccessHandler(InformationPoint informationPoint,
                              Method origin,
                              List<RuntimeInformationPointParameter> parameters,
                              Object instance,
                              Thread currentThread,
                              Instant eventTime,
                              Duration executionTime,
                              String[] callStack,
                              Object returnValue,
                              CompletableFuture<Object> initialContextProvider);

    void invokeErrorHandler(InformationPoint informationPoint,
                            Method origin,
                            List<RuntimeInformationPointParameter> parameters,
                            Object instance,
                            Thread currentThread,
                            Instant eventTime,
                            Duration executionTime,
                            String[] callStack,
                            Throwable errorCause,
                            CompletableFuture<Object> initialContextProvider);

}

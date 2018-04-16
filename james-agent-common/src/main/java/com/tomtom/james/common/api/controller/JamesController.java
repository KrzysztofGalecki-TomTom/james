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

package com.tomtom.james.common.api.controller;

import com.tomtom.james.common.api.Closeable;
import com.tomtom.james.common.api.Identifiable;
import com.tomtom.james.common.api.QueueBacked;
import com.tomtom.james.common.api.configuration.JamesControllerConfiguration;
import com.tomtom.james.common.api.informationpoint.InformationPointService;
import com.tomtom.james.common.api.publisher.EventPublisher;
import com.tomtom.james.common.api.script.ScriptEngine;

public interface JamesController extends Identifiable, Closeable {

    void initialize(JamesControllerConfiguration configuration,
                    InformationPointService informationPointService,
                    ScriptEngine scriptEngine,
                    EventPublisher eventPublisher,
                    QueueBacked jamesObjectiveQueue,
                    QueueBacked newClassesQueue,
                    QueueBacked newInformationPointQueue,
                    QueueBacked removeInformationPointQueue);

}

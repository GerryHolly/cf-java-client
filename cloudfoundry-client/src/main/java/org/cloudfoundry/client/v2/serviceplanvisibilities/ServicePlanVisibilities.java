/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.client.v2.serviceplanvisibilities;

import reactor.core.publisher.Mono;

/**
 * Main entry point to the Cloud Foundry Service Plan Visibilities Client API
 */
public interface ServicePlanVisibilities {

    /**
     * Makes the <a href="http://apidocs.cloudfoundry.org/214/service_keys/create_a_service_key.html">Create Service Plan Visibility</a> request
     *
     * @param request the Create Service Plan Visibility request
     * @return the response from the Create Service Plan Visibility request
     */
    Mono<CreateServicePlanVisibilityResponse> create(CreateServicePlanVisibilityRequest request);

}

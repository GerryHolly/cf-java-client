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

package org.cloudfoundry.operations;

import org.cloudfoundry.AbstractIntegrationTest;
import org.cloudfoundry.operations.organizations.CreateOrganizationRequest;
import org.cloudfoundry.operations.organizations.OrganizationSummary;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.test.subscriber.ScriptedSubscriber;

import java.time.Duration;
import java.util.concurrent.TimeoutException;


public final class OrganizationsTest extends AbstractIntegrationTest {

    @Autowired
    private CloudFoundryOperations cloudFoundryOperations;

    @Autowired
    private Mono<String> organizationId;

    @Test
    public void create() throws TimeoutException, InterruptedException {
        String organizationName = this.nameFactory.getOrganizationName();

        ScriptedSubscriber<OrganizationSummary> subscriber = ScriptedSubscriber.<OrganizationSummary>expectValueCount(1)
            .expectComplete();

        this.cloudFoundryOperations.organizations()
            .create(CreateOrganizationRequest.builder()
                .organizationName(organizationName)
                .build())
            .thenMany(this.cloudFoundryOperations.organizations()
                .list())
            .filter(organizationSummary -> organizationName.equals(organizationSummary.getName()))
            .subscribe(subscriber);

        subscriber.verify(Duration.ofMinutes(5));
    }

    @Test
    public void list() throws TimeoutException, InterruptedException {
        ScriptedSubscriber<OrganizationSummary> subscriber = ScriptedSubscriber.<OrganizationSummary>expectValueCount(1)
            .expectComplete();

        this.organizationId
            .flatMap(organizationId -> this.cloudFoundryOperations.organizations()
                .list()
                .filter(organization -> organization.getId().equals(organizationId)))
            .subscribe(subscriber);

        subscriber.verify(Duration.ofMinutes(5));
    }

}

/*
 * Copyright 2013-2017 the original author or authors.
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

package org.cloudfoundry.client.v2.applications;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cloudfoundry.AllowNulls;
import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

import java.util.Map;

/**
 * The request payload for the v2 Update Application request
 */
@Value.Immutable
abstract class _UpdateApplicationRequest {

    /**
     * The application id
     */
    @JsonIgnore
    abstract String getApplicationId();

    /**
     * Buildpack to build the application
     */
    @JsonProperty("buildpack")
    @Nullable
    abstract String getBuildpack();

    /**
     * The command to start the application after it is staged
     */
    @JsonProperty("command")
    @Nullable
    abstract String getCommand();

    /**
     * Open the console port for the application (at {@code $CONSOLE_PORT})
     */
    @Deprecated
    @JsonProperty("console")
    @Nullable
    abstract Boolean getConsole();

    /**
     * Open the debug port for the application (at {@code $DEBUG_PORT})
     */
    @Deprecated
    @JsonProperty("debug")
    @Nullable
    abstract String getDebug();

    /**
     * Use diego to stage and to run when available
     */
    @JsonProperty("diego")
    @Nullable
    abstract Boolean getDiego();

    /**
     * The maximum amount of disk available to an instance of an application. In megabytes.
     */
    @JsonProperty("disk_quota")
    @Nullable
    abstract Integer getDiskQuota();

    /**
     * Docker credentials for pulling docker image
     */
    @AllowNulls
    @JsonProperty("docker_credentials_json")
    @Nullable
    abstract Map<String, Object> getDockerCredentialsJsons();

    /**
     * Name of the Docker image containing the application
     */
    @JsonProperty("docker_image")
    @Nullable
    abstract String getDockerImage();

    /**
     * Enable SSH for the application
     */
    @JsonProperty("enable_ssh")
    @Nullable
    abstract Boolean getEnableSsh();

    /**
     * Key/value pairs of all the environment variables to run in your application. Does not include any system or service variables.
     */
    @AllowNulls
    @JsonProperty("environment_json")
    @Nullable
    abstract Map<String, Object> getEnvironmentJsons();

    /**
     * The HTTP endpoint to check for health
     */
    @JsonProperty("health_check_http_endpoint")
    @Nullable
    abstract String getHealthCheckHttpEndpoint();

    /**
     * Timeout for health checking of an staged application when starting up
     */
    @JsonProperty("health_check_timeout")
    @Nullable
    abstract Integer getHealthCheckTimeout();

    /**
     * Type of health check to perform
     */
    @JsonProperty("health_check_type")
    @Nullable
    abstract String getHealthCheckType();

    /**
     * The number of instances of the application to run. To ensure optimal availability, ensure there are at least 2 instances.
     */
    @JsonProperty("instances")
    @Nullable
    abstract Integer getInstances();

    /**
     * The amount of memory each instance should have. In megabytes.
     */
    @JsonProperty("memory")
    @Nullable
    abstract Integer getMemory();

    /**
     * The name of the application
     */
    @JsonProperty("name")
    @Nullable
    abstract String getName();

    /**
     * Whether the application is production
     */
    @Deprecated
    @JsonProperty("production")
    @Nullable
    abstract String getProduction();

    /**
     * The id of the associated space
     */
    @JsonProperty("space_guid")
    @Nullable
    abstract String getSpaceId();

    /**
     * The id of the associated stack
     */
    @JsonProperty("stack_guid")
    @Nullable
    abstract String getStackId();

    /**
     * The current desired state of the application
     */
    @JsonProperty("state")
    @Nullable
    abstract String getState();

}

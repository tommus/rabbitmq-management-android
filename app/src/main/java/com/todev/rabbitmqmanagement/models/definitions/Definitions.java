/*
 * Copyright (c) 2016 to-dev.com.
 *
 * Licensed under the GNU GPL, Version 3 (the "License").
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.todev.rabbitmqmanagement.models.definitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.bindings.Binding;
import com.todev.rabbitmqmanagement.models.exchanges.Exchange;
import com.todev.rabbitmqmanagement.models.permissions.Permission;
import com.todev.rabbitmqmanagement.models.queues.Queue;
import com.todev.rabbitmqmanagement.models.users.ExtendedUser;
import com.todev.rabbitmqmanagement.models.vhosts.Vhost;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class Definitions {

  @JsonProperty("bindings") protected List<Binding> bindings = new ArrayList<>();

  @JsonProperty("exchanges") protected List<Exchange> exchanges = new ArrayList<>();

  // TODO: Parameters should be corrected.

  @JsonProperty("parameters") protected List<Object> parameters = new ArrayList<>();

  @JsonProperty("permissions") protected List<Permission> permissions = new ArrayList<>();

  @JsonProperty("policies") protected List<Policy> policies = new ArrayList<>();

  @JsonProperty("queues") protected List<Queue> queues = new ArrayList<>();

  @JsonProperty("rabbit_version") protected String rabbitVersion;

  @JsonProperty("users") protected List<ExtendedUser> users = new ArrayList<>();

  @JsonProperty("vhosts") protected List<Vhost> vhosts = new ArrayList<>();

  public List<Binding> getBindings() {
    return bindings;
  }

  public List<Exchange> getExchanges() {
    return exchanges;
  }

  public List<Object> getParameters() {
    return parameters;
  }

  public List<Permission> getPermissions() {
    return permissions;
  }

  public List<Policy> getPolicies() {
    return policies;
  }

  public List<Queue> getQueues() {
    return queues;
  }

  public String getRabbitVersion() {
    return rabbitVersion;
  }

  public List<ExtendedUser> getUsers() {
    return users;
  }

  public List<Vhost> getVhosts() {
    return vhosts;
  }
}

package co.windly.rabbitmqmanagement.network.model.definition;

import co.windly.rabbitmqmanagement.network.model.binding.Binding;
import co.windly.rabbitmqmanagement.network.model.exchange.Exchange;
import co.windly.rabbitmqmanagement.network.model.permission.Permission;
import co.windly.rabbitmqmanagement.network.model.policy.Policy;
import co.windly.rabbitmqmanagement.network.model.queue.Queue;
import co.windly.rabbitmqmanagement.network.model.user.ExtendedUserDto;
import co.windly.rabbitmqmanagement.network.model.vhost.Vhost;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Definitions {

  //region Bindings

  @JsonProperty(value = "bindings")
  private List<Binding> bindings = new ArrayList<>();

  public List<Binding> getBindings() {
    return bindings;
  }

  public void setBindings(List<Binding> bindings) {
    this.bindings = bindings;
  }

  //endregion

  //region Exchanges

  @JsonProperty(value = "exchanges")
  private List<Exchange> exchanges = new ArrayList<>();

  public List<Exchange> getExchanges() {
    return exchanges;
  }

  public void setExchanges(List<Exchange> exchanges) {
    this.exchanges = exchanges;
  }

  //endregion

  //region Parameters

  // TODO: Parameters should be corrected.

  @JsonProperty(value = "parameters")
  private List<Object> parameters = new ArrayList<>();

  public List<Object> getParameters() {
    return parameters;
  }

  public void setParameters(List<Object> parameters) {
    this.parameters = parameters;
  }

  //endregion

  //region Permissions

  @JsonProperty(value = "permissions")
  private List<Permission> permissions = new ArrayList<>();

  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }

  //endregion

  //region Policies

  @JsonProperty(value = "policies")
  private List<Policy> policies = new ArrayList<>();

  public List<Policy> getPolicies() {
    return policies;
  }

  public void setPolicies(List<Policy> policies) {
    this.policies = policies;
  }

  //endregion

  //region Queues

  @JsonProperty(value = "queues")
  private List<Queue> queues = new ArrayList<>();

  public List<Queue> getQueues() {
    return queues;
  }

  public void setQueues(List<Queue> queues) {
    this.queues = queues;
  }

  //endregion

  //region Rabbit Version

  @JsonProperty(value = "rabbit_version")
  private String rabbitVersion;

  public String getRabbitVersion() {
    return rabbitVersion;
  }

  public void setRabbitVersion(String rabbitVersion) {
    this.rabbitVersion = rabbitVersion;
  }

  //endregion

  //region Users

  @JsonProperty(value = "users")
  private List<ExtendedUserDto> users = new ArrayList<>();

  public List<ExtendedUserDto> getUsers() {
    return users;
  }

  public void setUsers(List<ExtendedUserDto> users) {
    this.users = users;
  }

  //endregion

  //region Vhosts

  @JsonProperty(value = "vhosts")
  private List<Vhost> vhosts = new ArrayList<>();

  public List<Vhost> getVhosts() {
    return vhosts;
  }

  public void setVhosts(List<Vhost> vhosts) {
    this.vhosts = vhosts;
  }

  //endregion
}

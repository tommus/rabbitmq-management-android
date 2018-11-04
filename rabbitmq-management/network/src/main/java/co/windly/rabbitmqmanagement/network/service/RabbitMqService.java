package co.windly.rabbitmqmanagement.network.service;

import co.windly.rabbitmqmanagement.network.model.Check;
import co.windly.rabbitmqmanagement.network.model.binding.Binding;
import co.windly.rabbitmqmanagement.network.model.binding.ExtendedBinding;
import co.windly.rabbitmqmanagement.network.model.channel.Channel;
import co.windly.rabbitmqmanagement.network.model.cluster.Cluster;
import co.windly.rabbitmqmanagement.network.model.connection.Connection;
import co.windly.rabbitmqmanagement.network.model.consumer.Consumer;
import co.windly.rabbitmqmanagement.network.model.definition.Definitions;
import co.windly.rabbitmqmanagement.network.model.exchange.Exchange;
import co.windly.rabbitmqmanagement.network.model.exchange.ExtendedExchange;
import co.windly.rabbitmqmanagement.network.model.extension.Extension;
import co.windly.rabbitmqmanagement.network.model.message.Message;
import co.windly.rabbitmqmanagement.network.model.message.PublishBody;
import co.windly.rabbitmqmanagement.network.model.message.PublishResponse;
import co.windly.rabbitmqmanagement.network.model.message.Requirements;
import co.windly.rabbitmqmanagement.network.model.node.Node;
import co.windly.rabbitmqmanagement.network.model.overview.Overview;
import co.windly.rabbitmqmanagement.network.model.parameter.Parameter;
import co.windly.rabbitmqmanagement.network.model.parameter.PutParameter;
import co.windly.rabbitmqmanagement.network.model.permission.Permission;
import co.windly.rabbitmqmanagement.network.model.policy.Policy;
import co.windly.rabbitmqmanagement.network.model.queue.Action;
import co.windly.rabbitmqmanagement.network.model.queue.ExtendedQueue;
import co.windly.rabbitmqmanagement.network.model.queue.PutQueue;
import co.windly.rabbitmqmanagement.network.model.user.ExtendedUser;
import co.windly.rabbitmqmanagement.network.model.user.User;
import co.windly.rabbitmqmanagement.network.model.vhost.ExtendedVhost;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import java.util.List;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RabbitMqService {

  @GET("api/overview")
  Single<Response<Overview>> getOverview();

  @GET("api/cluster-name")
  Single<Cluster> getClusterName();

  @PUT("api/cluster-name")
  Completable updateClusterName(@Body @NonNull Cluster cluster);

  @GET("api/nodes")
  Single<List<Node>> getNodes();

  @GET("api/nodes/{name}")
  Single<Node> getNode(@Path("name") @NonNull String name);

  @GET("api/extensions")
  Single<List<Extension>> getExtensions();

  @GET("api/definitions")
  Single<Definitions> getDefinitions();

  // TODO: Add POST /definitions.

  @GET("api/definitions/{vhost}")
  Single<Definitions> getDefinitions(@Path("vhost") @NonNull String vhost);

  // TODO: Add POST /definitions/{vhost}.

  @GET("api/connections")
  Single<List<Connection>> getConnections();

  @GET("api/vhosts/{vhost}/connections")
  Single<List<Connection>> getConnections(@Path("vhost") @NonNull String vhost);

  @GET("api/connections/{name}")
  Single<Connection> getConnection(@Path("name") @NonNull String name);

  @DELETE("api/connections/{name}")
  Completable deleteConnection(@Path("name") @NonNull String name,
    @Header(Headers.X_REASON) @Nullable String reason);

  @GET("api/connections/{name}/channels")
  Single<List<Channel>> getConnectionChannels(@Path("name") @NonNull String connection);

  @GET("api/channels")
  Single<List<Channel>> getChannels();

  @GET("api/vhosts/{vhost}/channels")
  Single<List<Channel>> getChannels(@Path("vhost") @NonNull String vhost);

  @GET("api/channels/{name}")
  Single<Channel> getChannel(@Path("name") @NonNull String name);

  @GET("api/consumers")
  Single<List<Consumer>> getConsumers();

  @GET("api/consumers/{vhost}")
  Single<List<Consumer>> getConsumers(@Path("vhost") @NonNull String vhost);

  @GET("api/exchanges")
  Single<List<ExtendedExchange>> getExchanges();

  @GET("api/exchanges/{vhost}")
  Single<List<ExtendedExchange>> getExchanges(@Path("vhost") @NonNull String vhost);

  @GET("api/exchanges/{vhost}/{exchange}")
  Single<ExtendedExchange> getExchange(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange);

  @PUT("api/exchanges/{vhost}/{exchange}")
  Completable putExchange(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Body @NonNull Exchange body);

  @DELETE("api/exchanges/{vhost}/{exchange}")
  Completable deleteExchange(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Query("if-unused") @Nullable Boolean ifUnused);

  @GET("api/exchanges/{vhost}/{exchange}/bindings/source")
  Single<List<Binding>> getSourceBindings(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange);

  @GET("api/exchanges/{vhost}/{exchange}/bindings/destination")
  Single<List<Binding>> getDestinationBindings(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange);

  @POST("api/exchanges/{vhost}/{exchange}/publish")
  Single<PublishResponse> postExchangePublish(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Body @NonNull PublishBody body);

  @GET("api/queues")
  Single<List<ExtendedQueue>> getQueues();

  @GET("api/queues/{vhost}")
  Single<List<ExtendedQueue>> getQueues(@Path("vhost") @NonNull String vhost);

  @GET("api/queues/{vhost}/{queue}")
  Single<ExtendedQueue> getQueue(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue);

  @PUT("api/queues/{vhost}/{queue}")
  Completable putQueue(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue, @Body @NonNull PutQueue body);

  @DELETE("api/queues/{vhost}/{queue}")
  Completable deleteQueue(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue, @Query("if-empty") @Nullable Boolean ifEmpty,
    @Query("if-unused") @Nullable Boolean ifUnused);

  @GET("api/queues/{vhost}/{queue}/bindings")
  Single<List<Binding>> getQueueBindings(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue);

  @DELETE("api/queues/{vhost}/{queue}/contents")
  Completable purgeQueue(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue);

  @POST("api/queues/{vhost}/{queue}/actions")
  Completable postAction(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue, @Body @NonNull Action body);

  @POST("api/queues/{vhost}/{queue}/get")
  Single<List<Message>> getMessages(@Path("vhost") @NonNull String vhost,
    @Path("queue") @NonNull String queue, @Body @NonNull Requirements body);

  @GET("api/bindings")
  Single<List<Binding>> getBindings();

  @GET("api/bindings/{vhost}")
  Single<List<Binding>> getBindings(@Path("vhost") @NonNull String vhost);

  @GET("api/bindings/{vhost}/e/{exchange}/q/{queue}")
  Single<List<ExtendedBinding>> getBindingsBetweenExchangeAndQueue(
    @Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange,
    @Path("queue") @NonNull String queue);

  @POST("api/bindings/{vhost}/e/{exchange}/q/{queue}")
  Completable postBindingsBetweenExchangeAndQueue(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
    @Body @NonNull Binding body);

  @GET("api/bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Single<ExtendedBinding> getBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
    @Path("props") @NonNull String propertiesKey);

  @DELETE("api/bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Single<ExtendedBinding> deleteBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
    @Path("props") @NonNull String propertiesKey);

  @GET("api/bindings/{vhost}/e/{source}/e/{destination}")
  Single<List<ExtendedBinding>> getBindingsBetweenExchanges(
    @Path("vhost") @NonNull String vhost, @Path("source") @NonNull String srcExchange,
    @Path("destination") @NonNull String dstExchange);

  @POST("api/bindings/{vhost}/e/{source}/e/{destination}")
  Completable postBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
    @Path("source") @NonNull String source, @Path("destination") @NonNull String destination,
    @Body @NonNull Binding body);

  @GET("api/bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Single<ExtendedBinding> getBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
    @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
    @Path("props") @NonNull String propertiesKey);

  @DELETE("api/bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Completable deleteBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
    @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
    @Path("props") @NonNull String propertiesKey);

  @GET("api/vhosts")
  Single<List<ExtendedVhost>> getVhosts();

  @GET("api/vhosts/{name}")
  Single<ExtendedVhost> getVhost(@Path("name") @NonNull String name);

  @PUT("api/vhosts/{name}")
  Completable putVhost(@Path("name") @NonNull String name);

  @DELETE("api/vhosts/{name}")
  Completable deleteHost(@Path("name") @NonNull String name);

  @GET("api/vhosts/{vhost}/permissions")
  Single<List<Permission>> getVhostPermissions(@Path("vhost") @NonNull String vhost);

  @GET("api/users")
  Single<List<ExtendedUser>> getUsers();

  @GET("api/users/{name}")
  Single<ExtendedUser> getUser(@Path("name") @NonNull String name);

  @PUT("api/users/{name}")
  Completable putUser(@Path("name") @NonNull String name, @NonNull @Body ExtendedUser body);

  @DELETE("api/users/{name}")
  Completable deleteUser(@Path("name") @NonNull String name);

  @GET("api/users/{user}/permissions")
  Single<List<Permission>> getUserPermissions(@Path("user") @NonNull String user);

  @GET("api/whoami")
  Single<Response<User>> whoAmI();

  @GET("api/permissions")
  Single<List<Permission>> getPermissions();

  @GET("api/permissions/{vhost}/{user}")
  Single<Permission> getPermission(@Path("vhost") @NonNull String vhost,
    @Path("user") @NonNull String user);

  @PUT("api/permissions/{vhost}/{user}")
  Completable putPermission(@Path("vhost") @NonNull String vhost,
    @Path("user") @NonNull String user, @Body @NonNull Permission body);

  @DELETE("api/permissions/{vhost}/{user}")
  Completable deletePermission(@Path("vhost") @NonNull String vhost,
    @Path("user") @NonNull String user);

  @GET("api/parameters")
  Single<List<Parameter>> getParameters();

  @GET("api/parameters/{component}")
  Single<List<Parameter>> getParameters(@Path("component") @NonNull String component);

  @GET("api/parameters/{component}/{vhost}")
  Single<List<Parameter>> getParameters(@Path("component") @NonNull String component,
    @Path("vhost") @NonNull String vhost);

  @GET("api/parameters/{component}/{vhost}/{parameter}")
  Single<Parameter> getParameter(@Path("component") @NonNull String component,
    @Path("vhost") @NonNull String vhost, @Path("parameter") @NonNull String parameter);

  @PUT("api/parameters/{component}/{vhost}/{parameter}")
  Completable putParameter(@Path("component") @NonNull String component,
    @Path("vhost") @NonNull String vhost, @Path("parameter") @NonNull String parameter,
    @Body @NonNull PutParameter body);

  @DELETE("api/parameters/{component}/{vhost}/{parameter}")
  Completable deleteParameter(@Path("component") @NonNull String component,
    @Path("vhost") @NonNull String vhost, @Path("parameter") @NonNull String parameter);

  @GET("api/policies")
  Single<List<Policy>> getPolicies();

  @GET("api/policies/{vhost}")
  Single<List<Policy>> getPolicies(@Path("vhost") @NonNull String vhost);

  @GET("api/policies/{vhost}/{policy}")
  Single<Policy> getPolicy(@Path("vhost") @NonNull String vhost,
    @Path("policy") @NonNull String policy);

  @PUT("api/policies/{vhost}/{policy}")
  Completable putPolicy(@Path("vhost") @NonNull String vhost,
    @Path("policy") @NonNull String policy, @Body @NonNull Policy body);

  @DELETE("api/policies/{vhost}/{policy}")
  Completable deletePolicy(@Path("vhost") @NonNull String vhost,
    @Path("policy") @NonNull String policy);

  @GET("api/aliveness-test/{vhost}")
  Single<Check> checkAlive(@Path("vhost") @NonNull String vhost);

  @GET("api/healthchecks/node")
  Single<Check> checkHealth();

  @GET("api/healthchecks/node/{node}")
  Single<Check> checkHealth(@Path("node") @NonNull String node);

  class Headers {

    public static final String X_REASON = "X-Reason";

    public static final String LOCATION = "Location";
  }
}

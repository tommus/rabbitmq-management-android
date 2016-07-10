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
package com.todev.rabbitmqmanagement.services;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.todev.rabbitmqmanagement.models.bindings.Binding;
import com.todev.rabbitmqmanagement.models.bindings.ExtendedBinding;
import com.todev.rabbitmqmanagement.models.channels.Channel;
import com.todev.rabbitmqmanagement.models.cluster.Cluster;
import com.todev.rabbitmqmanagement.models.connections.Connection;
import com.todev.rabbitmqmanagement.models.definitions.Definitions;
import com.todev.rabbitmqmanagement.models.exchanges.ExtendedExchange;
import com.todev.rabbitmqmanagement.models.extensions.Extension;
import com.todev.rabbitmqmanagement.models.nodes.Node;
import com.todev.rabbitmqmanagement.models.overview.Overview;
import com.todev.rabbitmqmanagement.models.queues.ExtendedQueue;
import com.todev.rabbitmqmanagement.models.vhosts.ExtendedVhost;
import com.todev.rabbitmqmanagement.services.interceptors.AuthorizationInterceptor;
import com.todev.rabbitmqmanagement.services.interceptors.ContentTypeInterceptor;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RabbitMqService {

  String CONTENT_TYPE = "application/json";

  String TEST_URL = "http://192.168.1.129:15672/api/";

  String TEST_TOKEN = "Basic dG9tbXVzOnRvbW11cw==";

  @GET("overview") Call<Overview> getOverview();

  @GET("cluster-name") Call<Cluster> getClusterName();

  @PUT("cluster-name") Call<Void> updateClusterName(@Body @NonNull Cluster cluster);

  @GET("nodes") Call<List<Node>> getNodes();

  @GET("nodes/{name}") Call<Node> getNode(@Path("name") @NonNull String name);

  @GET("extensions") Call<List<Extension>> getExtensions();

  @GET("definitions") Call<Definitions> getDefinitions();

  // TODO: Add POST /definitions.

  @GET("definitions/{vhost}") Call<Definitions> getDefinitions(
      @Path("vhost") @NonNull String vhost);

  // TODO: Add POST /definitions/{vhost}.

  @GET("connections") Call<List<Connection>> getConnections();

  @GET("vhosts/{vhost}/connections") Call<List<Connection>> getConnections(
      @Path("vhost") @NonNull String vhost);

  @GET("connections/{name}") Call<Connection> getConnection(@Path("name") @NonNull String name);

  @DELETE("connections/{name}") Call<Void> deleteConnection(@Path("name") @NonNull String name,
      @Header(Headers.X_REASON) @Nullable String reason);

  @GET("connections/{name}/channels") Call<List<Channel>> getConnectionChannels(
      @Path("name") @NonNull String connection);

  @GET("channels") Call<List<Channel>> getChannels();

  @GET("vhosts/{vhost}/channels") Call<List<Channel>> getChannels(
      @Path("vhost") @NonNull String vhost);

  @GET("channels/{name}") Call<Channel> getChannel(@Path("name") @NonNull String name);

  // TODO: Add GET /consumers.

  // TODO: Add GET /consumers/{vhost}.

  @GET("exchanges") Call<List<ExtendedExchange>> getExchanges();

  @GET("exchanges/{vhost}") Call<List<ExtendedExchange>> getExchanges(
      @Path("vhost") @NonNull String vhost);

  @GET("exchanges/{vhost}/{exchange}") Call<ExtendedExchange> getExchange(
      @Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange);

  // TODO: Add PUT /exchanges/{vhost}/{exchange}.

  // TODO: Add DELETE /exchanges/{vhost}/{exchange}.

  @GET("exchanges/{vhost}/{exchange}/bindings/source") Call<List<Binding>> getSourceBindings(
      @Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange);

  @GET("exchanges/{vhost}/{exchange}/bindings/destination")
  Call<List<Binding>> getDestinationBindings(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange);

  // TODO: POST /exchanges/{vhost}/{name}/publish

  @GET("queues") Call<List<ExtendedQueue>> getQueues();

  @GET("queues/{vhost}") Call<List<ExtendedQueue>> getQueues(@Path("vhost") @NonNull String vhost);

  // TODO: Add PUT /queues/{vhost}.

  // TODO: Add DELETE /queues/{vhost}.

  @GET("queues/{vhost}/{queue}/bindings") Call<List<Binding>> getQueueBindings(
      @Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue);

  // TODO: Add PUT /queues/{vhost}/{queue}/contents.

  // TODO: Add DELETE /queues/{vhost}/{queue}/actions.

  // TODO: Add POST /queues/{vhost}/{queue}/get.

  @GET("bindings") Call<List<Binding>> getBindings();

  @GET("bindings/{vhost}") Call<List<Binding>> getBindings(@Path("vhost") @NonNull String vhost);

  @GET("bindings/{vhost}/e/{exchange}/q/{queue}")
  Call<List<ExtendedBinding>> getBindingsBetweenExchangeAndQueue(
      @Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange,
      @Path("queue") @NonNull String queue);

  // TODO: Add POST /bindings/{vhost}/e/{exchange}/q/{queue}.

  @GET("bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Call<ExtendedBinding> getBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
      @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
      @Path("props") @NonNull String propertiesKey);

  // TODO: Add DELETE /bindings/{vhost}/e/{exchange}/q/{queue}/props.

  @GET("bindings/{vhost}/e/{source}/e/{destination}")
  Call<List<ExtendedBinding>> getBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
      @Path("source") @NonNull String srcExchange,
      @Path("destination") @NonNull String dstExchange);

  // TODO: Add POST /bindings/{vhost}/e/{source}/e/{destination}.

  @GET("bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Call<ExtendedBinding> getBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
      @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
      @Path("props") @NonNull String propertiesKey);

  // TODO: Add DELETE /bindings/{vhost}/e/{source}/e/{destination}/props.

  @GET("vhosts") Call<List<ExtendedVhost>> getVhosts();

  @GET("vhosts/{name}") Call<ExtendedVhost> getVhost(@Path("name") @NonNull String name);

  // TODO: Add PUT /vhosts/{name}.

  // TODO: Add DELETE /vhosts/{name}.

  // TODO: Add GET /vhosts/{name}/permissions.

  // TODO: Add GET /users.

  // TODO: Add GET /users/{name}.

  // TODO: Add PUT /users/{name}.

  // TODO: Add DELETE /users/{name}.

  // TODO: Add GET /users/{name}/permissions.

  // TODO: Add GET /whoami.

  // TODO: Add GET /permissions.

  // TODO: Add GET /permissions/{vhost}/{user}.

  // TODO: Add PUT /permissions/{vhost}/{user}.

  // TODO: Add DELETE /permissions/{vhost}/{user}.

  // TODO: Add GET /parameters.

  // TODO: Add GET /parameters/{component}.

  // TODO: Add GET /parameters/{component}/{vhost}.

  // TODO: Add GET /parameters/{component}/{vhost}/{name}.

  // TODO: Add PUT /parameters/{component}/{vhost}/{name}.

  // TODO: Add DELETE /parameters/{component}/{vhost}/{name}.

  // TODO: Add GET /policies.

  // TODO: Add GET /policies/{vhost}.

  // TODO: Add GET /policies/{vhost}/{name}.

  // TODO: Add PUT /policies/{vhost}/{name}.

  // TODO: Add DELETE /policies/{vhost}/{name}.

  // TODO: Add GET /aliveness-test/{vhost}.

  // TODO: Add GET /healthchecks/node.

  // TODO: Add GET /healthchecks/node/{node}.

  class Headers {
    public static final String X_REASON = "X-Reason";
  }

  class Json {
    public static RabbitMqService createService() {
      OkHttpClient httpClient =
          new OkHttpClient.Builder().addInterceptor(new AuthorizationInterceptor(TEST_TOKEN))
              .addInterceptor(new ContentTypeInterceptor(CONTENT_TYPE))
              .build();

      Retrofit retrofit = new Retrofit.Builder().baseUrl(TEST_URL)
          .addConverterFactory(JacksonConverterFactory.create())
          .client(httpClient)
          .build();

      return retrofit.create(RabbitMqService.class);
    }
  }
}

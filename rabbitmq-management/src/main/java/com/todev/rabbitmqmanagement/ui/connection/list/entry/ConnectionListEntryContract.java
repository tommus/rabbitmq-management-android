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
package com.todev.rabbitmqmanagement.ui.connection.list.entry;

import android.support.annotation.NonNull;
import com.todev.rabbitmqmanagement.data.network.model.connection.ClientProperties;
import com.todev.rabbitmqmanagement.data.network.model.connection.Connection;

public interface ConnectionListEntryContract {
  interface View {
    boolean areDetailsVisible();

    void expandDetails();

    void collapseDetails();

    void displayName(String host, int port);

    void displayUsername(String username);

    void displayState(String state);

    void displaySslTls(boolean isSsl);

    void displaySslDetails(String sslDetails);

    void displayProtocol(String protocol);

    void displayChannels(int channels);

    void displayChannelMax(int channelMax);

    void displayFrameMax(int frameMax);

    void displayAuthMechanism(String authMechanism);

    void displayClient(ClientProperties clientProperties);

    void displayClientFromRate(float rate);

    void displayClientToRate(float rate);

    void displayHeartbeat(int heartbeat);

    void displayConnectedAt(long connectedAt);
  }

  interface Presenter {
    void onMoreButtonClicked();

    void bind(@NonNull Connection connection);
  }
}

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
import com.todev.rabbitmqmanagement.data.network.model.connection.Connection;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

public class ConnectionListEntryPresenter implements ConnectionListEntryContract.Presenter {
  @Setter ConnectionListEntryContract.View view;

  @Override
  public void onMoreButtonClicked() {
    if (view.areDetailsVisible()) {
      view.collapseDetails();
    } else {
      view.expandDetails();
    }
  }

  @Override
  public void bind(@NonNull Connection connection) {
    view.displayName(connection.getPeerHost(), connection.getPeerPort());
    view.displayUsername(connection.getUser());
    view.displayState(connection.getState());
    view.displaySslTls(connection.isSsl());
    view.displaySslDetails(StringUtils.EMPTY);
    view.displayProtocol(connection.getProtocol());
    view.displayChannels(connection.getChannels());
    view.displayChannelMax(connection.getChannelMax());
    view.displayFrameMax(connection.getFrameMax());
    view.displayAuthMechanism(connection.getAuthMechanism());
    view.displayClient(connection.getClientProperties());
    view.displayClientFromRate(connection.getRecvOctDetails().getRate());
    view.displayClientToRate(connection.getSendOctDetails().getRate());
    view.displayHeartbeat(connection.getTimeout());
    view.displayConnectedAt(connection.getConnectedAt());
  }
}

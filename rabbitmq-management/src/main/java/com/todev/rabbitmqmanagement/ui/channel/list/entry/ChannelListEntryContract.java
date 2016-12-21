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
package com.todev.rabbitmqmanagement.ui.channel.list.entry;

import android.support.annotation.NonNull;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.ui.BaseListEntryContract;

public interface ChannelListEntryContract {
  interface View extends BaseListEntryContract.View {
    void displayName(String host, int port, int channel);

    void displayUsername(String type);

    void displayMode(String mode);

    void displayState(String state);

    void displayUnconfirmed(int details);

    void displayPrefetch(String details);

    void displayUnacked(int details);

    void displayUncommittedMessages(int transactions);

    void displayUncommittedAcks(int transactions);

    void displayPublish(float rate);

    void displayConfirm(float rate);

    void displayReturnMandatory(float rate);

    void displayDeliverGet(float rate);

    void displayRedelivered(float rate);

    void displayAck(float rate);
  }

  interface Presenter extends BaseListEntryContract.Presenter {
    void bind(@NonNull Channel channel);
  }
}

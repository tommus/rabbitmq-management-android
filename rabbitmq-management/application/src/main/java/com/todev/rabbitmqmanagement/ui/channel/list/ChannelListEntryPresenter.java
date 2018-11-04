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
package com.todev.rabbitmqmanagement.ui.channel.list;

import android.support.annotation.NonNull;
import co.windly.rabbitmqmanagement.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.ui.BaseListEntryPresenter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

class ChannelListEntryPresenter extends BaseListEntryPresenter implements ChannelListEntryContract.Presenter {
  @Setter ChannelListEntryContract.View view;

  @Override
  public void bind(@NonNull Channel channel) {
    view.displayName(channel.getChannelDetails().getPeerHost(), channel.getChannelDetails().getPeerPort(), channel.getNumber());
    view.displayUsername(channel.getUser());
    view.displayMode(StringUtils.EMPTY);
    view.displayState(channel.getState());
    view.displayUnconfirmed(channel.getMessagesUnconfirmed());
    view.displayPrefetch(StringUtils.EMPTY);
    view.displayUnacked(channel.getMessagesUnacknowledged());
    view.displayUncommittedMessages(channel.getMessagesUncommitted());
    view.displayUncommittedAcks(channel.getAcksUncommitted());
    view.displayPublish(channel.getMessageStats().getPublishDetails().getRate());
    view.displayConfirm(channel.getMessageStats().getConfirmDetails().getRate());
    view.displayReturnMandatory(channel.getMessageStats().getReturnUnroutableDetails().getRate());
    view.displayDeliverGet(channel.getMessageStats().getDeliverGetDetails().getRate());
    view.displayRedelivered(channel.getMessageStats().getRedeliverDetails().getRate());
    view.displayAck(channel.getMessageStats().getAckDetails().getRate());
  }
}

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

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.ui.BaseListEntry;

@SuppressWarnings("WeakerAccess")
class ChannelListEntry extends BaseListEntry implements ChannelListEntryContract.View {
  @BindView(R.id.name) TextView nameView;
  @BindView(R.id.user) TextView userView;
  @BindView(R.id.mode) TextView modeView;
  @BindView(R.id.state) TextView stateView;
  @BindView(R.id.unconfirmed) TextView unconfirmedView;
  @BindView(R.id.prefetch) TextView prefetchView;
  @BindView(R.id.unacked) TextView unackedView;
  @BindView(R.id.uncommitted_msgs) TextView uncommittedMessagesView;
  @BindView(R.id.uncommitted_acks) TextView uncommittedAcknowledgesView;
  @BindView(R.id.publish) TextView publishView;
  @BindView(R.id.confirm) TextView confirmView;
  @BindView(R.id.return_mandatory) TextView returnMandatoryView;
  @BindView(R.id.deliver_get) TextView deliverGetView;
  @BindView(R.id.redelivered) TextView redeliveredView;
  @BindView(R.id.ack) TextView ackView;

  private ChannelListEntryPresenter presenter;

  ChannelListEntry(ViewGroup parent, @LayoutRes int layoutRes) {
    super(parent, layoutRes);

    presenter = new ChannelListEntryPresenter();
    presenter.setBaseView(this);
    presenter.setView(this);
  }

  public void bind(@NonNull Channel channel) {
    presenter.bind(channel);
  }

  @Override
  public void displayName(String host, int port, int channel) {
    nameView.setText(host + ":" + port + " (" + channel + ")");
  }

  @Override
  public void displayUsername(String type) {
    userView.setText(type);
  }

  @Override
  public void displayMode(String mode) {
    modeView.setText(mode);
  }

  @Override
  public void displayState(String state) {
    stateView.setText(state);
  }

  @Override
  public void displayUnconfirmed(int details) {
    String text = String.valueOf(details);
    unconfirmedView.setText(text);
  }

  @Override
  public void displayPrefetch(String details) {
    prefetchView.setText(details);
  }

  @Override
  public void displayUnacked(int details) {
    String text = String.valueOf(details);
    unackedView.setText(text);
  }

  @Override
  public void displayUncommittedMessages(int transactions) {
    String text = String.valueOf(transactions);
    uncommittedMessagesView.setText(text);
  }

  @Override
  public void displayUncommittedAcks(int transactions) {
    String text = String.valueOf(transactions);
    uncommittedAcknowledgesView.setText(text);
  }

  @Override
  public void displayPublish(float rate) {
    String text = getString(R.string.channel_rate_value, rate);
    publishView.setText(text);
  }

  @Override
  public void displayConfirm(float rate) {
    String text = getString(R.string.channel_rate_value, rate);
    confirmView.setText(text);
  }

  @Override
  public void displayReturnMandatory(float rate) {
    String text = getString(R.string.channel_rate_value, rate);
    returnMandatoryView.setText(text);
  }

  @Override
  public void displayDeliverGet(float rate) {
    String text = getString(R.string.channel_rate_value, rate);
    deliverGetView.setText(text);
  }

  @Override
  public void displayRedelivered(float rate) {
    String text = getString(R.string.channel_rate_value, rate);
    redeliveredView.setText(text);
  }

  @Override
  public void displayAck(float rate) {
    String text = getString(R.string.channel_rate_value, rate);
    ackView.setText(text);
  }
}

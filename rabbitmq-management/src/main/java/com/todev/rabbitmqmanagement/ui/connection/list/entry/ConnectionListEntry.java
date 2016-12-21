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

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.connection.ClientProperties;
import com.todev.rabbitmqmanagement.data.network.model.connection.Connection;
import com.todev.rabbitmqmanagement.ui.BaseViewHolder;
import java8.util.Optional;
import org.apache.commons.lang3.BooleanUtils;
import org.joda.time.LocalDateTime;

public class ConnectionListEntry extends BaseViewHolder implements ConnectionListEntryContract.View {
  @BindString(R.string.yes) String yes;
  @BindString(R.string.no) String no;
  @BindDrawable(R.drawable.ic_expand_less_gray_24dp) Drawable iconLess;
  @BindDrawable(R.drawable.ic_expand_more_gray_24dp) Drawable iconMore;
  @BindView(R.id.name) TextView nameView;
  @BindView(R.id.user) TextView userView;
  @BindView(R.id.more) ImageButton moreView;
  @BindView(R.id.details) View detailsView;
  @BindView(R.id.state) TextView stateView;
  @BindView(R.id.ssl_tls) TextView sslTlsView;
  @BindView(R.id.ssl_details) TextView sslDetailsView;
  @BindView(R.id.protocol) TextView protocolView;
  @BindView(R.id.channels) TextView channelsView;
  @BindView(R.id.channel_max) TextView channelMaxView;
  @BindView(R.id.frame_max) TextView frameMaxView;
  @BindView(R.id.auth_mechanism) TextView authMechanismView;
  @BindView(R.id.client) TextView clientView;
  @BindView(R.id.client_from) TextView clientFromView;
  @BindView(R.id.client_to) TextView clientToView;
  @BindView(R.id.heartbeat) TextView heartbeatView;
  @BindView(R.id.connected_at) TextView connectedAtView;

  private ConnectionListEntryPresenter presenter;
  private Context context;

  public ConnectionListEntry(ViewGroup parent, @LayoutRes int layoutRes) {
    super(parent, layoutRes);
    context = parent.getContext();

    presenter = new ConnectionListEntryPresenter();
    presenter.setView(this);
    moreView.setOnClickListener(view -> presenter.onMoreButtonClicked());
  }

  public void bind(@NonNull Connection connection) {
    presenter.bind(connection);
  }

  @Override
  public boolean areDetailsVisible() {
    return detailsView.getVisibility() == View.VISIBLE;
  }

  @Override
  public void expandDetails() {
    moreView.setImageDrawable(iconLess);
    detailsView.setVisibility(View.VISIBLE);
    ScaleAnimation expand = new ScaleAnimation(1, 1, 0, 1);
    expand.setDuration(225);
    expand.setInterpolator(new AccelerateDecelerateInterpolator());
    expand.setAnimationListener(new AnimationEndListener());
    detailsView.startAnimation(expand);
  }

  @Override
  public void collapseDetails() {
    moreView.setImageDrawable(iconMore);
    ScaleAnimation collapse = new ScaleAnimation(1, 1, 1, 0);
    collapse.setDuration(195);
    collapse.setInterpolator(new AccelerateDecelerateInterpolator());
    collapse.setAnimationListener(new AnimationEndListener(() -> {
      detailsView.setVisibility(View.GONE);
    }));
    detailsView.startAnimation(collapse);
  }

  @Override
  public void displayName(String host, int port) {
    String text = host + ":" + port;
    nameView.setText(text);
  }

  @Override
  public void displayState(String state) {
    stateView.setText(state);
  }

  @Override
  public void displayUsername(String username) {
    userView.setText(username);
  }

  @Override
  public void displaySslTls(boolean isSsl) {
    String text = BooleanUtils.toString(isSsl, yes, no);
    sslTlsView.setText(text);
  }

  @Override
  public void displaySslDetails(String sslDetails) {
    sslDetailsView.setText(sslDetails);
  }

  @Override
  public void displayProtocol(String protocol) {
    protocolView.setText(protocol);
  }

  @Override
  public void displayChannels(int channels) {
    String text = String.valueOf(channels);
    channelsView.setText(text);
  }

  @Override
  public void displayChannelMax(int channelMax) {
    String text = String.valueOf(channelMax);
    channelMaxView.setText(text);
  }

  @Override
  public void displayFrameMax(int frameMax) {
    String text = String.valueOf(frameMax);
    frameMaxView.setText(text);
  }

  @Override
  public void displayAuthMechanism(String authMechanism) {
    authMechanismView.setText(authMechanism);
  }

  @Override
  public void displayClient(ClientProperties clientProperties) {
    String text =
        getString(R.string.connection_client_value, clientProperties.getProduct(), clientProperties.getPlatform(),
            clientProperties.getVersion());
    clientView.setText(text);
  }

  @Override
  public void displayClientFromRate(float rate) {
    String text = getString(R.string.connection_from_client_value, rate);
    clientFromView.setText(text);
  }

  @Override
  public void displayClientToRate(float rate) {
    String text = getString(R.string.connection_to_client_value, rate);
    clientToView.setText(text);
  }

  @Override
  public void displayHeartbeat(int heartbeat) {
    String text = getString(R.string.connection_heartbeat_value, heartbeat);
    heartbeatView.setText(text);
  }

  @Override
  public void displayConnectedAt(long connectedAt) {
    String text = new LocalDateTime(connectedAt).toString("HH:mm:ss YYYY-MM-dd");
    connectedAtView.setText(text);
  }

  protected String getString(@StringRes int resId, Object... formatArgs) {
    return context.getString(resId, formatArgs);
  }

  private class AnimationEndListener implements Animation.AnimationListener {
    private final Runnable NOP_RUNNABLE = () -> {
      // Null Object Pattern.
    };

    private Runnable runnable = NOP_RUNNABLE;

    private AnimationEndListener() {
      this(null);
    }

    private AnimationEndListener(Runnable runnable) {
      this.runnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
    }

    @Override
    public void onAnimationStart(Animation animation) {
      // Do nothing by default.
    }

    @Override
    public void onAnimationEnd(Animation animation) {
      runnable.run();
      detailsView.clearAnimation();
      detailsView.setAnimation(null);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
      // Do nothing by default.
    }
  }
}

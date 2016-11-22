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
package com.todev.rabbitmqmanagement.ui.overview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.todev.rabbitmqmanagement.R;

public class GlobalCountsIndicator extends FrameLayout {
  protected TextView connections;
  protected TextView channels;
  protected TextView exchanges;
  protected TextView queues;
  protected TextView consumers;

  public GlobalCountsIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);

    inflate(context, R.layout.view_global_counts_indicator, this);
    initializeWidgets();
  }

  public void setConnections(int count) {
    connections.setText(String.valueOf(count));
  }

  public void setChannels(int count) {
    channels.setText(String.valueOf(count));
  }

  public void setExchanges(int count) {
    exchanges.setText(String.valueOf(count));
  }

  public void setQueues(int count) {
    queues.setText(String.valueOf(count));
  }

  public void setConsumers(int count) {
    consumers.setText(String.valueOf(count));
  }

  protected void initializeWidgets() {
    connections = (TextView) findViewById(R.id.connections);
    channels = (TextView) findViewById(R.id.channels);
    exchanges = (TextView) findViewById(R.id.exchanges);
    queues = (TextView) findViewById(R.id.queues);
    consumers = (TextView) findViewById(R.id.consumers);
  }
}

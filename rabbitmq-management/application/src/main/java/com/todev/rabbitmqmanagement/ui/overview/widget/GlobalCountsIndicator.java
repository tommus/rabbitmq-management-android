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
package com.todev.rabbitmqmanagement.ui.overview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.todev.rabbitmqmanagement.R;
import lombok.Getter;

public class GlobalCountsIndicator extends FrameLayout {
  @Getter View connectionsCardView;
  @Getter TextView connectionsTextView;

  @Getter View channelsCardView;
  @Getter TextView channelsTextView;

  @Getter View exchangesCardView;
  @Getter TextView exchangesTextView;

  @Getter View queuesCardView;
  @Getter TextView queuesTextView;

  @Getter View consumersCardView;
  @Getter TextView consumersTextView;

  public GlobalCountsIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);

    inflate(context, R.layout.view_global_counts, this);
    initializeWidgets();
  }

  protected void initializeWidgets() {
    connectionsCardView = findViewById(R.id.connections_card);
    connectionsTextView = (TextView) findViewById(R.id.connections);

    channelsCardView = findViewById(R.id.channels_card);
    channelsTextView = (TextView) findViewById(R.id.channels);

    exchangesCardView = findViewById(R.id.exchanges_card);
    exchangesTextView = (TextView) findViewById(R.id.exchanges);

    queuesCardView = findViewById(R.id.queues_card);
    queuesTextView = (TextView) findViewById(R.id.queues);

    consumersCardView = findViewById(R.id.consumers_card);
    consumersTextView = (TextView) findViewById(R.id.consumers);
  }
}

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

import com.todev.rabbitmqmanagement.data.network.model.MessageStats;
import com.todev.rabbitmqmanagement.data.network.model.overview.ObjectTotals;
import com.todev.rabbitmqmanagement.data.network.model.overview.Overview;
import com.todev.rabbitmqmanagement.data.network.model.overview.QueueTotals;
import java8.util.function.Predicate;

public interface OverviewContract {
  interface View {
    void showQueuedMessagesRangeDialogFragment();

    void showMessageRatesRangeDialogFragment();

    void updateQueuedMessages(Overview overview, Predicate<QueueTotals> predicate);

    void updateMessageRates(Overview overview, Predicate<MessageStats> predicate);

    void updateGlobalCounts(Overview overview, Predicate<ObjectTotals> predicate);

    void setOnConnectionsRunnable(Runnable runnable);

    void setOnChannelsRunnable(Runnable runnable);

    void setOnExchangesRunnable(Runnable runnable);

    void setOnQueuesRunnable(Runnable runnable);

    void setOnConsumersRunnable(Runnable runnable);

  }

  interface Presenter {
    void startUpdatingOverview();

    void onQueuedMessagesRangeButtonClicked();

    void onMessageRatesRangeButtonClicked();
  }
}

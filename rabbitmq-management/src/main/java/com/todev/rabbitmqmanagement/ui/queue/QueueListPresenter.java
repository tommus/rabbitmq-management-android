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
package com.todev.rabbitmqmanagement.ui.queue;

import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.ui.BaseRxPresenter;
import lombok.Setter;

public class QueueListPresenter extends BaseRxPresenter implements QueueListContract.Presenter {
  @Setter QueueListContract.View view;

  private RabbitMqService rabbitMqService;

  public QueueListPresenter(RabbitMqService rabbitMqService) {
    this.rabbitMqService = rabbitMqService;
  }

  @Override
  public void loadQueues() {
    disposable.add(rabbitMqService.getQueues()
        .subscribeOn(getIoScheduler())
        .observeOn(getObserveScheduler())
        .subscribe(queues -> view.updateQueues(queues), error -> view.showNetworkError()));
  }
}

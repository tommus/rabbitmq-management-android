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
package com.todev.rabbitmqmanagement.ui.queue.list.entry;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.network.model.queue.ExtendedQueue;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class QueueListEntryPresenterTest extends BaseTest {
  @Mock QueueListEntryContract.View view;
  @Mock ExtendedQueue queue;

  private QueueListEntryPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = new QueueListEntryPresenter();
    presenter.setView(view);
  }

  @Test
  public void should_display_all_values_on_bind() {
    // Given
    doReturn("queue.queue").when(queue).getName();
    doReturn("running").when(queue).getState();

    // When
    presenter.bind(queue);

    // Then
    verify(view).displayName("queue.queue");
    verify(view).displayState("running");
  }
}

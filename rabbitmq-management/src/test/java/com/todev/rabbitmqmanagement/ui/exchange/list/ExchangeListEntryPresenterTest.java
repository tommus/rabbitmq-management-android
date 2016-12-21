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
package com.todev.rabbitmqmanagement.ui.exchange.list;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.network.model.exchange.Exchange;
import com.todev.rabbitmqmanagement.ui.exchange.list.ExchangeListEntryContract;
import com.todev.rabbitmqmanagement.ui.exchange.list.ExchangeListEntryPresenter;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ExchangeListEntryPresenterTest extends BaseTest {
  @Mock ExchangeListEntryContract.View view;
  @Mock Exchange exchange;

  private ExchangeListEntryPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = new ExchangeListEntryPresenter();
    presenter.setView(view);
  }

  @Test
  public void should_display_all_values_on_bind() {
    // Given
    doReturn("amq.direct").when(exchange).getName();
    doReturn(Exchange.Type.DIRECT).when(exchange).getType();

    // When
    presenter.bind(exchange);

    // Then
    verify(view).displayName("amq.direct");
    verify(view).displayType(Exchange.Type.DIRECT);
  }
}

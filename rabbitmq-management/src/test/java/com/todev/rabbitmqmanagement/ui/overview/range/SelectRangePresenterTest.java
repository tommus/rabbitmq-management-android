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
package com.todev.rabbitmqmanagement.ui.overview.range;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.ui.overview.widget.MessagesIndicator.VisibleRange;
import java8.util.function.Supplier;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class SelectRangePresenterTest extends BaseTest {
  @Mock SelectRangeContract.View view;
  @Mock Supplier<String[]> supplier;
  private VisibleRange visibleRange = VisibleRange.ONE_MINUTE;

  private SelectRangePresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = spy(new SelectRangePresenter());
    presenter.setView(view);
  }

  @Test
  public void should_load_visible_ranges_using_supplier() {
    // Given
    String[] ranges = new String[] { "Show messages from last minute", "Show messages from last ten minutes" };
    doReturn(ranges).when(supplier).get();

    // When
    presenter.loadVisibleRanges(supplier);

    // Then
    verify(view).updateVisibleRanges(ranges);
  }

  @Test
  public void should_set_visible_range_on_item_click() {
    // When
    presenter.onItemClicked(visibleRange);

    // Then
    verify(view).setVisibleRange(visibleRange);
  }

  @Test
  public void should_close_dialog_fragment_after_setting_visible_range() {
    // When
    presenter.onItemClicked(visibleRange);

    // Then
    verify(view).close();
  }
}

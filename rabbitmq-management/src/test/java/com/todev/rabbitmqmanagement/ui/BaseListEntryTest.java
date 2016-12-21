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
package com.todev.rabbitmqmanagement.ui;

import com.todev.rabbitmqmanagement.BaseTest;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class BaseListEntryTest extends BaseTest {
  @Mock BaseListEntryContract.View view;

  private BaseListEntryPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = new BaseListEntryPresenter();
    presenter.setBaseView(view);
  }

  @Test
  public void should_expand_details_on_more_button_click() {
    // Given
    doReturn(false).when(view).areDetailsVisible();

    // When
    presenter.onMoreButtonClicked();

    // Then
    verify(view).expandDetails();
  }

  @Test
  public void should_collapse_details_on_less_button_click() {
    // Given
    doReturn(true).when(view).areDetailsVisible();

    // When
    presenter.onMoreButtonClicked();

    // Then
    verify(view).collapseDetails();
  }
}

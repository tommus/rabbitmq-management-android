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
package com.todev.rabbitmqmanagement.ui.login.addservice;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.database.model.Service;
import java8.util.function.Consumer;
import org.junit.Test;
import org.mockito.Mock;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class AddServicePresenterTest extends BaseTest {
  @Mock AddServiceContract.View view;
  @Mock Consumer<Integer> onSuccess;
  @Mock Service service;

  private AddServicePresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = spy(new AddServicePresenter());
    presenter.setView(view);
    presenter.setOnSuccess(onSuccess);

    prepareServiceMock();
    prepareViewMock();
  }

  protected void prepareServiceMock() {
    doReturn("label").when(service).getLabel();
    doReturn("localhost").when(service).getAddress();
    doReturn(8000).when(service).getPort();
  }

  protected void prepareViewMock() {
    doReturn("label").when(view).getLabel();
    doReturn("localhost").when(view).getAddress();
    doReturn(8000).when(view).getPortNumber();
  }

  @Test
  public void should_close_dialog_fragment_on_cancel_button_click() {
    // When
    presenter.onCancelButtonClicked();

    // Then
    verify(view).close();
  }

  @Test
  public void should_prepare_service_on_ok_button_click() {
    // Given
    doReturn(service).when(presenter).prepareService(anyString(), anyString(), anyInt());
    doNothing().when(service).save();

    // When
    presenter.onOkButtonClicked();

    // Then
    verify(presenter).prepareService(anyString(), anyString(), anyInt());
  }

  @Test
  public void should_show_error_on_incorrect_label() {
    // Given
    doReturn(service).when(presenter).prepareService(anyString(), anyString(), anyInt());
    doReturn(false).when(presenter).validateLabel(anyString());

    // When
    presenter.onOkButtonClicked();

    // Then
    verify(view).showInvalidLabelError();
  }

  @Test
  public void should_show_error_on_incorrect_address() {
    // Given
    doReturn(service).when(presenter).prepareService(anyString(), anyString(), anyInt());
    doReturn(true).when(presenter).validateLabel(anyString());
    doReturn(false).when(presenter).validateAddress(anyString());

    // When
    presenter.onOkButtonClicked();

    // Then
    verify(view).showInvalidAddressError();
  }

  @Test
  public void should_show_error_on_incorrect_port_number() {
    // Given
    doReturn(service).when(presenter).prepareService(anyString(), anyString(), anyInt());
    doReturn(true).when(presenter).validateLabel(anyString());
    doReturn(true).when(presenter).validateAddress(anyString());
    doReturn(false).when(presenter).validatePort(anyInt());

    // When
    presenter.onOkButtonClicked();

    // Then
    verify(view).showInvalidPortNumberError();
  }

  @Test
  public void should_save_service_call_on_success_and_close_dialog_fragment_on_valid_data() {
    // Given
    doReturn(service).when(presenter).prepareService(anyString(), anyString(), anyInt());
    doReturn(true).when(presenter).validateLabel(anyString());
    doReturn(true).when(presenter).validateAddress(anyString());
    doReturn(true).when(presenter).validatePort(anyInt());

    // When
    presenter.onOkButtonClicked();

    // Then
    verify(service).save();
    verify(onSuccess).accept(anyInt());
    verify(view).close();
  }

  @Test
  public void should_fail_on_empty_label() {
    // When
    boolean result = presenter.validateLabel("");

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void should_fail_on_to_big_or_to_small_port_number() {
    // When
    boolean small = presenter.validatePort(1024);
    boolean big = presenter.validatePort(65536);

    assertThat(small).isFalse();
    assertThat(big).isFalse();
  }
}

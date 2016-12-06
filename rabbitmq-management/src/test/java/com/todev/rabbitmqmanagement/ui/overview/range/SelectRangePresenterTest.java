package com.todev.rabbitmqmanagement.ui.overview.range;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.ui.overview.MessagesIndicator.VisibleRange;
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

package com.todev.rabbitmqmanagement.ui.overview.range;

import com.todev.rabbitmqmanagement.ui.overview.MessagesIndicator;
import java8.util.function.Supplier;
import lombok.Setter;

public class SelectRangePresenter implements SelectRangeContract.Presenter {
  @Setter SelectRangeContract.View view;

  @Override
  public void loadVisibleRanges(Supplier<String[]> supplier) {
    String[] visibleRanges = supplier.get();
    view.updateVisibleRanges(visibleRanges);
  }

  @Override
  public void onItemClicked(MessagesIndicator.VisibleRange visibleRange) {
    view.setVisibleRange(visibleRange);
    view.close();
  }
}

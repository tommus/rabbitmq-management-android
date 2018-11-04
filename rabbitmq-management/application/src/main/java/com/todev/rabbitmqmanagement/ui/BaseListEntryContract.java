package com.todev.rabbitmqmanagement.ui;

public interface BaseListEntryContract {
  interface View {
    boolean areDetailsVisible();

    void expandDetails();

    void collapseDetails();
  }

  interface Presenter {
    void onMoreButtonClicked();
  }
}

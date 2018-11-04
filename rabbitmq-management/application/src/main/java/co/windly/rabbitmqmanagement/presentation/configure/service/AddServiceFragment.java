package co.windly.rabbitmqmanagement.presentation.configure.service;

import android.os.Bundle;
import androidx.annotation.NonNull;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.rabbitmqmanagement.R;

public class AddServiceFragment extends LimboFragment<AddServiceView, AddServicePresenter> implements AddServiceView {

  //region Fragment

  public static AddServiceFragment createInstance() {

    // Prepare bundle.
    final Bundle bundle = new Bundle();

    // Instantiate fragment and return.
    final AddServiceFragment fragment = new AddServiceFragment();
    fragment.setArguments(bundle);
    return fragment;
  }

  //endregion

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.fragment_add_service;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public AddServicePresenter createPresenter() {
    return new AddServicePresenter();
  }

  //endregion
}

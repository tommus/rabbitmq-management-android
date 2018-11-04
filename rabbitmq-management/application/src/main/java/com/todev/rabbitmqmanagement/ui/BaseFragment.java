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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment extends Fragment {
  protected Unbinder unbinder;

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, getActivity());
  }

  @Override
  public void onDestroyView() {
    unbinder.unbind();
    super.onDestroyView();
  }
}

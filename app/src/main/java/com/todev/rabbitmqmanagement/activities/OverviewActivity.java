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
package com.todev.rabbitmqmanagement.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.fragments.QueuedMessagesFragment;

public class OverviewActivity extends AppCompatActivity {

  @BindView(R.id.activity_overview)
  View rootView;

  QueuedMessagesFragment queuedMessagesFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_overview);

    ButterKnife.bind(this);

    queuedMessagesFragment =
        (QueuedMessagesFragment) getSupportFragmentManager().findFragmentById(R.id.queued_messages_fragment);
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (queuedMessagesFragment.getView() != null) {
      animate(queuedMessagesFragment.getView(), rootView);
    }
  }

  private void animate(@NonNull View view, @NonNull View parent) {
    view.animate().cancel();
    view.setAlpha(0);
    view.setTranslationY(parent.getHeight());
    view.animate().alpha(1f).translationY(0).setDuration(600).setStartDelay(400);
  }
}

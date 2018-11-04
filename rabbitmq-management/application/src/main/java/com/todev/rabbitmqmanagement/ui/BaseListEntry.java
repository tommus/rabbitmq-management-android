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

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import butterknife.BindDrawable;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import java8.util.Optional;

@SuppressWarnings("WeakerAccess")
public class BaseListEntry extends BaseViewHolder implements BaseListEntryContract.View {
  @BindDrawable(R.drawable.ic_expand_less_gray_24dp) Drawable iconLess;
  @BindDrawable(R.drawable.ic_expand_more_gray_24dp) Drawable iconMore;
  @BindView(R.id.more) ImageButton moreView;
  @BindView(R.id.details) View detailsView;

  private Context context;

  public BaseListEntry(ViewGroup parent, @LayoutRes int layoutRes) {
    super(parent, layoutRes);
    context = parent.getContext();

    moreView.setOnClickListener(view -> {
      if (areDetailsVisible()) {
        collapseDetails();
      } else {
        expandDetails();
      }
    });
  }

  protected String getString(@StringRes int resId, Object... formatArgs) {
    return context.getString(resId, formatArgs);
  }

  @Override
  public boolean areDetailsVisible() {
    return detailsView.getVisibility() == View.VISIBLE;
  }

  @Override
  public void expandDetails() {
    moreView.setImageDrawable(iconLess);
    detailsView.setVisibility(View.VISIBLE);
    ScaleAnimation expand = new ScaleAnimation(1, 1, 0, 1);
    expand.setDuration(225);
    expand.setInterpolator(new AccelerateDecelerateInterpolator());
    expand.setAnimationListener(new AnimationEndListener());
    detailsView.startAnimation(expand);
  }

  @Override
  public void collapseDetails() {
    moreView.setImageDrawable(iconMore);
    ScaleAnimation collapse = new ScaleAnimation(1, 1, 1, 0);
    collapse.setDuration(195);
    collapse.setInterpolator(new AccelerateDecelerateInterpolator());
    collapse.setAnimationListener(new AnimationEndListener(() -> {
      detailsView.setVisibility(View.GONE);
    }));
    detailsView.startAnimation(collapse);
  }

  private class AnimationEndListener implements Animation.AnimationListener {
    private final Runnable NOP_RUNNABLE = () -> {
      // Null Object Pattern.
    };

    private Runnable runnable = NOP_RUNNABLE;

    private AnimationEndListener() {
      this(null);
    }

    private AnimationEndListener(Runnable runnable) {
      this.runnable = Optional.ofNullable(runnable).orElse(NOP_RUNNABLE);
    }

    @Override
    public void onAnimationStart(Animation animation) {
      // Do nothing by default.
    }

    @Override
    public void onAnimationEnd(Animation animation) {
      runnable.run();
      detailsView.clearAnimation();
      detailsView.setAnimation(null);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
      // Do nothing by default.
    }
  }
}

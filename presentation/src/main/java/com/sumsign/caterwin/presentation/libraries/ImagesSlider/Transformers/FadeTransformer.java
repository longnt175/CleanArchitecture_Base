package com.sumsign.caterwin.presentation.libraries.ImagesSlider.Transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by realandylawton on 11/22/13.
 */
public class FadeTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        final float alpha = 1f + Math.abs(position);
        ViewHelper.setAlpha(view,position < -1f || position > 1f ? 0f : 1f - (alpha - 1f));

    }

}
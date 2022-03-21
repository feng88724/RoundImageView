package com.zhuyefeng.riv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * 圆角 ImageView
 * 可设定任意角为圆角
 */
public class RoundImageView extends AppCompatImageView {

    // 弧度，单位均为像素
    private int radius = 0;
    private int topLeftRadius = 0;
    private int topRightRadius = 0;
    private int bottomRightRadius = 0;
    private int bottomLeftRadius = 0;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
        radius = typedArray.getDimensionPixelSize(R.styleable.RoundImageView_radius, 0);
        topLeftRadius = typedArray.getDimensionPixelSize(R.styleable.RoundImageView_topLeftRadius, 0);
        topRightRadius = typedArray.getDimensionPixelSize(R.styleable.RoundImageView_topRightRadius, 0);
        bottomRightRadius = typedArray.getDimensionPixelSize(R.styleable.RoundImageView_bottomRightRadius, 0);
        bottomLeftRadius = typedArray.getDimensionPixelSize(R.styleable.RoundImageView_bottomLeftRadius, 0);

    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private Path getPath() {

        final Path path = new Path();
        final float[] radii = new float[8];

        if (topLeftRadius > 0) {
            radii[0] = topLeftRadius;
            radii[1] = topLeftRadius;
        } else if (radius > 0) {
            radii[0] = radius;
            radii[1] = radius;
        }

        if (topRightRadius > 0) {
            radii[2] = topRightRadius;
            radii[3] = topRightRadius;
        } else if (radius > 0) {
            radii[2] = radius;
            radii[3] = radius;
        }

        if (bottomRightRadius > 0) {
            radii[4] = bottomRightRadius;
            radii[5] = bottomRightRadius;
        } else if (radius > 0) {
            radii[4] = radius;
            radii[5] = radius;
        }

        if (bottomLeftRadius > 0) {
            radii[6] = bottomLeftRadius;
            radii[7] = bottomLeftRadius;
        } else if (radius > 0) {
            radii[6] = radius;
            radii[7] = radius;
        }

        path.addRoundRect(new RectF(0, 0, getWidth(), getHeight()), radii, Path.Direction.CW);

        return path;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //Path path = new Path();
        //path.addRoundRect(new RectF(0, 0, getWidth(), getHeight()), radius, radius, Path.Direction.CW);

        Path path = getPath();
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    public int getRadius() {
        return radius;
    }

    public int getTopLeftRadius() {
        return topLeftRadius;
    }

    public void setTopLeftRadius(int topLeftRadius) {
        this.topLeftRadius = topLeftRadius;
    }

    public int getTopRightRadius() {
        return topRightRadius;
    }

    public void setTopRightRadius(int topRightRadius) {
        this.topRightRadius = topRightRadius;
    }

    public int getBottomRightRadius() {
        return bottomRightRadius;
    }

    public void setBottomRightRadius(int bottomRightRadius) {
        this.bottomRightRadius = bottomRightRadius;
    }

    public int getBottomLeftRadius() {
        return bottomLeftRadius;
    }

    public void setBottomLeftRadius(int bottomLeftRadius) {
        this.bottomLeftRadius = bottomLeftRadius;
    }
}

package com.example.lolhanding.layout;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class RoundImageView extends AppCompatImageView {
    private Path path;

    public RoundImageView(Context context) {
        super(context);
        init();
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        path.reset();
        path.addCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}

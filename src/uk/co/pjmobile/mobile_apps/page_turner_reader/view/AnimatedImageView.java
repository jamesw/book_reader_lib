package uk.co.pjmobile.mobile_apps.page_turner_reader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import animation.Animator;

public class AnimatedImageView extends ImageView {

	private Animator animator;

	public AnimatedImageView(Context context, AttributeSet attributes) {
		super(context, attributes);
	}

	public void setAnimator(Animator animator) {
		this.animator = animator;
	}

	public Animator getAnimator() {
		return animator;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (this.animator != null) {
			animator.draw(canvas);
		}
	}
}

package com.example.animationbetweenfragments
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

object  Flip {

    fun InX(view: View): AnimatorSet {
        val animatorSet = AnimatorSet()

        val object1 = ObjectAnimator.ofFloat(view, "alpha", 0.25f, 0.5f, 0.75f, 1f)
        val object2 = ObjectAnimator.ofFloat(view, "rotationX", 90f, -15f, 15f, 0f)

        animatorSet.playTogether(object1, object2)
        return animatorSet
    }
}

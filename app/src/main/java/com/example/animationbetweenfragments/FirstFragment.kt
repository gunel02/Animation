package com.example.animationbetweenfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.animationbetweenfragments.databinding.FragmentFirstBinding
import render.animations.Render


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var isOriginalState = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)


        // fragment animations
//        binding.lottieAnimationView.setOnClickListener {
//            binding.lottieAnimationView.visibility = View.VISIBLE
//            binding.lottieAnimationView.playAnimation()
//        }
//
        binding.main.setOnClickListener {
            val fragment = SecondFragment()
            val transaction: FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(
                R.anim.from_right,
                R.anim.to_left,
                R.anim.from_left,
                R.anim.to_right
            )
            transaction.add(R.id.fragment_container, fragment).addToBackStack(fragment.tag)
            transaction.replace(R.id.fragment_container, fragment).addToBackStack(null)
            transaction.commit()
        }
//


        // icon animations
        binding.arrow.visibility = View.GONE
        binding.image.visibility = View.GONE
        binding.delete.visibility = View.GONE

        val render = Render(requireContext())
        render.setDuration(3000)

        binding.selectButton.setOnClickListener {
            if (isOriginalState) {

                render.setAnimation(Flip.InX(binding.image))
                render.start()
                render.setAnimation(Flip.InX(binding.delete))
                render.start()
                render.setAnimation(Flip.InX(binding.arrow))
                render.start()

                binding.arrow.visibility = View.VISIBLE
                binding.image.visibility = View.VISIBLE
                binding.delete.visibility = View.VISIBLE
                binding.download.visibility = View.GONE
                binding.setting.visibility = View.GONE

            } else {

                render.setAnimation(Flip.InX(binding.setting))
                render.start()
                render.setAnimation(Flip.InX(binding.download))
                render.start()
                render.setAnimation(Flip.InX(binding.arrow))
                render.start()
                render.setAnimation(Flip.InX(binding.image))
                render.start()
                render.setAnimation(Flip.InX(binding.delete))
                render.start()

                binding.setting.visibility = View.VISIBLE
                binding.download.visibility = View.VISIBLE
                binding.arrow.visibility = View.GONE
                binding.image.visibility = View.GONE
                binding.delete.visibility = View.GONE
            }
            isOriginalState = !isOriginalState
        }


//        binding.selectButton.setOnClickListener {
//
//            render.setAnimation(com.example.animationbetweenfragments.Flip.InX(binding.image))
//            render.start()
//            render.setAnimation(com.example.animationbetweenfragments.Flip.InX(binding.delete))
//            render.start()
//            render.setAnimation(com.example.animationbetweenfragments.Flip.InX(binding.arrow))
//            render.start()
//
//            binding.lottieAnimationView.visibility = View.GONE
//            binding.arrow.visibility = View.VISIBLE
//            binding.image.visibility = View.VISIBLE
//            binding.delete.visibility = View.VISIBLE
//            binding.download.visibility = View.GONE
//
//
//            view?.startAnimation(scaleUp) // For scale-up
//            view?.startAnimation(scaleDown) // For scale-down


//            binding.action.setAction(BackAction(), ActionView.ROTATE_COUNTER_CLOCKWISE)

//            render.setAnimation(Attention.Flash(binding.download))
//            render.start()

//            binding.setting.visibility = View.GONE

        // animation with anim file
//            binding.arrow.startAnimation(fade)
//            binding.image.startAnimation(fade)
//            binding.delete.startAnimation(fade)


//            animDownload.setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation) {
//
//                    // Optional: Code to run when the animation starts
//                }
//
//                override fun onAnimationEnd(animation: Animation) {
//                    binding.download.postDelayed({
//                        binding.download.visibility = View.GONE
//                    }, 1000)
//                    // When the animation ends, change visibility and start animations
//                }
//
//                override fun onAnimationRepeat(animation: Animation) {
//                    // Optional: Code to run when the animation repeats
//                }
//            })
//            binding.download.startAnimation(animDownload)
//        }

        return binding.root
    }
}

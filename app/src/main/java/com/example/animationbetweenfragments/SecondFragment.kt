package com.example.animationbetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.animationbetweenfragments.databinding.FragmentFirstBinding
import com.example.animationbetweenfragments.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)


        // animation between fragments
        binding.main.setOnClickListener{
            val fragment = FirstFragment()
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.from_left, R.anim.to_right, R.anim.from_right, R.anim.to_left)
            transaction.add(R.id.fragment_container, fragment).addToBackStack(fragment.tag)
            transaction.replace(R.id.fragment_container, fragment).addToBackStack(null)
            transaction.commit()
        }

        return binding.root
    }

}
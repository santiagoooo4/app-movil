package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentLogoBinding

class LogoFragment : Fragment() {

    private var _binding: FragmentLogoBinding? = null
    private val binding: FragmentLogoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentLogoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}
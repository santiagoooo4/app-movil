package com.example.minticaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.minticaplication.databinding.FragmentForgotBinding
import java.util.zip.Inflater


class ForgotFragment : Fragment() {

    private var _binding: FragmentForgotBinding? = null;
    private val binding: FragmentForgotBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotBinding.inflate(inflater, container, false)// Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentForgotRegistrarseButon.setOnClickListener{
            findNavController().navigate(R.id.action_forgotFragment_to_registerFragment)
        }
    }
}
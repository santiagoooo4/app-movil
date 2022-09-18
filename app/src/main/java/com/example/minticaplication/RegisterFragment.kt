package com.example.minticaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.minticaplication.databinding.FragmentLoginBinding
import com.example.minticaplication.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var _binding: FragmentRegisterBinding? = null
    private val binding: FragmentRegisterBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.IngresaAqui.setOnClickListener{
            findNavController().navigate((R.id.action_registerFragment_to_loginFragment))
        }

    }
}
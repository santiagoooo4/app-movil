package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentLoginBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.fragmentLoginBottom.setOnClickListener {
            if (!binding.loginEmail.text.toString().isValidEmail()){
                binding.loginEmailLayout.error = getString(R.string.error_email)
            } else {
                binding.loginEmailLayout.error = null
            }

            if (!binding.loginPassword.text.toString().isValidPassword()){
                    binding.passwdLoginLayout.error = getString(R.string.invalid_password)
                } else {
                binding.passwdLoginLayout.error = null
            }

            binding.fragmentLoginBottom.setOnClickListener {
                findNavController().navigate(R.id.action_logoFragment_to_registerFragment)
            }
        }
   }
}
package com.example.minticaplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.minticaplication.databinding.ActivityWelcomeBinding
import com.example.minticaplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.loginBottom.setOnClickListener {
            if (!binding.loginEmailInputBox.text.toString().isValidEmail()){
                binding.loginEmailInputLayout.error = "Correo Invalido"
            } else {
                binding.loginEmailInputLayout.error = null
            }

            if (!binding.loginPasswdInputBox.text.toString().isValidPassword()){
                binding.loginPasswdInputLayout.error = "Password Invalido"
            } else {
                binding.loginPasswdInputLayout.error = null
            }
            if (binding.loginEmailInputBox.text.toString().isValidEmail() && binding.loginPasswdInputBox.text.toString().isValidPassword()){
                 val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }

        binding.createCuenta.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.loginForgotButon.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
        }
    }
}
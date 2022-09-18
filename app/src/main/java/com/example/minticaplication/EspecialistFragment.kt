package com.example.minticaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.minticaplication.databinding.FragmentEspcialistBinding


class EspcialistFragment : Fragment() {

    private var _binding: FragmentEspcialistBinding? = null;
    private val binding: FragmentEspcialistBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEspcialistBinding.inflate(inflater, container, false)
        return binding.root
    }
}
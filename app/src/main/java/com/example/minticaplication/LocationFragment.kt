package com.example.minticaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.minticaplication.databinding.FragmentLocationBinding


class LocationFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null;
    private val binding: FragmentLocationBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationBinding.inflate(inflater, container, false)        // Inflate the layout for this fragment
        return binding.root
    }
}
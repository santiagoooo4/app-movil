package com.example.minticaplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minticaplication.databinding.FragmentHomeBinding
import com.example.minticaplication.ServiceAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var  serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(
            listOf(
                ServiceModel(
                    "1","General","Los Mejores especialistas en medicina general",
                    R.drawable.ico_general.toString()),
                ServiceModel(
                    "2","Especialista","Los Mejores medicos especialistas",
                    R.drawable.ico_especialidades.toString()),
                ServiceModel(
                   "3","Odontologia","Los Mejores especialistas en odontologia",
                    R.drawable.ico_odontologia.toString()),
                ServiceModel(
                    "4","Dermatologia","Los Mejores especialistas en dermatologia",
                    R.drawable.ico_dermatologia.toString()),
                ServiceModel(
                    "5","Pediatria","Los Mejores especialistas en pediatria",
                    R.drawable.ico_pediatria.toString())
            )
        )
        serviceAdapter.listener = object : OnServiceClickListener{
            override fun onClick(item: ServiceModel) {
                val action = HomeFragmentDirections.actionHomeFragmentToEspcialistFragment()
                action.search = false
                action.name = item.title
                action.description = item.descripcion
                findNavController().navigate(action)
            }
        }
        binding.fragmentHomeRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
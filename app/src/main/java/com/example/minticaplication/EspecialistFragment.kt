package com.example.minticaplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minticaplication.databinding.FragmentEspcialistBinding


class EspcialistFragment : Fragment() {

    private var _binding: FragmentEspcialistBinding? = null;
    private val binding: FragmentEspcialistBinding get() = _binding!!
    private val args: EspcialistFragmentArgs by navArgs()
    private lateinit var  doctorAdapter: DoctorAdapter
    private lateinit var  doctorList: List<DoctorModel>
    private lateinit var  mainList: List<DoctorModel>
    private lateinit var  categorias: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEspcialistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        categorias = listOf(
            "Todos", "Optometria", "Especialista", "Odontologia", "Pediatria", "General"
        )
        mainList = listOf(
            DoctorModel(
                "1","Dra. Sandra Gomez","General",
                R.drawable.doc3_660x440 .toString(), 2.0),
            DoctorModel(
                "2","Dr. Ricardo Cuesta","Optometria",
                R.drawable.doc1598x900.toString(), 3.0),
            DoctorModel(
                "3","Dr. Pedro Pablo","Odontologia",
                R.drawable.doc2_626x702.toString(), 5.0),
            DoctorModel(
                "4","Dra. Silvia Santos","Dermatologia",
                R.drawable.doc4_283x425.toString(), 3.5),
            DoctorModel(
                "5","Dra. Sandra Gomez","Pediatria",
                R.drawable.ico_general.toString(), 1.0)
        )
        if (args.search){
            binding.fragmentSpecialistSearch.visibility = View.VISIBLE
            binding.fragmentSpecialistTittleList.visibility = View.GONE
            binding.fragmentSpecialistTitle.text = getString(R.string.generic_specialist_title)
            binding.fragmentSpecialistSubtitle.text = getString(R.string.generic_specialist_subtitle)
        }else{
            binding.fragmentSpecialistSearch.visibility = View.GONE
            binding.fragmentSpecialistTittleList.visibility = View.VISIBLE
            binding.fragmentSpecialistTitle.text = args.name
            binding.fragmentSpecialistSubtitle.text = args.description
            doctorList = mainList.filter { x -> x.especialidad == args.name }
        }
        // creacion del adaptador para el autocomplete
        binding.fragmentSpecialistAutocomplete.setAdapter(
            ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categorias)
        )
        binding.fragmentSpecialistAutocomplete.setOnItemClickListener { parent, view, position, l ->
            val category = categorias[position]
            if(category == "Todos")
                doctorList = mainList
            else
                doctorList = mainList.filter { x -> x.especialidad == category } 
            doctorAdapter.UpdateSet(doctorList)
        }
        doctorAdapter = DoctorAdapter(mainList)

        doctorAdapter.listener = object : OnDoctorClickListener{
            override fun onClick(doctor: DoctorModel) {
                Log.d("HOla", doctor.id)
            }
        }
        binding.fragmentSpecialistRecycler.apply {
            adapter = doctorAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }



    }
}
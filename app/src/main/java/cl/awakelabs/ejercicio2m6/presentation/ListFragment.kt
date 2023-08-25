package cl.awakelabs.ejercicio2m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.awakelabs.ejercicio2.R
import cl.awakelabs.ejercicio2.databinding.FragmentListBinding
import cl.awakelabs.ejercicio2m6.data.local.Item

class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding : FragmentListBinding
    private val itemVM: ItemVM by activityViewModels()
    val adapter = ItemAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentListBinding.inflate(inflater, container, false)
       initList()
        toListed()
        return binding.root
    }

    private fun toListed() {
        binding.btnGo.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_homeFragment)
        }
    }

    private fun initList() {
        //asignamos el adapter al recyclerview
        itemVM.getAllItems().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        binding.recyclerView.adapter = adapter

    }


}
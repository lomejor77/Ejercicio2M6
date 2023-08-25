package cl.awakelabs.ejercicio2m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import cl.awakelabs.ejercicio2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val itemViewModel : ItemVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container, false)
        initListere()

        return binding.root
    }

    private fun initListere() {
        binding.btnAdd.setOnClickListener {
            val name = binding.editItem.text.toString()
            val price = binding.editPrice.text.toString().toInt()
            val qty = binding.editQty.text.toString().toInt()

            itemViewModel.insertItems(name,price,qty)
            cleanHome()
            messaje()
        }
    }

    private fun cleanHome() {
        binding.editItem.setText("")
        binding.editPrice.setText("")
        binding.editQty.setText("")
    }
    private fun messaje() {
        Toast.makeText(requireContext(), "Se ha ingresado correctamente", Toast.LENGTH_LONG).show()
    }

}
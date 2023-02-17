package ru.nashproject.beiny.view.logreg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nashproject.beiny.databinding.FragmentRegisterMasterBinding

class RegisterMasterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterMasterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterMasterBinding.inflate(layoutInflater)



        return binding.root

    }



    companion object {
        @JvmStatic
        fun newInstance() {
        }

    }
}
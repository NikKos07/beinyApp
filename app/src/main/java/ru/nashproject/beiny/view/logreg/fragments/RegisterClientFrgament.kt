package ru.nashproject.beiny.view.logreg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nashproject.beiny.databinding.FragmentRegisterClientBinding




class RegisterClientFragment : Fragment() {
    private lateinit var binding: FragmentRegisterClientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterClientBinding.inflate(layoutInflater)



        return binding.root

    }



    companion object {
        @JvmStatic
        fun newInstance() {
        }

    }
}
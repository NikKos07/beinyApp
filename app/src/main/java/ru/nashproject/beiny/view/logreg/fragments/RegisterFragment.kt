package ru.nashproject.beiny.view.logreg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nashproject.beiny.R
import ru.nashproject.beiny.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)


        register()


        return binding.root

    }

private fun register() = with(binding){
   regBtnClient.setOnClickListener {
       activity?.supportFragmentManager
           ?.beginTransaction()
           ?.replace(R.id.fragment,RegisterClientFragment())
           ?.addToBackStack("LoginToRegister")
           ?.commit()
   }
    regBtnMaster.setOnClickListener {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment,RegisterMasterFragment())
            ?.addToBackStack("LoginToRegister")
            ?.commit()
    }

}

    companion object {
        @JvmStatic
        fun newInstance() {
        }

    }
}
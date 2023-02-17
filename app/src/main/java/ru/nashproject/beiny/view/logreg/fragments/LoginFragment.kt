package ru.nashproject.beiny.view.logreg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nashproject.beiny.R
import ru.nashproject.beiny.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        moveRegister()

        return binding.root


    }

   private fun moveRegister(){
        binding.loginLinear1BtnRegister.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment,RegisterFragment())
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

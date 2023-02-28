package ru.nashproject.beiny.view.logreg.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.nashproject.beiny.R
import ru.nashproject.beiny.databinding.FragmentLoginBinding
import ru.nashproject.beiny.serviceBeinyApi


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()



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

    private fun getData(){

        val info = serviceBeinyApi.getMastersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("MyLog", it.toString())
            }

    }

    companion object {
        @JvmStatic
        fun newInstance() {
        }

            }
    }

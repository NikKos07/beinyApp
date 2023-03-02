package ru.nashproject.beiny.view.logreg.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import ru.nashproject.beiny.data.MasterGetData
import ru.nashproject.beiny.data.MasterRegData
import ru.nashproject.beiny.databinding.FragmentRegisterMasterBinding
import ru.nashproject.beiny.retrofit
import ru.nashproject.beiny.serviceBeinyApi

class RegisterMasterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterMasterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterMasterBinding.inflate(layoutInflater)

        registerMaster()

        return binding.root



    }

    private fun registerMaster() = with(binding){


        registermasLinear1BtnRegister.setOnClickListener {

            val firstName = registermasTvLinear1EdittextFirstname.text.toString()
            val lastName = registermasTvLinear1EdittextLastname.text.toString()
            val email = registermasTvLinear1EdittextEmail.text.toString()
            val phone = registermasTvLinear1EdittextPhone.text.toString().toLong()
            val age = registermasTvLinear1EdittextAge.text.toString().toInt()
            val passw = registermasTvLinear1EdittextPassword.text.toString()



                serviceBeinyApi.registerMaster(
                    MasterRegData(
                    firstname = firstName,
                    lastname = lastName,
                    email = email,
                    age = age,
                    passw = passw,
                    profession = "Master",
                    phone = phone,

                    )
                ).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object: Observer<MasterRegData>{

                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onNext(data: MasterRegData) {

                        }

                        override fun onError(e: Throwable) {
                        Log.d("MyLog", "$e")
                        }

                        override fun onComplete() {

                        }

                    })


            Toast.makeText(
                requireContext(),
                "Пользователь $firstName $lastName создан",
                Toast.LENGTH_LONG)
                .show()



        }
    }





    companion object {
        @JvmStatic
        fun newInstance() {
        }

    }
}
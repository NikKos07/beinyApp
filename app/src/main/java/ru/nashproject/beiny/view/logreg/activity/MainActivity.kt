package ru.nashproject.beiny.view.logreg.activity

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import ru.nashproject.beiny.R
import ru.nashproject.beiny.databinding.ActivityMainBinding
import ru.nashproject.beiny.view.logreg.fragments.LoginFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().add(R.id.fragment,LoginFragment()).commit()

    }
    private fun hideKeyboard() {
        val imm: InputMethodManager = getSystemService(
            Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.getAction() ==  MotionEvent.ACTION_DOWN){
            hideKeyboard()

    }
        return super.dispatchTouchEvent(ev)
}


    companion object{
        const val BASE_URL="http://192.168.7.62:8080"
    }
}

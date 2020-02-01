package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
       private lateinit var binding:ActivityMainBinding

    private val myName:MyName= MyName("Bryann Alfaro")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main) ya no es necesaria con databinding

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName=myName

       // val doneButton:Button=findViewById(R.id.done_button)
        binding.doneButton
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View?){
        //val nicknameText:TextView =findViewById(R.id.nickname_name)
        //val nickname:TextView=findViewById(R.id.nickname)
        binding.apply {
            myName?.nicknname=nicknameName.text.toString()
            nicknameName.text=binding.nickname.text
            nickname.visibility=View.GONE
            view?.visibility=View.GONE
            nicknameName.visibility=View.VISIBLE
        }

        val imn=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view?.windowToken,0)



    }
}

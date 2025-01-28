package com.example.testdm.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testdm.R
import com.example.testdm.data.repository.UserRepositoryImp
import com.example.testdm.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.testdm.domain.models.UserName
import com.example.testdm.domain.usecase.GetUserName
import com.example.testdm.domain.usecase.SaveUserName

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImp(userStorage = SharedPrefUserStorage( context = applicationContext))
    }
    private val getUserNameCase by lazy(LazyThreadSafetyMode.NONE){
       GetUserName(userRepository = userRepository)
    }
    private val saveUserName by lazy(LazyThreadSafetyMode.NONE){
        SaveUserName(userRepository = userRepository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val dataTextView:TextView = findViewById(R.id.datatextView)
        val dataEditView:EditText = findViewById(R.id.dataEditText)
        val sendButton:Button = findViewById(R.id.sendButton)
        val reciveButton:Button = findViewById(R.id.reciveButton)
        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = com.example.testdm.domain.models.SaveUserNameParam(name = text)
            val result:Boolean = saveUserName.exucute(params)
            dataTextView.text = "Save result = $result"
        }
         reciveButton.setOnClickListener {
             val userName: UserName = getUserNameCase.execute()
             dataTextView.text = "${userName.firstName} ${userName.lastName}"
         }
    }
}
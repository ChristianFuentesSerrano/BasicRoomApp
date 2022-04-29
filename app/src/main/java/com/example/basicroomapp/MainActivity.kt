package com.example.basicroomapp

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*mainViewModel.saveUser(User(
            "Userid0002",
            "name0002",
            1.72,
            72.2,
            "user002@email.com",
            "passworduser0002"
        ))*/


        //si es Fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this) { usersList ->
            if (!usersList.isNullOrEmpty()) {
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)
                }
            } else {
                Log.d("thesearetheusers", "null or empty")
            }
        }

    }
}
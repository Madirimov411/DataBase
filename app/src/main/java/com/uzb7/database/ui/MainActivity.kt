package com.uzb7.database.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uzb7.database.Local.UserRepository
import com.uzb7.database.databinding.ActivityMainBinding
import com.uzb7.database.model.User

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var repository: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        repository=UserRepository(application)
        binding.apply {
            bSave.setOnClickListener {
                val name:String=etName.text.toString()
                val age:Int=etAge.text.toString().toInt()
                val password: String =etPassword.text.toString()

                val user=User(name=name,age=age, password = password)
                repository.saveUser(user)

            }
            bLoad.setOnClickListener {
                val list=repository.getUsers()
                tvUsers.text=list.toString()
            }
            bUpdate.setOnClickListener {
                val user=User(1,"Azamat",13,"12345678")
                repository.saveUser(user)
            }
            bDelete.setOnClickListener {
                repository.deleteUser(2)
            }
            bClear.setOnClickListener {
                repository.clearUsers()
            }
        }
    }
}

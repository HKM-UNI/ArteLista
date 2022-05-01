package com.hkm.openart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import com.google.firebase.auth.FirebaseAuth
import com.hkm.openart.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginFromSignUp.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // btn signup for account register
        binding.btnSignUp.setOnClickListener{
            if (binding.txtEmail.text.isNotEmpty() && checkPasswordConfirmation()){
                // FirebaseAuth to register email and password
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(binding.txtEmail.text.toString(),
                    binding.txtPassword.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }

        binding.btnLoginFromSignUp.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun checkPasswordConfirmation(): Boolean{
        if (binding.txtPassword.text.isNotEmpty() && binding.txtConfirmPassword.text.isNotEmpty())
            if (binding.txtPassword.text.toString() == binding.txtConfirmPassword.text.toString())
                return true

        return false
    }
}
package com.hkm.openart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.hkm.openart.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNoAccount.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            if (checkEmailPassword()){
                // FirebaseAuth to register email and password
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.txtEmail.text.toString(),
                        binding.txtPassword.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, MenuActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            binding.txtPassword.text!!.clear()
                            Toast.makeText(this, "Correo o contraseña equivocado", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }

    private fun checkEmailPassword(): Boolean{
        if (binding.txtEmail.text!!.isEmpty()){
            binding.txtEmail.setHintTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
            binding.txtEmail.background.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
            Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show()
            return false
        }

        if (binding.txtPassword.text!!.isEmpty()){
            binding.txtPassword.setHintTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
            binding.txtPassword.background.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
            Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }
}
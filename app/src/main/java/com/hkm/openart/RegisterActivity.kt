package com.hkm.openart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
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
            if (checkEmail() && checkPasswordConfirmation()){
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
        return when {
            binding.txtPassword.text.isEmpty() -> {
                binding.txtPassword.setHintTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                binding.txtPassword.background.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show()
                false
            }
            binding.txtConfirmPassword.text.isEmpty() -> {
                binding.txtConfirmPassword.setHintTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                binding.txtConfirmPassword.background.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show()
                false
            }
            binding.txtPassword.text.toString() != binding.txtConfirmPassword.text.toString() -> {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun checkEmail(): Boolean {
        return when {
            binding.txtEmail.text.isEmpty() -> {
                binding.txtEmail.setHintTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                binding.txtEmail.background.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                Toast.makeText(this, "Llena los campos", Toast.LENGTH_LONG).show()
                false
            }
            android.util.Patterns.EMAIL_ADDRESS.matcher(binding.txtEmail.text.toString()).matches() -> {
                true
            }
            else -> {
                Toast.makeText(this, "Correo inválido", Toast.LENGTH_LONG).show()
                binding.txtEmail.background.setTint(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                binding.txtEmail.setHintTextColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_error))
                false
            }
        }
    }
}
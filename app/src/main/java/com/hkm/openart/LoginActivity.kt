package com.hkm.openart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
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
            if (binding.txtEmail.text!!.isNotEmpty() && binding.txtPassword.text!!.isNotEmpty()){
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
                            Toast.makeText(this, "Correo o contraseña equivocado", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}
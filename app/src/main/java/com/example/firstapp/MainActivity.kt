package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstapp.databinding.ActivityMainBinding
import com.example.firstapp.databinding.TelaLinearBinding
import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnEnviar.setOnClickListener {
//            var nome = binding.edtNome.editableText.toString()
//
//            binding.tvNome.text = "Nome: " + nome
//
//            var anoNascimento = binding.edtAnoNascimento.editableText.toString()
//            val anoAtual = LocalDateTime.now().year
//            var idade = anoAtual - anoNascimento.toInt()
//
//            binding.tvIdade.text = "Idade: ${idade}"
//        }

        binding.btnEnviar.setOnClickListener {
            // Coleta as informações
            val telefone = binding.edtTelefone.editableText.toString()
            val email = binding.edtEmail.editableText.toString()

            //Verificar telefone
            if (telefone.length == 11){
                binding.tvTelefone.text = "Telefone válido"
            } else {
                binding.tvTelefone.text = "Telefone inválido"
            }

            //Verificar se o email tem @ e .com
            if (email.contains("@") && email.contains(".com")){
                val dominio = email.substringAfter("@")
                binding.tvEmail.text = "Email valido, dominio " + dominio
            } else {
                binding.tvEmail.text = "Email inválido"
            }


        }
    }









    private fun emailEstaValido(email: String): Boolean {
        val arroba = email.find { it == '@' }

        return arroba == '@'
    }

    fun getAnoAtual(): Int {
        return LocalDate.now().year
    }
}
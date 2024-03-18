package com.example.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.FragmentVerificaBinding
import java.time.LocalDate

class VerificaFragment : Fragment() {

    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerificaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            val email = binding.edtEmail.editableText.toString()

            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.text = "Email: $email"
            } else {
                binding.tvEmail.text = "Email inválido"
            }

            val telefone = binding.edtTelefone.editableText.toString()

            if (telefone.length == 11) {
                binding.tvTelefone.text = "Telefone: $telefone"
            } else {
                binding.tvTelefone.text = "Telefone: inválido"
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
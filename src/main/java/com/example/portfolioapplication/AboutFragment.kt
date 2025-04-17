package com.example.portfolioapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.portfolioapplication.databinding.FragmentAboutBinding
import com.example.portfolioapplication.databinding.FragmentContactBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        binding.tvAbout.text = """
            Hi, I'm Abhinav Kumar ingh
            I’m a first-year MCA student at Chandigarh University, passionate about learning and personal growth. My focus is on web development, data analysis, and programming languages like Python, Java, PHP, and MySQL.
        """.trimIndent()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
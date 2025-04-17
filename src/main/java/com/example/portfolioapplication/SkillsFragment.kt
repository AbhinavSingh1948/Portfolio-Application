package com.example.portfolioapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.portfolioapplication.databinding.FragmentSkillsBinding

class SkillsFragment : Fragment() {

    private var _binding: FragmentSkillsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkillsBinding.inflate(inflater, container, false)

        // Set the text content
        binding.tvSkills.text = """
            Technical Skills:
Backend(PHP, Mysql) |HTML,CSS | PYTHON | JAVA |MS Excel
            
            Soft Skills:
Team Leadership | Management & Coordination | Decision Making
        """.trimIndent()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
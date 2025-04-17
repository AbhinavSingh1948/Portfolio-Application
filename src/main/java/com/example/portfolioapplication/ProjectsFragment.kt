package com.example.portfolioapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.portfolioapplication.databinding.FragmentContactBinding
import com.example.portfolioapplication.databinding.FragmentProjectsBinding

class ProjectsFragment : Fragment() {

    private var _binding: FragmentProjectsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)

        binding.tvProjects.text = """
            Featured Projects:
            
Weather Forecasting Application
•	Developed a weather forecasting application using Python and Data Analysis techniques.
•	Used Pandas and Matplotlib to process and visualize weather trends.

Online Music Website
•	Built a dynamic online music streaming website using PHP, MySQL, and JavaScript.

        """.trimIndent()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
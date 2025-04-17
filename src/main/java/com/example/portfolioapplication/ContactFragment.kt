package com.example.portfolioapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.portfolioapplication.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)

        binding.tvContact.text = """
            Contact Information:
            
            Email: abhinavsingh4908@gmail.com
            Phone: +91 6201764908
            LinkedIn: www.linkedin.com/in/abhinav-singh-384a32233
            
            
            Available for:
            - Full-time positions
            - Freelance projects
            - Open-source contributions
        """.trimIndent()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
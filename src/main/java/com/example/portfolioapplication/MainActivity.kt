package com.example.portfolioapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.portfolioapplication.PortfolioPagerAdapter
import com.example.portfolioapplication.R
import com.example.portfolioapplication.databinding.ActivityMainBinding
import com.example.portfolioapplication.databinding.FragmentContactBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: PortfolioPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up profile picture
        binding.profileImage.setImageResource(R.drawable.resume)

        // Set up ViewPager
        viewPager = binding.viewPager
        viewPagerAdapter = PortfolioPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        // Connect TabLayout with ViewPager
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "About"
                1 -> "Skills"
                2 -> "Projects"
                else -> "Contact"
            }
        }.attach()

        // Set up SMS button
        binding.btnSendSms.setOnClickListener {
            sendSms()
        }

        // Set up call button
        binding.btnCall.setOnClickListener {
            makePhoneCall()
        }
    }

    private fun sendSms() {
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val message = binding.etMessage.text.toString()

        if (phoneNumber.isNotEmpty() && message.isNotEmpty()) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.SEND_SMS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.SEND_SMS),
                    100
                )
            } else {
                val smsManager: SmsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(phoneNumber, null, message, null, null)
                Toast.makeText(this, "SMS sent successfully!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter phone number and message", Toast.LENGTH_SHORT).show()
        }
    }

    private fun makePhoneCall() {
        val phoneNumber = binding.etPhoneNumber.text.toString()

        if (phoneNumber.isNotEmpty()) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    101
                )
            } else {
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:$phoneNumber")
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            sendSms()
        } else if (requestCode == 101 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            makePhoneCall()
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }
}
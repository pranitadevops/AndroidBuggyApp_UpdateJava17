package com.example.buggyapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.buggyapplication.*
import com.example.buggyapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val homeFragmentView : View = inflater.inflate(R.layout.fragment_home,container,false)

        val currentTimeButton: Button = homeFragmentView.findViewById(R.id.currentTime)
        currentTimeButton.setOnClickListener {
            val intent=Intent(activity,CurrentTimeActivity::class.java)
            startActivity(intent)
        }

        val currentDateButton: Button = homeFragmentView.findViewById(R.id.todayDate)
        currentDateButton.setOnClickListener {
            val intent=Intent(activity,CurrentDateActivity::class.java)
            startActivity(intent)
        }

        val softTestButton: Button = homeFragmentView.findViewById(R.id.softTestButton)
        softTestButton.setOnClickListener {
            val intent=Intent(activity,SoftTestIntroActivity::class.java)
            startActivity(intent)
        }

        val introDefectButton: Button = homeFragmentView.findViewById(R.id.defectButton)
        introDefectButton.setOnClickListener {
            val intent=Intent(activity,IntrotoBugsActivity::class.java)
            startActivity(intent)
        }


        val loginIncorrectRedirectButton: Button = homeFragmentView.findViewById(R.id.loginIncorrectRedirect)
        loginIncorrectRedirectButton.setOnClickListener {
            val intent=Intent(activity,RegistrationActivity::class.java)
            startActivity(intent)
        }

        return homeFragmentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
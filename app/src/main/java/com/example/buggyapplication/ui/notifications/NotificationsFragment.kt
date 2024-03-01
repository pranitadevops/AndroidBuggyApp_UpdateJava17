package com.example.buggyapplication.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.buggyapplication.*
import com.example.buggyapplication.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val notificationFragmentView : View = inflater.inflate(R.layout.fragment_notifications,container,false)

        val artOfGoodTestCasesButton: Button = notificationFragmentView.findViewById(R.id.artOfGoodTestCases)
        artOfGoodTestCasesButton.setOnClickListener {
            val intent= Intent(activity, ArtOfGoodTestCasesActivity::class.java)
            startActivity(intent)
        }

        val artOfQuickTestCasesButton: Button = notificationFragmentView.findViewById(R.id.artOfQuickTestCases)
        artOfQuickTestCasesButton.setOnClickListener {
            val intent= Intent(activity, ArtOfQuickTestCasesActivity::class.java)
            startActivity(intent)
        }

        val resetPasswordButton: Button = notificationFragmentView.findViewById(R.id.resetPassword)
        resetPasswordButton.setOnClickListener {
            val intent= Intent(activity, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        val settingsButton: Button = notificationFragmentView.findViewById(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent= Intent(activity, SettingsActivity::class.java)
            startActivity(intent)
        }

        val userInfoButton: Button = notificationFragmentView.findViewById(R.id.UserInfo)
        userInfoButton.setOnClickListener {
            val intent= Intent(activity, UserInfoActivity::class.java)
            startActivity(intent)
        }

        return notificationFragmentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
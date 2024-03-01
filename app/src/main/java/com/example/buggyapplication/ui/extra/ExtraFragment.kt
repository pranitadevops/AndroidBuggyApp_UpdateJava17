package com.example.buggyapplication.ui.dashboard

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.buggyapplication.*
import com.example.buggyapplication.databinding.FragmentExtraBinding

class ExtraFragment : Fragment() {

    private lateinit var extraViewModel: ExtraViewModel
    private var _binding: FragmentExtraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val extraFragmentView : View = inflater.inflate(R.layout.fragment_extra,container,false)

        val filtersButton: Button = extraFragmentView.findViewById(R.id.filters)
        filtersButton.setOnClickListener {
            val intent= Intent(activity, FilterActivity::class.java)
            startActivity(intent)
        }

        val mapButton: Button = extraFragmentView.findViewById(R.id.mapLocate)
        mapButton.setOnClickListener {

            val intent= Intent(activity, MapActivity::class.java)
            startActivity(intent)

            val builder = AlertDialog.Builder(requireActivity(),2)
            builder.setTitle("Error")
                .setMessage("{\n" +
                        "  \"message\": \"test_set does not exist\",\n" +
                        "  \"details\": {},\n" +
                        "  \"description\": \"The reference set does not exist.\",\n" +
                        "  \"code\": 1002,\n" +
                        "  \"http_response\": {\n" +
                        "     \"message\": \"We could not find the resource you requested.\",\n" +
                        "      \"code\": 404\n" +
                        "   }\n" +
                        "}")
                .setPositiveButton("OK") { _, _ -> }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }

        val externalButton: Button = extraFragmentView.findViewById(R.id.externalLink)
        externalButton.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://www.google.com/")
            startActivity(urlIntent)
        }

        val feedbackButton: Button = extraFragmentView.findViewById(R.id.feedBackForm)
        feedbackButton.setOnClickListener {
            val intent= Intent(activity, FeedbackActivity::class.java)
            startActivity(intent)
        }

        val videoAdsButton: Button = extraFragmentView.findViewById(R.id.videoButton)
        videoAdsButton.setOnClickListener {
            val intent= Intent(activity, VideoActivity::class.java)
            startActivity(intent)
        }


        return extraFragmentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
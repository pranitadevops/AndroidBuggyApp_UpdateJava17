package com.example.buggyapplication

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {

    // declaring a null variable for VideoView
    var simpleVideoView: VideoView? = null
    var simpleNonWorkingVideoView: VideoView? = null

    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        simpleVideoView = findViewById<View>(R.id.videoViewNonWorking) as VideoView
        simpleNonWorkingVideoView = findViewById<View>(R.id.videoViewWorking) as VideoView

        if (mediaControls == null) {
            // creating an object of media controller class
            mediaControls = MediaController(this)

            // set the anchor view for the video view
            mediaControls!!.setAnchorView(this.simpleVideoView)
            mediaControls!!.setAnchorView(this.simpleNonWorkingVideoView)
        }

        // set the media controller for video view
        simpleVideoView!!.setMediaController(mediaControls)
        simpleNonWorkingVideoView!!.setMediaController(mediaControls)

        // set the absolute path of the video file which is going to be played
        simpleVideoView!!.setVideoURI(
            //Uri.parse("android.resource://" + packageName + "/" + R.raw.gfgvideo))

        Uri.parse("https://www.youtube.com/watch?v=DKXkyzBV5Hw&list=PLQ7x7oTdExNIcM1lhKw1KdBeAq_VYD6fX&index=1"))

        simpleNonWorkingVideoView!!.setVideoURI(
            Uri.parse("android.resource://" + packageName + "/" + R.raw.gfgvideo))

        simpleVideoView!!.requestFocus()
        simpleNonWorkingVideoView!!.requestFocus()

        // starting the video
        simpleVideoView!!.start()
        simpleNonWorkingVideoView!!.start()

        // display a toast message
        // after the video is completed
        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video 2 is not completed",
                Toast.LENGTH_LONG).show()
        }

        simpleNonWorkingVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video 1 is completed",
                Toast.LENGTH_LONG).show()
        }

        // display a toast message if any
        // error occurs while playing the video
        simpleVideoView!!.setOnErrorListener { _, _, _ ->
            Toast.makeText(applicationContext, "An Error Occured " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }

        simpleNonWorkingVideoView!!.setOnErrorListener { _, _, _ ->
            Toast.makeText(applicationContext, "An Error Occured " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }
    }
}
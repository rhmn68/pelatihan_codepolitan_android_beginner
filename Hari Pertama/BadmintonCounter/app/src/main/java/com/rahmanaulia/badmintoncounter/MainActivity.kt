package com.rahmanaulia.badmintoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddTeamA.setOnClickListener {
            scoreTeamA += 1
            tvScoreTeamA.text = scoreTeamA.toString()
        }

        btnMinusTeamA.setOnClickListener {
            scoreTeamA -= 1
            tvScoreTeamA.text = scoreTeamA.toString()
        }

        btnAddTeamB.setOnClickListener {
            scoreTeamB += 1
            tvScoreTeamB.text = scoreTeamB.toString()
        }

        btnMinusTeamB.setOnClickListener {
            scoreTeamB -= 1
            tvScoreTeamB.text = scoreTeamB.toString()
        }

        btnReset.setOnClickListener {
            scoreTeamA = 0
            scoreTeamB = 0
            tvScoreTeamA.text = scoreTeamA.toString()
            tvScoreTeamB.text = scoreTeamB.toString()
        }
    }
}

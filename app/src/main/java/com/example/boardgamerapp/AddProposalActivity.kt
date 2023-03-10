package com.example.boardgamerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AddProposalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_proposal)
        val btnAddProposalActivity = findViewById<Button>(R.id.btnAddProposal)
        val userInputGameName = findViewById<TextView>(R.id.etProposal)
        val tabellenname = intent.getStringExtra("TABELLENNAME")
        val dbhelper = DB_class(applicationContext)
        val db = dbhelper.readableDatabase

        btnAddProposalActivity.setOnClickListener{
            db?.execSQL("INSERT INTO $tabellenname(GAME_NAME) VALUES ('${userInputGameName.text}')")
            Toast.makeText(
                this@AddProposalActivity,
                " '${userInputGameName.text}' wurde hinzugefügt",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this, ProposalAndVoteActivity::class.java))
    }
}
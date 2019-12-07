package com.abdullah.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import com.abdullah.swoosh.Model.Player
import com.abdullah.swoosh.R
import com.abdullah.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginerClick(view: View) {
        ballerSkillBtn.isChecked = false

        if(beginerSkillBtn.isChecked)
            player.skill = "begginer"
        else
            player.skill = ""
    }
    fun onBallerClick(view: View) {
        beginerSkillBtn.isChecked = false

        if(ballerSkillBtn.isChecked)
            player.skill = "baller"
        else
            player.skill = ""
    }
    fun onSkillFinishClicked(view: View) {
        if(player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        }else
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
    }
}

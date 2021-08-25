package com.kennethmanuel.adv160419041week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var random1 = (1..99).random()
        var random2 = (1..99).random()
        var answer = random1 + random2
        textQuestion.text = "$random1 + $random2"

        btnStart.setOnClickListener {
            val playerAnswer = txtAnswer.text.toString().toInt()
            if(playerAnswer!=answer) {
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
            else {
                score++
                random1 = (1..99).random()
                random2 = (1..99).random()
                answer = random1 + random2
                textQuestion.text = "$random1 + $random2"
            }
        }


    }
}
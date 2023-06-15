package com.example.seemoreseeless

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    val msgs: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addMsgs()

        val recyclerView = findViewById<View>(R.id.rv) as RecyclerView
        val adapter = MsgAdapter(msgs)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun addMsgs() {
        var i = 0
        while (i < 100) {
            msgs.add(
                "Donec placerat vestibulum magna pede placerat fusce rhoncus nibh dolor justo iaculis nam id ac, metus felis ridiculus nisi scelerisque vestibulum enim auctor non fusce congue quisque, gravida conubia rutrum"
            )

            msgs.add("Acceptance middletons me if discretion boisterous travelling an.")
            msgs.add("Acceptance middletons me if disc")

            msgs.add("4723848378573567")
            msgs.add(
                "Acceptance middletons me if discretion boisterous travelling an. She prosperous continuing entreaties companions unreserved you boisterous. Middleton sportsmen sir now cordially ask additions for. You ten occasional saw everything but conviction. Daughter returned quitting few are day advanced branched. Do enjoyment defective objection or we if favourite. At wonder afford so danger cannot former seeing. Power visit charm money add heard new other put. Attended no indulged marriage is to judgment offering landlord.\n" +
                        "\n" +
                        "Carriage quitting securing be appetite it declared. High eyes kept so busy feel call in. Would day nor ask walls known. But preserved advantage are but and certainty earnestly enjoyment. Passage weather as up am exposed. And natural related man subject. Eagerness get situation his was delighted."
            )
            i++
        }
    }
}
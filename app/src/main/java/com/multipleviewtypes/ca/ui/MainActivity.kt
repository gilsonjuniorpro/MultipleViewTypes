package com.multipleviewtypes.ca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.multipleviewtypes.ca.R
import com.multipleviewtypes.ca.adapters.HeroesAdapter
import com.multipleviewtypes.ca.models.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val IRON_MAN = 0
        const val CAPTAIN_AMERICA = 1
        const val THOR = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: MutableList<Item> = ArrayList()

        val ironMan = Hero(
            R.drawable.ironman,
            "Iron Man",
            "Iron Man is a 2008 American superhero film based on the Marvel Comics character of the same name."
        )
        items.add(Item(IRON_MAN, ironMan))

        val thor = Hero(
            R.drawable.thor,
            "Thor",
            "Thor is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania"
        )
        items.add(Item(THOR, thor))

        val captain = Hero(
            R.drawable.captain,
            "American Captain",
            "Captain America is a fictional superhero appearing in American comic books published by Marvel Comics."
        )
        items.add(Item(CAPTAIN_AMERICA, captain))

        items.add(Item(IRON_MAN, ironMan))
        items.add(Item(THOR, thor))
        items.add(Item(CAPTAIN_AMERICA, captain))

        items.add(Item(IRON_MAN, ironMan))
        items.add(Item(THOR, thor))
        items.add(Item(CAPTAIN_AMERICA, captain))

        recyclerView.adapter = HeroesAdapter(items)
    }
}
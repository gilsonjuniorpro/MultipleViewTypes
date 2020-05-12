package com.multipleviewtypes.ca.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.multipleviewtypes.ca.R
import com.multipleviewtypes.ca.adapters.HeroesAdapter
import com.multipleviewtypes.ca.models.Captain
import com.multipleviewtypes.ca.models.IronMan
import com.multipleviewtypes.ca.models.Item
import com.multipleviewtypes.ca.models.Thor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items: MutableList<Item> = ArrayList()

        var ironMan = IronMan(
            R.drawable.ironman,
            "Iron Man",
            "Iron Man is a 2008 American superhero film based on the Marvel Comics character of the same name."
        )
        items.add(Item(0, ironMan))

        var thor = Thor(
            R.drawable.thor,
            "Thor",
            "Thor is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania"
        )
        items.add(Item(1, thor))

        var captain = Captain(
            R.drawable.captain,
            "American Captain",
            "Captain America is a fictional superhero appearing in American comic books published by Marvel Comics."
        )
        items.add(Item(2, captain))

        items.add(Item(0, ironMan))
        items.add(Item(1, thor))
        items.add(Item(2, captain))

        items.add(Item(0, ironMan))
        items.add(Item(1, thor))
        items.add(Item(2, captain))


        recyclerView.adapter = HeroesAdapter(items)
    }
}
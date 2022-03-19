package es.avifer.applistheaderseemore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.avifer.listheaderseemore.ListHeaderSeeMore

class MainActivity : AppCompatActivity() {

    private val listExample =
        listOf(
            "Example element 1",
            "Example element 2",
            "Example element 3",
            "Example element 4",
            "Example element 5",
            "Example element 6",
            "Example element 7",
            "Example element 8",
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(findViewById<ListHeaderSeeMore>(R.id.activity_main__list_header_see_more__list)) {
            setOnClickSeeMore {
                Toast.makeText(this@MainActivity, "Click in see more", Toast.LENGTH_SHORT).show()
            }
            setAdapter(AdapterListHeaderSeeMore(listExample))
        }
    }
}
package com.example.movieapp

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.movieapp.views.NowPlayingMoviesFragment
import com.example.movieapp.views.PopularMoviesFragment
import com.example.movieapp.views.TopRatedMoviesFragment
import com.example.movieapp.views.UpcomingMoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        addPopularMoviesFragment(savedInstanceState)
        showCategoryMenu()
    }

    private fun addPopularMoviesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<PopularMoviesFragment>(R.id.fragmentContainerView)
            }
        }
    }

    private fun showCategoryMenu() {
        val categoryButton: Button = findViewById(R.id.category_button)
        categoryButton.setOnClickListener(View.OnClickListener {
            val popupMenu = PopupMenu(this, categoryButton)
            popupMenu.menuInflater.inflate(
                    R.menu.category,
                    popupMenu.menu
            )
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                when (it.itemId) {
                    R.id.popular -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<PopularMoviesFragment>(R.id.fragmentContainerView)
                        }
                        true
                    }
                    R.id.upcoming -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<UpcomingMoviesFragment>(R.id.fragmentContainerView)
                        }
                        true
                    }
                    R.id.topRated -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<TopRatedMoviesFragment>(R.id.fragmentContainerView)
                        }
                        true
                    }
                    R.id.nowPlaying -> {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<NowPlayingMoviesFragment>(R.id.fragmentContainerView)
                        }
                        true
                    } else -> false
                }
            })
            popupMenu.show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}


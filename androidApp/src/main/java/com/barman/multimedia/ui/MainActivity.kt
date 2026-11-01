package com.barman.multimedia.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.barman.multimedia.R
import com.barman.multimedia.databinding.ActivityMainBinding
import com.barman.multimedia.ui.broadcast.BroadcastReceiverFragment
import com.barman.multimedia.ui.image.ImageScaleFragment
import com.barman.multimedia.ui.media.AudioFragment
import com.barman.multimedia.ui.media.VideoFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.open_drawer,
            R.string.close_drawer,
        )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_broadcast -> BroadcastReceiverFragment()
                R.id.nav_image -> ImageScaleFragment()
                R.id.nav_video -> VideoFragment()
                R.id.nav_audio -> AudioFragment()
                else -> null
            }

            fragment?.let {
                showFragment(it, item.title.toString())
                item.isChecked = true
                binding.drawerLayout.closeDrawers()
                true
            } ?: false
        }

        if (savedInstanceState == null) {
            binding.navigationView.setCheckedItem(R.id.nav_broadcast)
            showFragment(BroadcastReceiverFragment(), getString(R.string.nav_broadcast_receiver))
        }
    }

    private fun showFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        binding.toolbar.title = title
    }
}

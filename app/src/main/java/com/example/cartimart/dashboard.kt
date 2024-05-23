package com.example.cartimart

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.cartimart.databinding.ActivityDashboardBinding

class dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val leftIcon = findViewById<ImageView>(R.id.left_icon)
        val rightIcon = findViewById<ImageView>(R.id.right_icon)
        val title = findViewById<ImageView>(R.id.toolbar_title)



        rightIcon.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }



        binding.apply {
            toggle = ActionBarDrawerToggle(
                this@dashboard,
                drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            // Disable swipe gesture for opening the drawer
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

            navView.setNavigationItemSelectedListener { menuItem ->
                // Handle item selection here
                when (menuItem.itemId) {
                    R.id.abt_item -> {
                        val intent = Intent(this@dashboard, About::class.java)
                        startActivity(intent)
                    }
                    R.id.cnt_item -> {
                        val intent = Intent(this@dashboard, contactus::class.java)
                        startActivity(intent)
                    }
                    R.id.lg_item -> {
                        val intent = Intent(this@dashboard, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }
                // Close the drawer
                drawerLayout.closeDrawer(GravityCompat.END)
                true
            }
        }

        // Add the fragment replacement logic here
        replaceFragment(Home2())

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(Home2())
                R.id.profile -> replaceFragment(Profile2())
                R.id.list -> replaceFragment(List2())
                R.id.cart -> replaceFragment(Cart2())
                R.id.pending -> replaceFragment(PendingFragment())
                else -> {
                    // Handle other cases if needed
                }
            }   
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}

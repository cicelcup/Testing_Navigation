package com.example.testing_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.ui.navigateUp
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Host Fragment
        val host = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        //NavigationController
        val navigationController = host.navController

       //Tool Bar configuration
        val drawerLayout : DrawerLayout? = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentOne,R.id.musicFragment,R.id.imagesFragment),drawerLayout
        )

        setBottomMenu(navigationController)

        setDrawerMenu(navigationController)

        setToolBar(navigationController,appBarConfiguration)
    }

    private fun setToolBar(navigationController: NavController,
                           appBarConfiguration: AppBarConfiguration) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navigationController,appBarConfiguration)
    }

    private fun setBottomMenu(navigationController: NavController) {
        val bottomMenu =
            findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomMenu?.setupWithNavController(navigationController)
    }

    private fun setDrawerMenu(navigationController: NavController) {
        val slideNavigation =
            findViewById<NavigationView>(R.id.navigation_slide)
        slideNavigation?.setupWithNavController(navigationController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_right_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }
}

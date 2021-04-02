package com.jjongflickerman.alarmui1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instance of our fragments
        val firstFragment = FirstFragmentClass()
        val secondFragment = SecondFragmentClass()
        val thirdFragment = ThirdFragmentClass()

        //set the initial frgament when we open the app
        setCurrentFragment(firstFragment)

        // id_bottomNavigationView inside activity_main.xml
        val btmNavView = findViewById<BottomNavigationView>(R.id.id_bottomNavigationView)
        btmNavView.setOnNavigationItemSelectedListener {
            // 1) .setOnNav....Listener() 메써드는 onNavigationxxListener(인터페이스를 implement 한 인자를 람다로 받음)
            //2) OnNavigationItemSelectedListener(인터페이스) 안에는 onNavItemSelected(boolean 리턴 메써드) 하나만 있음. 그래서 override 생략 가능sam..
            when(it.itemId) {
                R.id.id_Home -> setCurrentFragment(firstFragment)
             R.id.id_Message -> setCurrentFragment(secondFragment)
                R.id.id_Profile -> setCurrentFragment(thirdFragment)
            }
            true
            // we don't write return true in the lambda function, it will always return the last line of that function
        }
        // 아이콘 옆에 badge 추가 방법!
        btmNavView.getOrCreateBadge(R.id.id_Message).apply {
            number = 5
            isVisible = true
        }


    }

    // replace our current fragment with a new one.
    private fun setCurrentFragment(receivedFragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{ //supportFragmentManager = get FragmentManager() class
        replace(R.id.id_flFragment, receivedFragment)
            commit()
        }

}
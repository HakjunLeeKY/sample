package com.cookandroid.project6

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlin.time.minutes

@Suppress("deprecation")
class MainActivity : AppCompatActivity(), ActionBar.TabListener {

    lateinit var tabSong : ActionBar.Tab
    lateinit var tabArtist : ActionBar.Tab
    lateinit var tabAlbum : ActionBar.Tab
    var myFrags = arrayOfNulls<MyTabFragment>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bar = this.supportActionBar
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        tabSong = bar.newTab()
        tabSong.text = "음악별"
        tabSong.setTabListener(this)
        bar.addTab(tabSong)

        tabArtist = bar.newTab()
        tabArtist.text = "가수별"
        tabArtist.setTabListener(this)
        bar.addTab(tabArtist)

        tabAlbum = bar.newTab()
        tabAlbum.text = "앨범별"
        tabAlbum.setTabListener(this)
        bar.addTab(tabAlbum)

    }
    override fun onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        var myTabFrag : MyTabFragment? = null

        if (myFrags[tab.position] == null) {
            myTabFrag = MyTabFragment()
            val data = Bundle()
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            myFrags[tab.position] = myTabFrag
        } else
            myTabFrag = myFrags[tab.position]

        ft.replace(android.R.id.content, myTabFrag!!)
    }
    override fun onTabUnselected(tab: ActionBar.Tab, ft: FragmentTransaction) {}
    override fun onTabReselected(tab: ActionBar.Tab, ft: FragmentTransaction) {}

    class MyTabFragment : androidx.fragment.app.Fragment() {
        var tabName : String? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            var data = arguments
            tabName = data!!.getString("tabName")
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View? {
            var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = params
            if (tabName === "음악별") baseLayout.setBackgroundColor(Color.RED)
            if (tabName === "가수별") baseLayout.setBackgroundColor(Color.GREEN)
            if (tabName === "앨범별") baseLayout.setBackgroundColor(Color.BLUE)

            return baseLayout
        }
    }

}

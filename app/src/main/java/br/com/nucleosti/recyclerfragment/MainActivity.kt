package br.com.nucleosti.recyclerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), CharacterListFragment.OnListSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_root, CharacterListFragment.newInstance(),
                    "characterList")
                .commit()
        }
    }

    override fun onSelected(character: Character) {
        val args = Bundle()
        args.putSerializable("detail", character)

        val fragment = CharacterDetailFragment.newInstance()
        fragment.arguments = args

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_root, fragment, "fragmentDetail")
            .addToBackStack(null)
            .commit()
    }
}

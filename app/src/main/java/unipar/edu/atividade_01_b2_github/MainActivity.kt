package unipar.edu.atividade_01_b2_github

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import unipar.edu.atividade_01_b2_github.adapter.Adapter
import unipar.edu.atividade_01_b2_github.data.Person

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonAdd: Button
    private val itemList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        editTextAge = findViewById(R.id.editTextAge)
        buttonAdd = findViewById(R.id.buttonAdd)

        adapter = Adapter(itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val surname = editTextSurname.text.toString()
            val ageText = editTextAge.text.toString()

            if (name.isNotEmpty() && surname.isNotEmpty() && ageText.isNotEmpty()) {
                val age = ageText.toInt()
                val person = Person(name, surname, age)
                itemList.add(person)
                adapter.notifyItemInserted(itemList.size - 1)
                editTextName.text.clear()
                editTextSurname.text.clear()
                editTextAge.text.clear()
            }
        }
    }
}